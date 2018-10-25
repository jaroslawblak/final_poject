package com.blak.service;

import com.blak.model.User;

import java.util.List;

public interface UserService {

    public User getUser(int id);
    public void saveUser(User user);
    public boolean deleteUser(int id);
    public  List<User> getUsers();

}
