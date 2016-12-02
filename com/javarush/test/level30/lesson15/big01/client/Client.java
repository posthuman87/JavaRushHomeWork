package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Администратор on 20.09.2016.
 */
public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args)
    {
        Client client = new Client();
        client.run();
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
            try
            {
                synchronized (this)
                {
                    this.wait();
                }
            }
            catch(InterruptedException e){
                ConsoleHelper.writeMessage("InterruptedException");
                return;
            }
            if (clientConnected)
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
            else
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        while(clientConnected){
            String s = ConsoleHelper.readString();
            if ("exit".equals(s))
                break;
            if (shouldSentTextFromConsole())
                sendTextMessage(s);
        }
    }

    public class SocketThread extends Thread{
        @Override
        public void run()
        {
            try
            {
                Socket socket = new Socket(getServerAddress(), getServerPort());
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }
            catch (Exception e){notifyConnectionStatusChanged(false);}

        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while (true)
            {
                Message message = connection.receive();
                switch (message.getType())
                {
                    case NAME_REQUEST:
                        String name = getUserName();
                        connection.send(new Message(MessageType.USER_NAME, name));
                        break;
                    case NAME_ACCEPTED:
                        notifyConnectionStatusChanged(true);
                        return;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while(true){
                Message text = connection.receive();
                switch (text.getType()){
                    case TEXT:
                        processIncomingMessage(text.getData());
                        break;

                    case USER_ADDED:
                        informAboutAddingNewUser(text.getData());
                        break;

                    case USER_REMOVED:
                        informAboutDeletingNewUser(text.getData());
                        break;

                    default: throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " присоеденился к чату");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }
    }

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Insert server address");
        String serverAddress = ConsoleHelper.readString();
        return serverAddress;
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("Insert server port");
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("Insert user name");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        Message message = new Message(MessageType.TEXT, text);
        try
        {
            connection.send(message);
        }
        catch(IOException e){
            e.printStackTrace();
            ConsoleHelper.writeMessage("IOException");
            clientConnected = false;
        }
    }

}
