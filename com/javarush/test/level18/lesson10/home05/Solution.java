package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(file1);
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        inputStream.close();

        String[] s = (new String(buffer)).split(" ");
        long[] l = new long[s.length];
        for (int i = 0; i < s.length; i++){
            l[i] = Math.round(Double.valueOf(s[i]));
        }
        FileOutputStream outputStream = new FileOutputStream(file2);
        StringBuilder builder = new StringBuilder();
        for (long lon : l){
            builder.append(lon);
            builder.append(" ");
        }
        outputStream.write(builder.toString().getBytes());
        outputStream.close();
    }
}
