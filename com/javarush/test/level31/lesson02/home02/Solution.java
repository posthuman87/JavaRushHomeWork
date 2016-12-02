package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException
    {
        File rootFile = new File(root);
        List<String> result = new ArrayList<>();
        Queue<File> queue = new PriorityQueue<>();

        Collections.addAll(queue, rootFile.listFiles());

        while (!queue.isEmpty())
        {
            File currentFile = queue.remove();
            if (currentFile.isDirectory())
            {
                Collections.addAll(queue, currentFile.listFiles());
            } else
                result.add(currentFile.getAbsolutePath());
        }
        return result;
    }
}
