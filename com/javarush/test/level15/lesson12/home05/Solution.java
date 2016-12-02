package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution(int i){}
    public Solution(double d){}
    public Solution(byte b){}

    protected Solution(short sh){}
    protected Solution(long l){}
    protected Solution(float f){}

    Solution(String s){}
    Solution(Object o){}
    Solution(Solution sol){}

    private Solution(Integer in){}
    private Solution(Double dob){}
    private Solution(Byte by){}
}

