package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Администратор on 22.11.2016.
 */
public class Wall extends CollisionObject
{
    public Wall(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(new Color(150,75,0));
        graphics.fillRect(getX() - getWidth()/2, getY() - getHeight()/2, getWidth(), getHeight());
    }
}
