package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.io.File;

/**
 * Created by Администратор on 18.11.2016.
 */
public class Model
{
    private EventListener eventListener;
    private GameObjects gameObjects;
    private static int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(new File("C:\\Users\\Администратор\\Downloads\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\levels.txt").toPath());
    public static final int FIELD_SELL_SIZE = 20;

    public static int getCurrentLevel()
    {
        return currentLevel;
    }

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects()
    {
        return gameObjects;
    }

    public void restartLevel(int level){
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart(){
        restartLevel(currentLevel);
    }

    public void startNextLevel(){
        currentLevel++;
        restart();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        for (Wall wall : gameObjects.getWalls())
        {
            if (gameObject.isCollision(wall,direction))
                return true;
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction){
        Player player = gameObjects.getPlayer();

        GameObject stoped = null;
        for (GameObject gameObject : gameObjects.getAll())
        {
            if (!(gameObject instanceof Player)&&!(gameObject instanceof Home)&&player.isCollision(gameObject,direction))
                stoped = gameObject;
        }

        if (stoped == null)
            return false;

        if (stoped instanceof Box){
            Box stopBox = (Box)stoped;
            if (checkWallCollision(stopBox,direction))
                return true;
            for (Box box : gameObjects.getBoxes())
            {
                if (stopBox.isCollision(box,direction))
                    return true;
            }

        switch (direction)
        {
            case LEFT:
                stopBox.move(-FIELD_SELL_SIZE, 0);
                break;
            case RIGHT:
                stopBox.move(FIELD_SELL_SIZE, 0);
                break;
            case UP:
                stopBox.move(0, -FIELD_SELL_SIZE);
                break;
            case DOWN:
                stopBox.move(0, FIELD_SELL_SIZE);
        }
    }
        return false;
    }

    public void checkCompletion(){
        boolean yep = true;

        for (Home home : gameObjects.getHomes())
        {
            boolean yes = false;
            for (Box box : gameObjects.getBoxes())
            {
                if (home.getX() == box.getX() && home.getY() == box.getY())
                    yes = true;
            }
            if (!yes)
                yep = false;
        }

        if (yep) {
            eventListener.levelCompleted(currentLevel);
        }
    }

    public void move(Direction direction){
        Player player = gameObjects.getPlayer();

        if (checkWallCollision(player, direction))
            return;

        if (checkBoxCollision(direction))
            return;

        int sellSize = FIELD_SELL_SIZE;
        switch (direction) {
            case LEFT:
                player.move(-sellSize, 0);
                break;
            case RIGHT:
                player.move(sellSize, 0);
                break;
            case UP:
                player.move(0, -sellSize);
                break;
            case DOWN:
                player.move(0, sellSize);
        }
        checkCompletion();
    }
}
