package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.model.service.UserService;
import com.javarush.test.level36.lesson04.big01.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 06.12.2016.
 */
public class MainModel implements Model
{
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData()
    {
        return modelData;
    }

    @Override
    public void loadUsers()
    {
        List<User> users = getActiveUsers(userService.getUsersBetweenLevels(1,100));
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(false);
    }

    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    public void deleteUserById(long id){
        userService.deleteUser(id);
        modelData.setUsers(getActiveUsers(userService.getUsersBetweenLevels(1,100)));
        modelData.setDisplayDeletedUserList(false);
    }

    @Override
    public void changeUserData(String name, long id, int level)
    {
        userService.createOrUpdateUser(name,id,level);
        modelData.setUsers(getActiveUsers(userService.getUsersBetweenLevels(1,100)));
        modelData.setDisplayDeletedUserList(false);
    }

    private List<User> getActiveUsers(List<User> users){
        return userService.filterOnlyActiveUsers(users);
    }
}
