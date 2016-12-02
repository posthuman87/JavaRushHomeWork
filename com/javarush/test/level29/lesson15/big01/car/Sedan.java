package com.javarush.test.level29.lesson15.big01.car;

/**
 * Created by Администратор on 04.09.2016.
 */
public class Sedan extends Car
{
    public Sedan(int numberOfPassengers)
    {
        super(Car.SEDAN,numberOfPassengers);
    }

    @Override
    public int getMaxSpeed()
    {
        final int MAX_SEDAN_SPEED = 120;
        return MAX_SEDAN_SPEED;
    }
}
