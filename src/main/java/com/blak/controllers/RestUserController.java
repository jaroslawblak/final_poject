package com.blak.controllers;


import com.blak.controllers.HandlersException.UserNotFoundException;
import com.blak.model.User;
import com.blak.model.UserResources;
import com.blak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class RestUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = userService.getUsers();
        if (users.isEmpty()) {
            throw new UserNotFoundException("Users not found ");
        }
        return users;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = userService.getUser(id);
        if (user == null) {
            throw new UserNotFoundException("User not found - " + id);
        }
        return user;
    }

//    @GetMapping("/users/{id}")
//    public User getUserByName(@PathVariable String name) {
//        User user = userService.getUser(id);
//        if (user == null) {
//            throw new UserNotFoundException("User not found - " + id);
//        }
//        return user;
//    }

    @PostMapping("/users")
    public void saveUser(@RequestBody User user) {
        user.setId(0);
        userService.saveUser(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userService.getUser(id);
        if (user == null) {
            throw new UserNotFoundException("User not found - " + id);
        }
        userService.deleteUser(id);
    }

    @PostMapping("/users/{id}/usersResources")
    public void addUserResource(@PathVariable int id, @RequestBody UserResources userResources) {
        User user = userService.getUser(id);
        user.getUserResources().add(userResources);
        userService.saveUser(user);

    }
}