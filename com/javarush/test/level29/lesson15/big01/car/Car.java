package com.javarush.test.level29.lesson15.big01.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;


    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws  Exception
    {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd)
    {
        double consumption;
        if (!isSummer(date,SummerStart,SummerEnd)) {
            consumption = getWinterConsumption(length);
        }
        else {
            consumption = getSummerConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
            return 0;

        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0)
            fastenPassengersBelts();
        fastenDriverBelt();
        }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public static Car create(int type, int numberOfPassengers){
        Car result = null;
        switch (type){
            case TRUCK : result = new Truck(numberOfPassengers);
                 break;
            case SEDAN : result = new Sedan(numberOfPassengers);
                 break;
            case  CABRIOLET : result = new Cabriolet(numberOfPassengers);
                break;
        }
        return result;
    }

    public boolean isSummer(Date date , Date summerStart, Date summerEnd){
        return (date.after(summerStart)&&date.before(summerEnd));
    }

    public double getWinterConsumption(int length){
        return (length*winterFuelConsumption+winterWarmingUp);
    }

    public double getSummerConsumption(int length){
        return(length*summerFuelConsumption);
    }

    private boolean canPassengersBeTransferred(){
        return(isDriverAvailable()&&fuel>0);
    }
}
