package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static
    {
        threads.add(new FirstThread());
        threads.add(new SecondThread());
        threads.add(new ThreeThread());
        threads.add(new FourthThread());
        threads.add(new FifthThread());
    }

    public static class FirstThread extends Thread{
        @Override
        public void run()
        {
            while (true) {}
        }
    }

    public static class SecondThread extends Thread {
        @Override
        public void run()
        {
            try
            {
                while (!isInterrupted()) {}
                throw new InterruptedException();
            }
            catch (InterruptedException e) {System.out.println("InterruptedException");}
        }
    }

    public static class ThreeThread extends Thread {
        @Override
        public void run()
        {
            try{
                while(true){
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e) {}
        }
    }

    public static class FourthThread extends Thread implements Message {
        @Override
        public void run()
        {
            while (!isInterrupted()){}
        }

        @Override
        public void showWarning()
        {
            interrupt();
            try
            {
                this.join();
            }
            catch (InterruptedException e) {}
        }
    }

    public static class FifthThread extends Thread {
        @Override
        public void run()
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int result = 0;
            try
            {
                while (!isInterrupted())
                {
                    String s = reader.readLine();
                    if (s.equals("N")) interrupt();
                    else
                    {
                        int integer = Integer.parseInt(s);
                        result += integer;
                    }
                }
                System.out.println(result);
            }
            catch (IOException e){}
        }
    }
}

