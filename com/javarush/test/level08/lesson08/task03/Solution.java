package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("бондарь", "Олег");
        map.put("кунцевич", "Леша");
        map.put("прилищ", "Олег");
        map.put("репников", "Вова");
        map.put("сивый", "Юра");
        map.put("плющ", "Артем");
        map.put("субботницкий", "Ваня");
        map.put("кравченко", "Вика");
        map.put("плескач", "Сергей");
        map.put("кулабухов", "Андрей");//напишите тут ваш код
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;
        for (Map.Entry<String, String> m : map.entrySet() ){
            if (m.getValue().equals(name)) count++;//напишите тут ваш код
        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int count1 = 0;
        for (Map.Entry<String, String> m : map.entrySet() ){
            if (m.getKey().equals(lastName)) count1++;//напишите тут ваш код
        }
        return count1;//напишите тут ваш код

    }
}
