package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Администратор on 21.09.2016.
 */
public class BotClient extends Client
{
    int botCounter = 0;
    public static void main(String[] args)
    {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
            String sender = "";
            String messageText;
            if (message.contains(": ")){
                sender = message.substring(0,message.indexOf(": "));
                messageText = message.substring(message.indexOf(": ")+2);
            } else
            {
                messageText = message;
            }
            SimpleDateFormat format = null;
            if ("дата".equalsIgnoreCase(messageText)){
                format = new SimpleDateFormat("d.MM.YYYY");
            } else
            if ("день".equalsIgnoreCase(messageText)){
                format = new SimpleDateFormat("d");
            } else
            if ("месяц".equalsIgnoreCase(messageText)){
                format = new SimpleDateFormat("MMMM");
            } else
            if ("год".equalsIgnoreCase(messageText)){
                format = new SimpleDateFormat("YYYY");
            } else
            if ("время".equalsIgnoreCase(messageText)){
                format = new SimpleDateFormat("H:mm:ss");
            } else
            if ("час".equalsIgnoreCase(messageText)){
                format = new SimpleDateFormat("H");
            } else
            if ("минуты".equalsIgnoreCase(messageText)){
                format = new SimpleDateFormat("m");
            } else
            if ("секунды".equalsIgnoreCase(messageText)){
                format = new SimpleDateFormat("s");
            }
            if (format != null)
            {
                sendTextMessage("Информация для " + sender + ": " + format.format(Calendar.getInstance().getTime()));
            }
        }
    }

    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName()
    {
        if (botCounter == 99){
            botCounter = 0;
        }
        return String.format("date_bot_%d",botCounter++);
    }

}
