package com.blak.dao;

import com.blak.model.User;

import java.util.List;

public interface UserDAO {

    public User getUser(int id);
    public void saveUser(User user);
    public boolean deleteUser(int id);
    public  List<User> getUsers();
    public  User getUser(String email);

}
