package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String name;
    private int weight;
    private int age;
    private String color;
    private String adress;

    public void initialize(String name){
        this.name = name;
    }

    public void initialize(int age, int weight, String name){
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public void initialize(int age, String name){
        this.name = name;
        this.age = age;
        weight = 10;
    }

    public void initialize(String color, int weight){
        this.weight = weight;
        this.color = color;
        name=null;
        adress=null;
        age=0;
    }

    public void initialize(String adress, String color, int weight){
        this.weight = weight;
        this.color = color;
        this.adress = adress;
    }//напишите тут ваш код

}
