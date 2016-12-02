package com.javarush.test.level27.lesson15.big01;

import java.util.List;

/**
 * Created by Администратор on 13.08.2016.
 */
public class RandomOrderGeneratorTask implements Runnable {
    private int interval;
    private List<Tablet> tablets;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval){
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        if(tablets.isEmpty()) return;
        try
        {
            while (!Thread.currentThread().isInterrupted())
            {
                Tablet tablet =  tablets.get((int)(Math.random()*tablets.size()));
                tablet.createTestOrder();
                Thread.sleep(interval);
            }
        }catch (InterruptedException e){
        }

    }
}
