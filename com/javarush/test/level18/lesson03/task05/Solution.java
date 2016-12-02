package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileIn = new FileInputStream(fileName);
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list1  = new ArrayList<Integer>();
        while (fileIn.available() > 0) {
            list1.add(fileIn.read());
        }
        for (int x : list1) {
            if (!list.contains(x))
            {
                list.add(x);
            }
        }
        Sort(list);
        reader.close();
        fileIn.close();
    }

    public static void Sort (ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++){
            for (int j = i+1; j < list.size(); j++){
                if (list.get(j) < list.get(i)){
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        for (int x : list)
        {
            System.out.print(x + " ");
        }
    }
}
