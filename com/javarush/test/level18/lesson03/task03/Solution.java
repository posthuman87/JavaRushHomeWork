package com.javarush.test.level18.lesson03.task03;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        ArrayList<Integer> list = new ArrayList<Integer>();
        try
        {
            FileInputStream fileIn = new FileInputStream(fileName);
            while (fileIn.available() > 0)
            {
                list.add(fileIn.read());
            }
            Set<Integer> set = maxR(list);
            for (Integer x : set)
            {
                System.out.print(x + " ");
            }
            reader.close();
            fileIn.close();
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
    }

    public static Map<Integer, Integer> getMap (ArrayList<Integer> list){
        Map<Integer, Integer> result = new HashMap<>();
        for (int x : list) {
            Integer count = result.get(x);
            if (count == null)
                count = 0;
            count++;
            result.put(x, count);
        }
        return result;
    }

    public static Set<Integer> maxR (ArrayList<Integer> list) {
        Map<Integer, Integer> map = getMap(list);
        Collection<Integer> values = map.values();
        Integer max = Collections.max(values);
        Set<Integer> result = new HashSet<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (max.equals(entry.getValue()))
                result.add(entry.getKey());
        }
        return result;
    }
}
