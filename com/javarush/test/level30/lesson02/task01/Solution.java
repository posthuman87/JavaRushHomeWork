package com.javarush.test.level30.lesson02.task01;

/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        if (s.startsWith("0b")){
            String s1 = s.replace("0b","");
            return String.valueOf(Integer.parseInt(s1,2));
        } else
            if (s.startsWith("0x")){
            String s2 = s.replace("0x","");
                return String.valueOf(Integer.parseInt(s2,16));
            } else
                if (s.startsWith("0")){
                String s3 = s.substring(1);
                    return String.valueOf(Integer.parseInt(s3,8));
                } else
                    return String.valueOf(Integer.parseInt(s));
    }
}
