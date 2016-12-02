package com.javarush.test.level15.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* Факториал
Написать метод, который вычисляет факториал - произведение всех чисел от 1 до введенного числа включая его.
Пример: 4! = factorial(4) = 1*2*3*4 = 24
1. Ввести с консоли число меньше либо равно 150.
2. Реализовать функцию  factorial.
3. Если введенное число меньше 0, то вывести 0.
0! = 1
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            int input = Integer.parseInt(reader.readLine());
            if (input > 150){
                throw new ExceptionInInitializerError();
            }
            else
            {
                reader.close();
                System.out.println(factorial(input));
            }
        }
        catch(ExceptionInInitializerError e){
            System.out.println("Число больше 150-ти");
        }
    }

    public static String factorial(int n) {
        int result = 0;
        BigInteger big;
        BigInteger mult;//add your code here
        if (n == 0) {result = 1; return String.valueOf(result);}
        else
        if (n > 0) {
            result = 1;
            big = BigInteger.valueOf(result);
            for (int i = 2; i <= n; i++){
                mult = BigInteger.valueOf(i);
                big = big.multiply(mult);
            }
            return big.toString();
        }
        else
        return String.valueOf(result);
    }
}
