package com.javarush.test.level21.lesson16.big01;


import java.util.ArrayList;

public class Hippodrome
{
    public static Hippodrome game;

    private ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses(){
        return horses;
    }

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();

        Horse h1 = new Horse("Pufik", 3, 0);
        Horse h2 = new Horse("Rafik", 3, 0);
        Horse h3 = new Horse("Pipi", 3, 0);

        game.getHorses().add(h1);
        game.getHorses().add(h2);
        game.getHorses().add(h3);

        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for (int i = 0; i < getHorses().size(); i++){
            getHorses().get(i).move();
        }
    }

    public void print(){
        for (Horse h : getHorses()){
            h.print();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public Horse getWinner(){
        double dist = Integer.MIN_VALUE;
        Horse winner = null;
        for (Horse h : getHorses()){
            if (h.getDistance() >= dist)
            {
                winner = h;
                dist = h.getDistance();
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}
