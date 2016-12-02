package com.javarush.test.level28.lesson06.home01;

/**
 * Created by Администратор on 16.08.2016.
 */
public class MyThread extends Thread
{
    private static int prior = 1;

    public MyThread()
    {
        if(prior<=10) {
            this.setPriority(prior);
            prior++;
        } else{
            prior=1;
            this.setPriority(prior);
            prior++;
        }
    }

    public MyThread(Runnable target)
    {
        super(target);
        if(prior<=10) {
            this.setPriority(prior);
            prior++;
        } else{
            prior=1;
            this.setPriority(prior);
            prior++;
        }
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        if(prior<group.getMaxPriority()||prior>10)
        {
            if (prior <= 10)
            {
                this.setPriority(prior);
                prior++;
            } else
            {
                prior = 1;
                this.setPriority(prior);
                prior++;
            }
        }else{
            this.setPriority(group.getMaxPriority());
            prior++;
        }
    }

    public MyThread(String name)
    {
        super(name);
        if (prior <= 10)
        {
            this.setPriority(prior);
            prior++;
        } else
        {
            prior = 1;
            this.setPriority(prior);
            prior++;
        }
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        if(prior<group.getMaxPriority()||prior>10)
        {
            if (prior <= 10)
            {
                this.setPriority(prior);
                prior++;
            } else
            {
                prior = 1;
                this.setPriority(prior);
                prior++;
            }
        }else{
            this.setPriority(group.getMaxPriority());
            prior++;
        }
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        if (prior <= 10)
        {
            this.setPriority(prior);
            prior++;
        } else
        {
            prior = 1;
            this.setPriority(prior);
            prior++;
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        if(prior<group.getMaxPriority()||prior>10)
        {
            if (prior <= 10)
            {
                this.setPriority(prior);
                prior++;
            } else
            {
                prior = 1;
                this.setPriority(prior);
            }
        }else{
            this.setPriority(group.getMaxPriority());
            prior++;
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        if(prior<group.getMaxPriority()||prior>10)
        {
            if (prior <= 10)
            {
                this.setPriority(prior);
                prior++;
            } else
            {
                prior = 1;
                this.setPriority(prior);
            }
        }else{
            this.setPriority(group.getMaxPriority());
            prior++;
        }
    }
}
