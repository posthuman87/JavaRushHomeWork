package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String name;
    private int heigh;
    private String color;

    public Dog(String name){
        this.name = name;
    }

    public Dog(int heigh, String name){
        this.name = name;
        this.heigh =heigh;
    }

    public Dog(String color, int heigh, String name){
        this.name = name;
        this.heigh = heigh;
        this.color = color;
    }//напишите тут ваш код

}
