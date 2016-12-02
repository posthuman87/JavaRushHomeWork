package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] str = line.split(" ");
            Date date = new Date(Integer.parseInt(str[str.length-1]),Integer.parseInt(str[str.length-2])-1, Integer.parseInt(str[str.length-3]));
            String name = getName(str, str.length-3);
            PEOPLE.add(new Person(name,date));
        }
        reader.close();
    }

    public static String getName (String[] string, int index){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++){
            if (i == index-1)
                sb.append(string[i]);
            else
                sb.append(string[i]).append(" ");
        }
        return sb.toString();
    }

}
