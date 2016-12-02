package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream reader1 = new FileInputStream(file2);
        FileInputStream reader2 = new FileInputStream(file3);
        FileOutputStream writer = new FileOutputStream(file1);
        while (reader1.available() > 0) {
            byte[] buff = new byte[reader1.available()];
            count = reader1.read(buff);
            writer.write(buff, 0, count);
        }
        while (reader2.available() > 0) {
            byte[] buffer = new byte[reader2.available()];
            int n = reader2.read(buffer);
            writer.write(buffer,0, n);
        }
        reader.close();
        reader1.close();
        reader2.close();
        writer.close();
    }
}
