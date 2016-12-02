package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream input = new FileInputStream(fileName);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(input.available()>0){
            list.add(input.read());
        }
        reader.close();
        input.close();
        for (int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                if (list.get(j) > list.get(i))
                {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println(list.get(0));
    }
}
