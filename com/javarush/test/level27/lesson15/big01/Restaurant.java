package com.javarush.test.level27.lesson15.big01;
import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();
    private static final int ORDER_CREATING_INTERVAL = 100;
    public static void main(String[] args) throws InterruptedException{
        Locale.setDefault(Locale.ENGLISH);
        List<Tablet> tablets = new ArrayList<>();
        Cook cook1 = new Cook("Bob Marley");
        cook1.setQueue(queue);
        Cook cook2 = new Cook("Cannibal Lector");
        cook2.setQueue(queue);
        Waitor waitor = new Waitor();
        cook1.addObserver(waitor);
        cook2.addObserver(waitor);

        for (int i=1; i<=5; i++)
        {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(queue);
            tablets.add(tablet);
        }

        Thread cookMarley = new Thread(cook1);
        cookMarley.start();
        Thread cookLector = new Thread(cook2);
        cookLector.start();

        RandomOrderGeneratorTask generator = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(generator);
        thread.start();
        try
        {
            Thread.sleep(1000);
        }catch(InterruptedException e){}
        thread.interrupt();

        while (!queue.isEmpty()){
            Thread.sleep(1);
        }

        while ((cook1.isBusy())||(cook2.isBusy())) { Thread.sleep(1);}
        cookMarley.interrupt();
        cookLector.interrupt();

        DirectorTablet director = new DirectorTablet();
        director.printAdvertisementProfit();
        director.printCookWorkloading();
        director.printActiveVideoSet();
        director.printArchivedVideoSet();


    }
}