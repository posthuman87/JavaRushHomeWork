package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Posthuman on 28.03.2016.
 */
public class Singleton
{
    private static final Singleton instance = new Singleton();
    private Singleton (){}
    public static Singleton getInstance(){return instance;}
}
