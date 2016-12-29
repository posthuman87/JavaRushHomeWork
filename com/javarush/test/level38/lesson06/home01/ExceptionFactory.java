package com.javarush.test.level38.lesson06.home01;

/**
 * Created by Администратор on 28.12.2016.
 */
public class ExceptionFactory
{
    public static Throwable getException(Enum e)
    {
        if (e != null)
        {
            String temp = e.name().toLowerCase().replaceAll("_", " ");
            String message = temp.substring(0, 1).toUpperCase() + temp.substring(1);
            if (e instanceof ExceptionApplicationMessage)
            {
                return new Exception(message);
            } else if (e instanceof ExceptionDBMessage)
            {
                return new RuntimeException(message);
            } else if (e instanceof ExceptionUserMessage)
            {
                return new Error(message);
            }
        }
        return new IllegalArgumentException();
    }
}
