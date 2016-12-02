package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        if (args.length!=5&&args.length!=2){return;}
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        ArrayList<String> priseAr = getStrings(fileName);
        ArrayList<String> ids = new ArrayList<>();
        for(String s : priseAr){
            ids.add(s.substring(0,8));
        }


        if (args[0] == "-u") {
            String id = String.format("%-8.8s", args[1]);
            String productName = String.format("%-30.30s", args[2]);
            String price = String.format("%-8.8s", args[3]);
            String quantity = String.format("%-4.4s", args[4]);
            String newString = id+productName+price+quantity;
            int index = 0;

            for(String s : ids){
                if (s.equals(id))
                    index = ids.indexOf(s);
            }

            priseAr.set(index, newString);
            }

        if (args[0] == "-d") {
            String id = String.format("%-8.8s", args[1]);
            int index = 0;

            for(String s : ids){
                if (s.equals(id))
                    index = ids.indexOf(s);
            }

            priseAr.remove(index);
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
        for (int i = 0; i < priseAr.size(); i++) {
            if(i==0) writer.write(priseAr.get(i)); else
            {
                writer.newLine();
                writer.write(priseAr.get(i));
            }
        }
        writer.close();
    }




    public static ArrayList<String> getStrings (String fileName) throws IOException{
        BufferedReader readline = new BufferedReader (new FileReader(fileName));
        ArrayList<String> list = new ArrayList<>();
        String s;
        while((s = readline.readLine())!=null){
            list.add(s);
        }
        readline.close();
        return list;
    }

    }

