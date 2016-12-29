package com.javarush.test.level38.lesson04.task02;

/* Непроверяемые исключения (unchecked exception)
Напиши реализацию метода methodThrowsClassCastException(). Он должен
всегда кидать непроверяемое исключение ClassCastException.

Напиши реализацию метода methodThrowsNullPointerException(). Он должен
всегда кидать непроверяемое исключение NullPointerException.

Кинуть исключение (throw) явно нельзя.
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object o = new Integer(1);
        System.out.println((String)o);//напишите тут ваш код
    }

    public void methodThrowsNullPointerException() {
        int x = 10;
        Integer y = null;
        int z = y/x;//напишите тут ваш код
    }
}
