package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{
    private FileOutputStream outputStream;

    public AdapterFileOutputStream(FileOutputStream outputStream){
        this.outputStream = outputStream;
    }

    @Override
    public void flush() throws IOException
    {
        this.outputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {
        byte[] chars = s.getBytes();
        this.outputStream.write(chars);
    }

    @Override
    public void close() throws IOException
    {
        this.outputStream.close();
    }
}

