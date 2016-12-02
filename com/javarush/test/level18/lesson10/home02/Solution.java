package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException{
        String fileName = args[0];

        FileInputStream inputStream = new FileInputStream(fileName);
        while (inputStream.available() > 0) {
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            int n = 0;
            String s = new String(buffer);
            int count = s.length();
            char[] chars = s.toCharArray();
            for (char ch : chars){
                if (ch =='\u0020') n++;
            }
            float result = (float)((float)n/count*100.0);
            System.out.print(String.format(Locale.ENGLISH,"%.2f",result));
        }
        inputStream.close();
    }
}
