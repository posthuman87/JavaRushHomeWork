package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Posthuman on 07.04.2016.
 */
public class SubSolution extends Solution
{
    public SubSolution(int i)
    {
        super(i);
    }

    public SubSolution(double d)
    {
        super(d);
    }

    public SubSolution(byte b)
    {
        super(b);
    }

    protected SubSolution(short sh)
    {
        super(sh);
    }

    protected SubSolution(long l)
    {
        super(l);
    }

    protected SubSolution(float f)
    {
        super(f);
    }

     SubSolution(String s)
    {
        super(s);
    }

     SubSolution(Object o)
    {
        super(o);
    }

     SubSolution(Solution sol)
    {
        super(sol);
    }
    private  SubSolution(Integer in){
        super(in);
    }
    private SubSolution(Double dob){
        super(dob);
    }
    private SubSolution(Byte by){
        super(by);
    }
}
