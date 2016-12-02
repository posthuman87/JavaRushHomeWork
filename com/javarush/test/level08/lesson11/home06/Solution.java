package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)

    {
        ArrayList<Human> n = new ArrayList<Human>();
        ArrayList<Human> ch3 = new ArrayList<Human>();
        ch3.add(new Human("Ярик", true, 3, n));
        ch3.add(new Human("Саша", true, 6, n));
        ch3.add(new Human("Яна", false, 0, n));

        ArrayList<Human> child1 = new ArrayList<Human>();
        child1.add(new Human("Олег", true, 28, ch3));

        ArrayList<Human> child2 = new ArrayList<Human>();
        child2.add(new Human("Наташа", false, 28, ch3));

        Human Grpa1 = new Human("Толя", true, 55, child2);
        Human Grpa2 = new Human("Вася", true, 53, child1);
        Human Grma1 = new Human("Тома", false, 54, child2);
        Human Grma2 = new Human("Катя", false, 52, child1);

        System.out.println(Grpa1);
        System.out.println(Grpa2);
        System.out.println(Grma1);
        System.out.println(Grma2);
        System.out.println(child1.get(0));
        System.out.println(child2.get(0));
        for (int i = 0; i < 3; i++)
            {
                System.out.println(ch3.get(i));
            }//напишите тут ваш код
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;
        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = children;
        }
         public Human(String name, boolean sex, int age)
         {
                this.name = name;
                this.age = age;
                this.sex = sex;
        }//напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
