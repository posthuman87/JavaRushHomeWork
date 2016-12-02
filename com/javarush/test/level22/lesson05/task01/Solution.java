package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException
    {
       System.out.println( getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException{
        if (string == null) throw new TooShortStringException();
        int firstInd = string.indexOf(" ") + 1;
        if (firstInd == 0) throw new TooShortStringException();

        int     index = 0,
                ind = 0;

        for (int i = 0; i < 4; i++) {
            ind = string.indexOf(" ",index);
            if (ind == -1) throw new TooShortStringException();
            index = ind+1;
        }

        char[] ch = string.substring(index).toCharArray();
        if (!Character.isLetter(ch[0])) throw new TooShortStringException();

        for(int i = 0; i < ch.length; i++){
            if (!Character.isLetter(ch[i]))
            {
                index += i;
                break;
            }
        }

        return string.substring(firstInd,index);
    }

    public static class TooShortStringException extends Exception{

    }
}
