package com.javarush.test.level05.lesson09.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя конструкторами:
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    private String name;
    private int age;
    private char sex;

    public Friend(String name){
        this.name = name;
    }

    public Friend(int age, String name){
        this.name = name;
        this.age = age;
    }

    public Friend(char sex, int age, String name){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }//напишите тут ваш код

}