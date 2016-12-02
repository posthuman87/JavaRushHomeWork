package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        private String name;
        private int age;
        private int weight;
        private boolean sex;
        private String haircolor;
        private String town;

        public Human(String name, int age){
            this.name = name;
            this.age = age;
        }

        public Human(String name){
            this.name = name;
        }

        public Human(String name, int age, int weight){
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        public Human(String name, int age, int weight, boolean sex){
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.sex = sex;
        }

        public Human(String name, int age, int weight, boolean sex, String haircolor){
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.sex = sex;
            this.haircolor = haircolor;
        }

        public Human(String name, int age, int weight, boolean sex, String haircolor, String town){
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.sex = sex;
            this.haircolor = haircolor;
            this.town = town;
        }

        public Human(String name, boolean sex){
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, boolean sex, String haircolor){
            this.name = name;
            this.sex = sex;
            this.haircolor = haircolor;
        }

        public Human(boolean sex){
            this.sex = sex;
        }

        public Human(int age){
            this.age = age;
        }//напишите тут ваши переменные и конструкторы
    }
}
