package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        String c = reader.readLine();
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        int z = Integer.parseInt(c);
        int m=0,n=0,v=0;

        if ((x>y)&&(x<z)) {
            m  = z;
            n = x;
            v = y;
        }
        if ((x<y)&&(x>z)) {
            m = y;
            n = x;
            v = z;
        }
        if ((y>x)&&(y<z)) {
            m = z;
            n = y;
            v = x;
        }
        if ((y<x)&&(y>z)) {
            m = x;
            n = y;
            v = z;
        }
        if ((z>y)&&(x>z)) {
            m = x;
            n = z;
            v = y;
        }
        if ((z>x)&&(z<y)) {
            m = y;
            n = z;
            v = x;
        }
        System.out.println(m);
        System.out.println(n);
        System.out.println(v);
        //напишите тут ваш код

    }
}
