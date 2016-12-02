package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setFirstName("Aleh");
            user1.setLastName("Bondar");
            user1.setBirthDate(dateFormat.parse("19/10/1987"));
            user1.setMale(true);
            user1.setCountry(User.Country.OTHER);
            javaRush.users.add(user1);//initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            User userCopy = loadedObject.users.get(0);
            System.out.println(userCopy.getFirstName());
            System.out.println(userCopy.getLastName());
            System.out.println(userCopy.getBirthDate().getTime());
            System.out.println(userCopy.isMale() ? "male" : "female");
            System.out.println(userCopy.getCountry());//check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);

                for (User user : users) {
                    writer.println("@");
                    String firstName = user.getFirstName(); if (firstName == null) firstName = "noFirstName";
                    writer.println(firstName);
                    String lastName = user.getLastName(); if (lastName == null) lastName = "noLastName";
                    writer.println(lastName);
                    writer.println(dateFormat.format(user.getBirthDate()));
                    if (user.isMale())
                        writer.println("male");
                    else
                        writer.println("female");
                    writer.println(user.getCountry());//implement this method - реализуйте этот метод
                }
                writer.close();
        }

        public void load(InputStream inputStream) throws IOException, ParseException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready())
            {
                String newUser = reader.readLine();
                if ("@".equals(newUser))
                {
                    User user = new User();
                    String firstName = reader.readLine();
                    if ("noFirstName".equals(firstName)) firstName =null; user.setFirstName(firstName);
                    String lastName = reader.readLine();
                    if ("noLastName".equals(lastName)) lastName = null; user.setLastName(lastName);
                    user.setBirthDate(dateFormat.parse(reader.readLine()));
                    String sex = reader.readLine();
                    if ("male".equals(sex))
                        user.setMale(true);
                    else
                        user.setMale(false);
                    user.setCountry(User.Country.valueOf(reader.readLine()));
                    users.add(user);
                }
            }
        }
    }
}
