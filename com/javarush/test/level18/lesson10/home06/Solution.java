package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        String fileName = args[0];

        FileInputStream inputStream = new FileInputStream(fileName);
        byte[] buff = new byte[inputStream.available()];
        inputStream.read(buff);
        String s = new String(buff);
        char[] chars = s.toCharArray();

        TreeMap<Character,Integer> map = getMap(chars);
        for(Map.Entry<Character,Integer> m : map.entrySet())
        {
            System.out.println(m.getKey() + " " + m.getValue());
        }
        inputStream.close();
    }

    public static TreeMap<Character, Integer> getMap(char[] chars){
        TreeMap<Character,Integer> result = new TreeMap<>();
        for(Character ch : chars){
            Integer count = result.get(ch);
            if (count == null)
                count = 0;
            count++;
            result.put(ch,count);
        }
        return result;
    }

}
