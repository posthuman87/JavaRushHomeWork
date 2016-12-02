package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Администратор on 14.07.2016.
 */
public class Producer implements Runnable
{
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    public void run()
    {
        Thread curTh = Thread.currentThread();
        try
        {
            int count = 0;
            while (true)
            {
                count++;
                map.put(curTh.getName(),String.format("Some text for %s",String.valueOf(count)));
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e){
            System.out.println(String.format("[%s] thread was terminated", curTh.getName()));
        }
    }
}
