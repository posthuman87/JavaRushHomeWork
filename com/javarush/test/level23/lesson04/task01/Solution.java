package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];
        Solution s1 = new Solution();
        Solution s2 = new Solution();
        for (int i = 0; i < 2; i++)
        {
            s1.innerClasses[i] = s1.new InnerClass();
            s2.innerClasses[i] = s2.new InnerClass();
        }
        solutions[0] = s1;
        solutions[1] = s2;
        return solutions;
    }
}
