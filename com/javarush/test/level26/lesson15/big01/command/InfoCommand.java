package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;

/**
 * Created by Администратор on 18.07.2016.
 */
class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");
    @Override
    public void execute()
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        Collection<CurrencyManipulator> collection = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        boolean money = false;
        for (CurrencyManipulator currencyManipulator : collection)
        {
            if (currencyManipulator.hasMoney())
            {
                if (currencyManipulator.getTotalAmount()>0)
                {
                    System.out.println(String.format("%s - %s", currencyManipulator.getCurrencyCode(), currencyManipulator.getTotalAmount()));
                    money = true;
                }
                }
        }
        if (!money){
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
