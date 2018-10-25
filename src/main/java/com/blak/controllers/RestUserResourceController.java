package com.blak.controllers;

import com.blak.controllers.HandlersException.UserNotFoundException;
import com.blak.model.UserResources;
import com.blak.service.UserResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestUserResourceController {

    @Autowired
    private UserResourcesService userResourcesService;

    @GetMapping("/usersResources")
    public List<UserResources> getUsersResources() {
        List<UserResources> usersResources = userResourcesService.getAllUsersResources();
        return usersResources;
    }

    @GetMapping("/usersResources/{id}")
    public UserResources getUserResource(@PathVariable int id) {
        UserResources userResources = userResourcesService.getUserResource(id);
        return userResources;
    }

    @PostMapping("/usersResources")
    public void saveUserResource(@RequestBody UserResources userResources) {
        userResources.setId(0);
        userResourcesService.saveUserResource(userResources);
    }

    @PutMapping("/usersResources")
    public void updateUser(@RequestBody UserResources userResources) {
        userResourcesService.saveUserResource(userResources);
    }

    @DeleteMapping("/usersResources/{id}")
    public void deleteUser(@PathVariable int id) {
        UserResources userResources = userResourcesService.getUserResource(id);
        if (userResources == null) {
            throw new UserNotFoundException("User not found - " + id);
        }
        userResourcesService.deleteUserResource(id);
    }

}