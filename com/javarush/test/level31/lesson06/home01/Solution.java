package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static Map<ZipEntry,byte[]> entry = new HashMap<>();

    public static void main(String[] args) throws IOException {
        File fileName = new File(args[0]);
        File archFile = new File(args[1]);

        zipToMap(archFile);
        writeNewFileToZip(fileName,archFile);

    }

    public static void zipToMap(File file){
        try(ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file))){
            ZipEntry zipEntry;
            while((zipEntry = zipInputStream.getNextEntry()) != null){
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;

                while((count = zipInputStream.read(buffer)) != -1){
                    baos.write(buffer,0,count);
                }
                byte[] bytes = baos.toByteArray();
                entry.put(zipEntry,bytes);
            }
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void writeNewFileToZip(File addFile, File zipFile){
        try(ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile)); FileInputStream fis = new FileInputStream(addFile)){
            boolean isExist = false;
            ZipEntry addedFileEntry = new ZipEntry(addFile.getName());

            for (Map.Entry<ZipEntry, byte[]> entryEntry : entry.entrySet())
            {
                Path path = Paths.get(entryEntry.getKey().getName());
                if(!(path.getFileName().toString().equals(addedFileEntry.getName())))
                {
                    zipOutputStream.putNextEntry(new ZipEntry(entryEntry.getKey().getName()));
                    zipOutputStream.write(entryEntry.getValue());
                } else
                    isExist = true;
            }
            if (isExist){
                ZipEntry newEntry = new ZipEntry("new/"+addFile.getName());
                zipOutputStream.putNextEntry(newEntry);

                byte[] bytes = new byte[fis.available()];
                fis.read(bytes);
                zipOutputStream.write(bytes);
                zipOutputStream.closeEntry();

            }
        }
        catch (Exception e){e.printStackTrace();}
    }
}
