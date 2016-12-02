package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 22.11.2016.
 */
public class LevelLoader
{
    private Path levels;

    public LevelLoader(Path levels)
    {
        this.levels = levels;
    }

    public GameObjects getLevel(int level){
        int tmpLevel = level;
        if (tmpLevel > 60){
            tmpLevel-=60;
        }
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        try{
            int cellSize = Model.FIELD_SELL_SIZE;
            int x0 = cellSize/2;
            int y0 = cellSize/2;

            BufferedReader reader = new BufferedReader(new FileReader(levels.toString()));
            while (!(reader.readLine().contains("Maze: "+tmpLevel)));
            reader.readLine();
            reader.readLine();
            double y = Double.parseDouble(reader.readLine().split(" ")[2]);
            reader.readLine();
            reader.readLine();
            reader.readLine();

            for (int i = 0; i < y; i++)
            {
                String string = reader.readLine();
                for (int j = 0; j < string.length(); j++)
                {
                    switch (string.charAt(j)){
                        case 'X' :
                            walls.add(new Wall(x0+j*cellSize,y0+i*cellSize));
                            break;
                        case '@' :
                            player = new Player(x0+j*cellSize,y0+i*cellSize);
                            break;
                        case '*' :
                            boxes.add(new Box(x0+j*cellSize,y0+i*cellSize));
                            break;
                        case '.' :
                            homes.add(new Home(x0+j*cellSize,y0+i*cellSize));
                            break;
                        case '&' :
                            homes.add(new Home(x0+j*cellSize,y0+i*cellSize));
                            boxes.add(new Box(x0+j*cellSize,y0+i*cellSize));
                            break;
                    }
                }
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }


        return new GameObjects(walls, boxes, homes, player);
    }
}
