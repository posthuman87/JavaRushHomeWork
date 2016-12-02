package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        ArrayList<String> list = new ArrayList<String>();
        String line;

        while ((line = fileReader.readLine()) != null) {
            String[] strings = line.split(" ");
            for (String s : strings){
                if (s.length()>6)
                    list.add(s);
            }
        }

        for (int i = 0; i < list.size(); i++){
            if (i == list.size()-1)
                fileWriter.write(list.get(i));
            else
            {
                fileWriter.write(list.get(i));
                fileWriter.write(",");
            }
        }
        fileReader.close();
        fileWriter.close();

    }
}
