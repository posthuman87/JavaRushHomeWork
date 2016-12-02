package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        ArrayList<Integer> listA = Del(a);
        ArrayList<Integer> listB = Del(b);
        System.out.println(ObsDel(listA,listB).get(0));
    }

    private static ArrayList<Integer> Del(int x){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = x; i > 0 ; i--){
            if (x % i == 0) list.add(i);
        }
        return list;
    }

    private static ArrayList<Integer> ObsDel(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < a.size(); i++){
            for (int j = 0; j < b.size(); j++){
                if (a.get(i) == b.get(j)) list.add(a.get(i));
            }
        }
        return list;
    }

}
