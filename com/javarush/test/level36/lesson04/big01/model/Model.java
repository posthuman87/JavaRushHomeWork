package com.javarush.test.level36.lesson04.big01.model;

/**
 * Created by Администратор on 06.12.2016.
 */
public interface Model
{
    ModelData getModelData();

    void loadUsers();

    void loadDeletedUsers();

    void loadUserById(long UserId);

    void deleteUserById(long id);

    void changeUserData(String name, long id, int level);
}
