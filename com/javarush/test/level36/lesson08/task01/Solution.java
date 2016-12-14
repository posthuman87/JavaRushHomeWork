package com.javarush.test.level36.lesson08.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeSet<Character> set = new TreeSet<>();
        while(reader.ready()){
            char[] chars = reader.readLine().toLowerCase().toCharArray();
            char[] s = {'a','b','c','d','e','f','g','h','i','k','l','m','n','o','p','q','r','s','t','v','x','y','z'};
            for (char aChar : chars){
                for (char c : s){
                    if(aChar==c){
                        set.add(aChar);
                        break;
                    }
                }
            }
        }
        int x = 5;
        if (set.size()<5)
            x = set.size();
        Iterator iterator = set.iterator();
        for (int i = 0; i<x; i++){
            System.out.print(iterator.next());
        }
    }
}
