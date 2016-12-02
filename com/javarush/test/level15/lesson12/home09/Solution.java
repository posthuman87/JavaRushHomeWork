package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] url = reader.readLine().split("[?&]");
        String str = "";
        for (int i = 1; i < url.length; i++){
            if (url[i].contains("=")){
                str+=url[i].substring(0,url[i].indexOf("="))+" ";
            }
            else
                str+=url[i]+" ";
        }
        str.trim();
        System.out.print(str.replaceAll("[\\s]{2,}", " "));
        System.out.println();
        for (int i = 0;  i < url.length; i++){
            try
            {
                if (url[i].length() > 0 && url[i].substring(0, url[i].indexOf("=")).equals("obj"))
                {
                    try
                    {
                        alert(Double.parseDouble(url[i].substring(url[i].indexOf("=") + 1, url[i].length())));
                    }
                    catch (Exception e)
                    {
                        alert(url[i].substring(url[i].indexOf("=") + 1, url[i].length()));
                    }
                }
            }
            catch (Exception ex){}
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
