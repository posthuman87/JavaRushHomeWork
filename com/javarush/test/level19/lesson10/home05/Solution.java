package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        String line;

        while ((line = fileReader.readLine()) != null) {
            String[] strings = line.split(" ");
            for (String s : strings){
                String temp = s.replaceAll("\\D","");
                if (temp.length() > 0)
                {
                    fileWriter.write(s + " ");
                }
            }
        }
        fileReader.close();
        fileWriter.close();

    }
}
