package com.javarush.test.level18.lesson08.task04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/

public class TxtInputStream extends FileInputStream {
    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException{
        super(fileName);
        char[] chars = fileName.toCharArray();
        if (chars[chars.length-1]!='t'||chars[chars.length-2]!='x'||chars[chars.length-3]!='t'||chars[chars.length-4]!='.')
            throw new UnsupportedFileNameException();


    }

}

