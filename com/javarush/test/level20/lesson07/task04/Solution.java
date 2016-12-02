package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable {
    public static void main(String[] args){
        try
        {
            File file = File.createTempFile("my_temp", null);

            FileOutputStream out = new FileOutputStream(file);
            Solution saveObject = new Solution(-9);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
            if (saveObject != null)
                objectOutputStream.writeObject(saveObject);
            out.close();
            objectOutputStream.close();

            Solution loadedObject = new Solution(6);

            FileInputStream in = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(in);
            Object object = objectInputStream.readObject();
            in.close();
            objectInputStream.close();
            loadedObject = (Solution) object;

            if (loadedObject.string.equals(saveObject.string)) System.out.println(saveObject.string); else
                System.out.println("Error!!!");
        }
        catch (IOException io){
            io.printStackTrace();
        }
        catch (ClassNotFoundException nf) {
            nf.printStackTrace();
        }
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
