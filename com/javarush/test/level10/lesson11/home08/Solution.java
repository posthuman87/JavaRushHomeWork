package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] l = new ArrayList[2];
        ArrayList<String> list = new ArrayList<String>();
        list.add("Mama ");
        list.add("mila ");
        list.add("ramu.");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("Eto ");
        list2.add("vse ");
        list2.add("ona-na-na-na-na");
        l[0] = list;
        l[1] = list2;

        return l;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}