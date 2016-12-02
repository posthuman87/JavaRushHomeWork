package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        public void writeObject(ObjectOutputStream obj) throws IOException{
            obj.writeObject(firstName);
            obj.writeObject(lastName);
            obj.writeObject(country);
            obj.writeObject(sex);
        }

        public Object readObject (ObjectInputStream obj) throws IOException, ClassNotFoundException{
            String fn = (String)obj.readObject();
            String ln = (String)obj.readObject();
            String c = (String)obj.readObject();
            Sex s = (Sex)obj.readObject();
            return new Person(fn,ln,c,s);
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }
}
