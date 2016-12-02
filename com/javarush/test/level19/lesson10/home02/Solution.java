package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String,Double> map = new HashMap<>();
        String line;
        Double values;
        ArrayList<Double> set = new ArrayList<>();

        while((line = reader.readLine())!=null){
            String[] strings = line.split(" ");
            if (map.containsKey(strings)){
                values = map.get(strings[0])+Double.parseDouble(strings[1]);
                map.put(strings[0],values);
            }
            else
                map.put(strings[0],Double.parseDouble(strings[1]));
        }

        for(Map.Entry<String,Double> res : map.entrySet()){
            set.add(res.getValue());
        }

        Double max = Double.MIN_VALUE;
        for(Double doub : set){
            if (doub > max) max = doub;
        }

        for(Map.Entry<String,Double> m : map.entrySet()){
            if (m.getValue() == max){
                System.out.println(m.getKey());
            }
        }
        reader.close();
    }
}
