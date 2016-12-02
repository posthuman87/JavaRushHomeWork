package com.javarush.test.level26.lesson15.big01;

/**
 * Created by Администратор on 15.07.2016.
 */
public enum Operation
{
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i){
        Operation result = null;
        switch (i){
            case 0: throw new IllegalArgumentException();

            case 1: result = INFO;
                    break;
            case 2: result = DEPOSIT;
                    break;
            case 3: result = WITHDRAW;
                    break;
            case 4: result = EXIT;
                    break;
        }
        if (result == null) throw new IllegalArgumentException(); else
        return result;
    }
}
