package com.javarush.test.level04.lesson10.task04;

import java.io.*;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
       int n = 1;
        int m = 1;
      while(m<=10)
      {
          while (n <= 10)
          {
              System.out.print("S");
              n++;
          }
          System.out.println();
          m++;
          n=1;
      }//напишите тут ваш код

    }
}
