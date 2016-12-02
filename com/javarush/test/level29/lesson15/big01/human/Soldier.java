package com.javarush.test.level29.lesson15.big01.human;

/**
 * Created by Администратор on 01.09.2016.
 */
public class Soldier extends Human
{
    public Soldier(String name, int age)
    {
        super(name, age);
    }

    public void fight() {
    }
    public void live() {
        fight();
    }
}
