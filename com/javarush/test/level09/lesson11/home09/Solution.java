package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> cats = new HashMap<String, Cat>();
        cats.put("Barsic", new Cat("Barsic"));
        cats.put("Bobik", new Cat("Bobik"));
        cats.put("Murzik", new Cat("Murzik"));
        cats.put("Siska", new Cat("Siska"));
        cats.put("Piska", new Cat("Piska"));
        cats.put("Murka", new Cat("Murka"));
        cats.put("Tomas", new Cat("Tomas"));
        cats.put("Monika", new Cat("Monika"));
        cats.put("Shapka", new Cat("Shapka"));
        cats.put("Bart", new Cat("Bart"));
        return cats;//напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> cats = new HashSet<Cat>();
        for (Map.Entry<String, Cat> m : map.entrySet()){
            cats.add(m.getValue());
        }
        return cats;//напишите тут ваш код
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
