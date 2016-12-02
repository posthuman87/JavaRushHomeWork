package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        if (!"html".equals(getFileExtension(file))){return;}
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        ArrayList<Pair> list = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()){
            stringBuilder = stringBuilder.append(fileReader.readLine());
        }
        String tag = args[0];
        int tagLen = tag.length();
        String text = stringBuilder.toString().replaceAll("\r\n","");
        String open = "<".concat(tag);
        String close = "</".concat(tag);
        int index1 = 0;

        while ((index1 != -1)&&(index1 <= text.length())){
            index1 = text.indexOf(open, index1);
            int index2 = text.indexOf(close, index1+tagLen);
            int k = index1+tagLen;
            if (index2 != -1)
            {
                while (text.substring(k, index2).contains(open))
                {
                    k = index2+tagLen;
                    index2 = text.indexOf(close, k);
                }
            }
            if ((index1 != -1) && (index2 != -1)){
                list.add(new Pair(index1, index2));
                index1 += tagLen;
            }
        }

        for (Pair pair : list){
            strings.add(text.substring(pair.getA(),(pair.getB()+tagLen+3)));
        }

        for (String string : strings){
            System.out.println(string);
        }

        reader.close();
        fileReader.close();
    }

    public static String getFileExtension(File file){
        String name = file.getName();
        if (name.lastIndexOf(".")!=-1&&name.lastIndexOf(".")!=0)
            return name.substring(name.lastIndexOf(".")+1);
        else
            return "";
    }

    public static class Pair {
        private int a;
        private int b;

        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}
