package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static byte[] temp;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName2);
        FileInputStream inputStream1 = new FileInputStream(fileName1);
        while (inputStream1.available() > 0) {
            temp = new byte[inputStream1.available()];
            inputStream1.read(temp);
        }
        inputStream1.close();
        FileOutputStream outputStream = new FileOutputStream(fileName1);
        while (inputStream.available() > 0)
        {
            byte[] buff = new byte[inputStream.available()];
            inputStream.read(buff);
            outputStream.write(buff);
        }
            outputStream.write(temp);
        reader.close();
        inputStream.close();
        outputStream.close();
    }
}
