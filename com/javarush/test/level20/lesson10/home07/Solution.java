package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public static void main(String[] args) throws Exception
    {
        Solution solution = new Solution("c:\\1.txt");
        solution.writeObject("Hello world!");
        solution.close();

        File file = File.createTempFile("my_trash", null);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(fos);
        outputStream.writeObject(solution);

        fos.close();
        outputStream.close();

        Solution testSoul;
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fis);
        Object object = objectInputStream.readObject();
        testSoul = (Solution) object;

        fis.close();
        objectInputStream.close();
        testSoul.writeObject("Hello Hell");
        testSoul.writeObject("Fuck you");
        testSoul.close();

    }

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
