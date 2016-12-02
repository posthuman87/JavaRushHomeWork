package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String,Double> map = new TreeMap<String,Double>();
        String line;
        Double Cvalue;
        while((line = reader.readLine()) != null){
            String[] text = line.split(" ");
            if(map.containsKey(text[0])){
                Cvalue = map.get(text[0])+Double.parseDouble(text[1]);
                map.put(text[0],Cvalue);
            } else
                map.put(text[0],Double.parseDouble(text[1]));
        }
        reader.close();

        for(Map.Entry<String,Double> m : map.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}
