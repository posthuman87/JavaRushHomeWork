package com.javarush.test.level20.lesson10.bonus01;

import java.util.Vector;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static void main(String[] args)
    {
        int number = 10000000;
        int[] res = getNumbers(number);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }

    public static int[] getNumbers(int N) {
        int[] result = null;
        Vector<Integer> v = new Vector<>();
        for (int i = 1; i < N; i++){
            if (checkFormula(i)) v.add(i);
        }
        result = new int[v.size()];
        for (int j = 0; j < v.size(); j++){
            result[j] = v.get(j);
        }
        return result;
    }

    public static boolean checkFormula(int number){
        if (number == 0) return false; else
            if (number >=1 && number<10) return true; else

            {
                int     digit,
                        temp = number,
                        sum = 0;
                int number_size = (int)Math.log10(number) + 1;
                for (int i = 0; i < number_size; i++){
                    digit = temp%10;
                    temp = temp/10;
                    int prod = digit;
                    for (int j = 1; j < number_size; j++){
                        prod*=digit;
                    }
                    sum+=prod;
                }
                if (sum == number) return true; else
                    return false;
            }
    }
}
