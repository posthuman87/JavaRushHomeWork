package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Posthuman on 24.03.2016.
 */

public class BelarusianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {return 15000;}
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц." ;}
}
