package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }


    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

         int[] m = new int[9];
        try
        {
          System.out.print(m[10]);

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        String s = "c:/bl.txt";
        try
        {
            InputStream file = new FileInputStream(s);//Add your code here
        }
        catch (Exception e){
            exceptions.add(e);
        }
        try{
            int[] n = new int[-1];
        }
        catch(Exception e){
            exceptions.add(e);
        }
        try{
            LinkedList list = new LinkedList();
            list.get(-1);
        }
        catch(Exception e){
            exceptions.add(e);
        }

        try{
            Object i = new Integer(0);
            String a = (String)i;
        }
        catch(Exception e){
            exceptions.add(e);
        }
        try{
            Object obj[] = new String[10];
            obj[0] = new Character('*');
        }
        catch(Exception e){
            exceptions.add(e);
        }
        try{
            int[] nullArr = new int[5];
            nullArr = null;
            int i = nullArr.length;
        }
        catch(Exception e){
            exceptions.add(e);
        }
        try{
            String str = "123";
            char ch = str.charAt(10);
        }
        catch (Exception e){
            exceptions.add(e);
        }
        try{
            throw new IllegalStateException();
        }
        catch (Exception e){
            exceptions.add(e);
        }



    }
}
