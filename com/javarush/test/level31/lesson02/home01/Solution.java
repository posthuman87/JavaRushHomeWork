package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    private static List<File> fileList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        File path  = new File(args[0]);
        String resultFileAbsolutePath = args[1];

        getFiles(path);
        sortList(fileList);

        fileList.remove(new File(resultFileAbsolutePath));

        Path folder = Paths.get(resultFileAbsolutePath);
        Path resFolder = Files.move(folder,folder.resolveSibling("allFilesContent.txt"));

        BufferedWriter writer = new BufferedWriter(new FileWriter(resFolder.toFile()));
        for(File file : fileList)
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.ready())
            {
                writer.write(reader.readLine());
                writer.newLine();
            }
            reader.close();
        }
        writer.close();
    }

    public static void sortList(List<File> list){
        Collections.sort(list, new Comparator<File>()
        {
            @Override
            public int compare(File o1, File o2)
            {
                String name1 = o1.getName();
                String name2 = o2.getName();
                return name1.compareTo(name2);
            }
        });
    }

    public static void getFiles (File path){
        for (File file : path.listFiles()){
            if (file.isDirectory()){
                if (file.list().length == 0)
                    file.delete();
                else
                    getFiles(file);
            }
            else
            {
                if(file.length() > 50){
                    file.delete();
                }
                else
                    fileList.add(file);
            }
        }
    }
}
