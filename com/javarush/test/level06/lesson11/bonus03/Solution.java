package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++){
            int s = Integer.parseInt(reader.readLine());
            list.add(s);//напишите тут ваш код
        }

        for (int i = 0; i < list.size(); i++){
            for (int j = i + 1; j < list.size(); j++){
                int tmp;
                if (list.get(j) < list.get(i)){
                    tmp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, tmp);
                }
            }
        }

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}
