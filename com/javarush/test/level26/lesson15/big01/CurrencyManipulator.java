package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Администратор on 15.07.2016.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations.keySet().contains(denomination))
        {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else
            denominations.put(denomination, count);
    }

    public int getTotalAmount(){
        int total = 0;
        for (Map.Entry<Integer,Integer> m : denominations.entrySet())
        {
            total+=m.getKey()*m.getValue();
        }
        return total;
    }

    public boolean hasMoney(){
        return denominations.size() != 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return expectedAmount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException{

        int sum = expectedAmount;
        HashMap<Integer,Integer> temp = new HashMap<>();
        temp.putAll(denominations);
        ArrayList<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer,Integer> map : temp.entrySet()){
            list.add(map.getKey());
        }

        Collections.sort(list);
        Collections.reverse(list);

        TreeMap<Integer,Integer> result = new TreeMap<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });

        for (Integer aList : list)
        {
            int key = aList;
            int value = temp.get(key);
            while (true) {
                if (sum < key || value <= 0) {
                    temp.put(key,value);
                    break;
                }
                sum-=key;
                value--;

                if (result.containsKey(key))
                    result.put(key,result.get(key)+1);
                else
                    result.put(key,1);
            }
        }

        if (sum > 0)
            throw new NotEnoughMoneyException();
        else
        {
            for (Map.Entry<Integer,Integer> m : result.entrySet())
            {
                ConsoleHelper.writeMessage("\t" + m.getKey() + " - " + m.getValue());
            }

            denominations.clear();
            denominations.putAll(temp);
        }
        return result;
    }
}
