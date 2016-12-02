package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static void main(String[] args)
    {
        Map<String,String> map = new HashMap<String, String>();
        map.put("name","Ivanov");
        map.put("country","Ukraine");
        map.put("city","Kiev");
        map.put("age",null);

        System.out.println(getCondition(map).toString());

    }

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder sb = new StringBuilder("");
        for (Map.Entry<String,String> map : params.entrySet())
        {
          if (map.getKey()!=null&&map.getValue()!=null){
              String s  = String.format("%s = '%s'",map.getKey(),map.getValue());
              if (sb.toString().equals(""))
                  sb = sb.append(s);
              else
                  sb = sb.append(" and ").append(s);
          }
        }
        return sb;
    }
}
