package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        char[] list = s.toCharArray();
        ArrayList<Character> l = new ArrayList<Character>();

        for (int i = 0; i < list.length; i++){
            l.add(list[i]);
        }
        for (int i = 0; i < 40; i++){
            for (int j = 0; j < l.size(); j++){
                System.out.print(l.get(j));
            }
            System.out.println();
            l.remove(0);//напишите тут ваш код
        }
    }

}
