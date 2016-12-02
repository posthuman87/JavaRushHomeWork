package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileIn = new FileInputStream(fileName);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (fileIn.available() > 0) {
            list.add(fileIn.read());
        }
        reader.close();
        fileIn.close();
        Set<Integer> set = notPopular(list);
        for (Integer x : set) {
            System.out.print(x + " ");
        }
    }

    public static Map<Integer, Integer> getMap (ArrayList<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : list)
        {
            Integer count = map.get(x);
            if (count == null)
                count = 0;
            count++;
            map.put(x, count);
        }
        return map;
    }

    public static Set<Integer> notPopular (ArrayList<Integer> list) {
        Map<Integer, Integer> map = getMap(list);
        Collection<Integer> values = map.values();
        int min = Collections.min(values);
        Set<Integer> result = new HashSet<>();
        for (Map.Entry<Integer, Integer> element : map.entrySet()) {
            if (element.getValue().equals(min))
                result.add(element.getKey());
        }
        return result;
    }
}
