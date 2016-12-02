package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by Администратор on 15.07.2016.
 */
public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString()throws InterruptOperationException{
        String result = "";
        try
        {
            result = reader.readLine();
            if (result.toLowerCase().equals(res.getString("operation.EXIT"))) throw new InterruptOperationException();

        }
        catch(IOException e){}
        return result;
    }

    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }

    public static Operation askOperation() throws InterruptOperationException{
        writeMessage(res.getString("choose.operation") + " \n" +
                res.getString("operation.INFO") + ": 1;\n" +
                res.getString("operation.DEPOSIT") + ": 2;\n" +
                res.getString("operation.WITHDRAW") + ": 3;\n" +
                res.getString("operation.EXIT") + ": 4");
        Operation result;
        try{
            int i = Integer.parseInt(readString());
            result = Operation.getAllowableOperationByOrdinal(i);
        }
        catch (IllegalArgumentException e){writeMessage(res.getString("invalid.data"));return askOperation();}
        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.currency.code"));
        String temp = null;
            temp = readString();
        if (temp.length() == 3)
        {
            return temp.toUpperCase();
        }
        writeMessage(res.getString("invalid.data"));
        return askCurrencyCode();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String[] array;
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));

        while (true)
        {
            String s = null;
                s = readString();
            array = s.split(" ");
            int k;
            int l;
            try
            {
                k = Integer.parseInt(array[0]);
                l = Integer.parseInt(array[1]);
            }
            catch (Exception e)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if (k <= 0 || l <= 0 || array.length > 2)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return array;
    }
}
