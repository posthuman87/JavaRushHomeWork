package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String name;
    private int weight;
    private int age;
    private String color;
    private String adres;

    public Cat(String name){
        this.name = name;
    }

    public Cat(int age, int weight, String name){
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Cat(int age,String name){
        this.name =name;
        this.age =age;
        weight = 5;
    }

    public Cat(String color, int weight){
        this.weight =weight;
        this.color = color;
    }

    public Cat(String color, int weight, String adres){
        this.weight =weight;
        this.color = color;
        this.adres =adres;
    } //напишите тут ваш код

}
