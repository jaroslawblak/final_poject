package com.blak.service;

import com.blak.model.User;
import com.blak.model.UserResources;

import java.util.List;

public interface UserResourcesService {

    public UserResources getUserResource(int id);
    public void saveUserResource(UserResources userResources);
    public boolean deleteUserResource(int id);
    public User getUserFromResId(int id);
    public List<UserResources> getAllUsersResources();
    public List<UserResources> findUserResourcesByUserId(int userId);
}
