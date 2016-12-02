package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id,
найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length != 4){return;}
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        String productName = String.format("%-30.30s", args[1]);
        String price = String.format("%-8.8s", args[2]);
        String quantity = String.format("%-4.4s", args[3]);

        if(args[0] != "-c") throw new Exception(); else {
            BufferedReader readFile = new BufferedReader(new FileReader(fileName));
            int max = Integer.MIN_VALUE;
            String line;
            while ((line = readFile.readLine()) != null) {
                try
                {
                    int id = Integer.parseInt(line.substring(0, 8).trim());
                    if (id > max) max = id;
                }
                catch (StringIndexOutOfBoundsException e){}
            }
            readFile.close();
            int newId = max + 1;
            String Id = String.format("%-8.8s", String.valueOf(newId));

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
            if (newId != 1) writer.newLine();
            Id = Id+productName+price+quantity;
            writer.append(Id);
            writer.close();
        }

    }
}
