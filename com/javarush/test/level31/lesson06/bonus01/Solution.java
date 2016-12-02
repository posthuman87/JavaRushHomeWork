package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];

        List<File> files = new ArrayList<>();
        for (int i = 1; i < args.length; i++)
        {
            files.add(new File(args[i]));
        }

        Collections.sort(files, new Comparator<File>()
        {
            @Override
            public int compare(File o1, File o2)
            {
                String name1 = o1.getName();
                String name2 = o2.getName();
                return name1.compareTo(name2);
            }
        });

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try
        {
            for (File file : files)
            {
                FileInputStream fis = new FileInputStream(file);
                byte[] bytes = new byte[1024];
                int count;
                try
                {
                    while ((count = fis.read(bytes)) != -1)
                    {
                        baos.write(bytes, 0, count);
                    }
                }
                finally
                {
                    fis.close();
                }
            }
        }
        finally
        {
            baos.close();
        }

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ZipInputStream zis = new ZipInputStream(bais);
        ZipEntry entry = null;
        while((entry = zis.getNextEntry())!=null){
            FileOutputStream fos = new FileOutputStream(resultFileName);
            byte[] buff = new byte[1024];
            int count1;
            while ((count1 = zis.read(buff)) != -1){
                fos.write(buff,0,count1);
            }
            fos.close();
            zis.closeEntry();
        }
        zis.close();
    }
}
