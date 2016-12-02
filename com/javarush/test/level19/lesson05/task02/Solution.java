package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRead = new BufferedReader(new FileReader(reader.readLine()));

        int counts = 0;
        while (fileRead.ready()){
            String[] text = fileRead.readLine().replaceAll("\\p{Punct}"," ").split(" ");
            for (String res : text){
                if("world".equals(res)) counts++;
            }
        }
        System.out.println(counts);
        fileRead.close();
        reader.close();
    }
}
