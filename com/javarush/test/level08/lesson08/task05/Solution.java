package com.javarush.test.level08.lesson08.task05;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Stalone1", "A");
        map.put("Stalone2", "B");
        map.put("Stalone3", "F");
        map.put("Stalone4", "A");
        map.put("Stalone5", "B");
        map.put("Stalone6", "D");
        map.put("Stalone7", "A");
        map.put("Stalone8", "S");
        map.put("Stalone9", "L");
        map.put("Stalone10", "B");
        return map;//напишите тут ваш код

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        {
            HashMap<String, String> copy = new HashMap<String, String>(map);
            for (String value : copy.values())
                if (Collections.frequency(copy.values(), value) > 1)
                    removeItemFromMapByValue(map, value);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
