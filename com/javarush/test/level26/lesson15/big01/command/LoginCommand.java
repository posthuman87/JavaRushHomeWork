package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Администратор on 19.07.2016.
 */
class LoginCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String log;
        String pincod;
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            log = ConsoleHelper.readString();
            pincod = ConsoleHelper.readString();
            if (validCreditCards.containsKey(log))
            {
                if (validCreditCards.getString(log).equals(pincod))
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"),log));
                    break;
                } else
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"),log));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    continue;
                }
            }
            else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"),log));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
        }
    }
}
