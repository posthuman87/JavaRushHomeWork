package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int a=0;
        int i = 1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (i>0)
        {
            String s = reader.readLine();
            if (!s.equals("сумма"))
            {
                int x = Integer.parseInt(s);
                a = a + x;
            }
            else
            {
                System.out.print(a);
                break;
            }

        }
        //напишите тут ваш код
    }
}
