package com.javarush.test.level19.lesson03.task04;

import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать
 данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner scan;
        public PersonScannerAdapter(Scanner scan){
            this.scan = scan;
        }

        @Override
        public Person read() throws IOException
        {
            String string = scan.nextLine();
            String[] person = string.split(" ");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(person[5]), Integer.parseInt(person[4]) - 1, Integer.parseInt(person[3]));
            Date birth = calendar.getTime();
            Person p = new Person(person[1],person[2],person[0],birth);
            return p;
        }

        @Override
        public void close() throws IOException
        {
            scan.close();
        }
    }
}
