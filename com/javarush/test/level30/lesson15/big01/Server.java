package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Администратор on 13.09.2016.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args)
    {
        int port;
        ConsoleHelper.writeMessage("Insert socket port:");
        port = ConsoleHelper.readInt();
        try(ServerSocket serverSocket = new ServerSocket(port))
        {
            ConsoleHelper.writeMessage("Started: " + serverSocket);

            while (true)
            {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        }
        catch(IOException e){ConsoleHelper.writeMessage("IOException");}
    }

    private static class Handler extends Thread{
        private Socket socket;

        public Handler (Socket socket){
            this.socket = socket;
        }

        @Override
        public void run()
        {
            String name = null;
            ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом " + socket.getRemoteSocketAddress());
            try(Connection connection = new Connection(socket))
            {
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                sendListOfUsers(connection, name);
                serverMainLoop(connection, name);
            }
            catch(IOException io){ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом");}
            catch(ClassNotFoundException cnf){ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом");}
            if (name!=null)
            {
                connectionMap.remove(name);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,name));
            }
            ConsoleHelper.writeMessage("соединение с удаленным адресом закрыто");

        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME)
                {
                    if (message.getData() != null && !message.getData().isEmpty())
                    {
                        if (!connectionMap.containsKey(message.getData()))
                        {
                            connectionMap.put(message.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return message.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for (String key : connectionMap.keySet())
            {
                Message message = new Message(MessageType.USER_ADDED,key);

                if (!key.equals(userName))
                    connection.send(message);
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true) {
                Message message = connection.receive();

                if (message.getType() == MessageType.TEXT){
                    Message newMessage = new Message(MessageType.TEXT, String.format("%s: %s", userName, message.getData()));
                    sendBroadcastMessage(newMessage);
                }
                else
                    ConsoleHelper.writeMessage("Error!");
            }
        }
    }

    public static void sendBroadcastMessage(Message message){
        for (Connection connection : connectionMap.values())
        {
            try
            {
                connection.send(message);
            }
            catch(IOException e){ConsoleHelper.writeMessage("Message not send");}
        }
    }
}
