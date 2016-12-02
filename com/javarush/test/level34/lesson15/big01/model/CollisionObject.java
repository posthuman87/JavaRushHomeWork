package com.javarush.test.level34.lesson15.big01.model;

/**
 * Created by Администратор on 20.11.2016.
 */
public abstract class CollisionObject extends GameObject
{
    public CollisionObject(int x, int y)
    {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction){
        switch (direction){
            case LEFT:
                return ((getX() - Model.FIELD_SELL_SIZE) == gameObject.getX() && getY() == gameObject.getY());
            case RIGHT:
                return ((getX() + Model.FIELD_SELL_SIZE) == gameObject.getX() && getY() == gameObject.getY());
            case UP:
                return ((getY() - Model.FIELD_SELL_SIZE) == gameObject.getY() && getX() == gameObject.getX());
            case  DOWN:
                return ((getY() + Model.FIELD_SELL_SIZE) == gameObject.getY() && getX() == gameObject.getX());
        }

        return false;
    }
}
