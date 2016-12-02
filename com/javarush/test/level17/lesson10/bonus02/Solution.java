package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public  static volatile List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args){
        int n = args.length;
        if (n < 2) {return;}
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);
        if (args[0].equals("-c")){

            for (int i = 1; i < n; i+=3 ){
                String name = args[i];
                try
                {
                    if (args[i + 1].equals("м"))
                    {
                        allPeople.add(Person.createMale(name, dateFormat.parse(args[i + 2])));
                        System.out.println(allPeople.size() - 1);//start here - начни тут
                    } else if (args[i + 1].equals("ж"))
                    {
                        allPeople.add(Person.createFemale(name, dateFormat.parse(args[i + 2])));
                        System.out.println(allPeople.size() - 1);
                    }
                }
                catch (ParseException e) {e.printStackTrace();}
            }

        }
        else
        if (args[0].equals("-u"))
        {
            for (int i = 1; i < n; i += 4)
            {
                int id = Integer.parseInt(args[i]);
                if (id > allPeople.size() - 1)
                {
                    break;
                }
                try
                {
                    String name = args[i + 1];
                    if (args[i + 2].equals("м"))
                    {
                        Person person = Person.createMale(name, dateFormat.parse(args[i + 3]));
                        allPeople.set(id, person);
                    } else if (args[i + 2].equals("ж"))
                    {
                        Person person = Person.createFemale(name, dateFormat.parse(args[i + 3]));
                        allPeople.set(id, person);
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }

            }
        }
        else
            if (args[0].equals("-d")){
                for (int i=1; i < n; i++){
                    int id = Integer.parseInt(args[i]);
                    if (id > allPeople.size()-1){break;}
                    try
                    {
                        allPeople.get(id).setBirthDay(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setName("");
                    }
                    catch (Exception e){System.out.println(e);}
                }
            }
        else
                if (args[0].equals("-i")){
                    for (int i = 1; i < n; i++){
                        try
                        {
                            int id = Integer.parseInt(args[i]);
                            if (id > allPeople.size() - 1)
                            {
                                break;
                            }
                            String name = allPeople.get(id).getName();
                            String sex ;
                            if (allPeople.get(id).getSex() == Sex.MALE) sex = "м";
                            else sex = "ж";
                            String bd = dateFormat2.format(allPeople.get(id).getBirthDay());
                            System.out.println(name + " " + sex + " " + bd);
                        }
                        catch (Exception e){System.out.println(e);}
                    }
                }
    }
}
