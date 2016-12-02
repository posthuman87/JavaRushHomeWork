package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной
5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> mass = new ArrayList<int[]>();
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7};
        int[] c = {8, 9, 10, 11};
        int[] d = {12, 13, 14, 15, 16, 17, 18};
        int[] e = new int[0];
        mass.add(a);
        mass.add(b);
        mass.add(c);
        mass.add(d);
        mass.add(e);
        return mass;
        //напишите тут ваш код
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
