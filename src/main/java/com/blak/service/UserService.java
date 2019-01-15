package com.blak.service;

import com.blak.model.User;

import java.nio.file.Path;
import java.util.List;

public interface UserService {

    public User getUser(int id);
    public void saveUser(User user);
    public void getCSVUsers (Path path) throws Exception;
    public boolean deleteUser(int id);
    public  List<User> getUsers();
    public User getUser(String email);


}
