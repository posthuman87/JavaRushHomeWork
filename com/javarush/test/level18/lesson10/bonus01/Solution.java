package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        if (args.length < 3) {
            return;
        } else

        if (args[0] == "-e"|| args[0]=="-d"){
            String fileName = args[1];
            String fileOutputName = args[2];
            FileInputStream in = new FileInputStream(fileName);
            byte[] buffer = new byte[in.available()];
            while (in.available()>0){
                in.read(buffer);
            }
            in.close();
            byte[] newbuffer = new byte[buffer.length];
            int j = 0;
            for (int i = buffer.length-1;i >= 0; i--){
                newbuffer[j] = buffer[i];
                j++;
            }
            FileOutputStream out = new FileOutputStream(fileOutputName);
            out.write(newbuffer);
            out.close();
        }
    }

}
