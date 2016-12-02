package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    private int top = 0;
    private int left = 0;
    private int width = 0;
    private int height = 0;

    public void initialize(int height, int width, int left, int top){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public void initialize(int left, int top){
        this.top = top;
        this.left = left;
    }

    public void initialize(int width, int left, int top){
        this.width = width;
        this.left = left;
        this.top = top;
        height = width;
    }

    public void initialize(Rectangle rectangle,int height, int width, int left, int top ){
        this.top =rectangle.top;
        this.left = rectangle.left;
        this.width = rectangle.width;
        this.height = rectangle.height;
    }//напишите тут ваш код

}
