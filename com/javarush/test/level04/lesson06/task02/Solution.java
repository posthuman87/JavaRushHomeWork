package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String a = rd.readLine();
        String b = rd.readLine();
        String c = rd.readLine();
        String d = rd.readLine();
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        int z = Integer.parseInt(c);
        int v = Integer.parseInt(d);
        if ((x>y)&&(x>z)&&(x>v)) System.out.println(x);
        if ((y>x)&&(y>z)&&(y>v)) System.out.println(y);
        if ((z>x)&&(z>y)&&(z>v)) System.out.println(z);
        if ((v>x)&&(v>y)&&(v>z)) System.out.println(v);
        //напишите тут ваш код

    }
}
