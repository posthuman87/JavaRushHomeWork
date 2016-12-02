package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        String s = "JANUARY 1 2000";
        System.out.println(s + " = "+isDateOdd(s));
    }

    public static boolean isDateOdd(String date)
    {
        Date thisDate = new Date(date);
        Date copy = new Date(date);
        copy.setHours(0);
        copy.setMinutes(0);
        copy.setSeconds(0);
        copy.setDate(0);
        copy.setMonth(0);
        long result = thisDate.getTime() - copy.getTime();
        long msDay = 24 * 60 *60 * 1000;
        int days = (int)(result/msDay);
        if (days%2 == 0) return false;
        else
        return true;
    }
}
