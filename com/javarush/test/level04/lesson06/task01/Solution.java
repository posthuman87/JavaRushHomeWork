package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String a = rd.readLine();
        String b = rd.readLine();
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        if (x<y)
            System.out.println(x);
        else
            System.out.println(y);
        //напишите тут ваш код

    }
}