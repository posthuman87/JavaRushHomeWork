package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int m = 0;
        if ((a>0)&&(b<0)&&(c<0)||(a<0)&&(b>0)&&(c<0)||(a<0)&&(b<0)&&(c>0)) m = 1;
        if ((a>0)&&(b>0)&&(c<0)||(a<0)&&(b>0)&&(c>0)||(a>0)&&(b<0)&&(c>0)) m = 2;
        if ((a>0)&&(b>0)&&(c>0)) m = 3;
        System.out.println(m);
        //напишите тут ваш код

    }
}
