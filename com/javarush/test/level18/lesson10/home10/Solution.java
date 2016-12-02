package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName ;
        Set<File> list = new TreeSet<>();
        while (!(fileName=reader.readLine()).equals("end")){
            File file = new File(fileName);
            list.add(file);
        }
        reader.close();

        Iterator<File> it = list.iterator();
        String getpath = it.next().getAbsolutePath();
        getpath = getpath.substring(0,getpath.length()-6);

        FileOutputStream out = new FileOutputStream(getpath, true);
            for(File file : list){
                FileInputStream in = new FileInputStream(file);
                byte[] buff = new byte[in.available()];
                while(in.available()>0)
                {
                    in.read(buff);
                    out.write(buff);
                }
                in.close();
            }
         out.close();

    }
}
