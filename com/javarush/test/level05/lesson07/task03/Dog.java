package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String name;
    private int rost;
    private String color;

    public void initialize(String name){
        this.name = name;
    }

    public void initialize(int rost, String name){
        this.name = name;
        this.rost = rost;
    }

    public void initialize(String color, int rost, String name){
        this.name = name;
        this.rost = rost;
        this.color = color;
    }//напишите тут ваш код

}
