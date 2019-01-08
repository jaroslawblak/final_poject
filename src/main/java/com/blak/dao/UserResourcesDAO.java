package com.blak.dao;

import com.blak.model.Resource;
import com.blak.model.User;
import com.blak.model.UserResources;

import java.util.List;

public interface UserResourcesDAO {

    public UserResources getUserResource(int id);
    public User getUserFromResId(int id);
    public void saveUserResource(UserResources userResources);
    public boolean deleteUserResource(int id);
    public List<UserResources> getAllUsersResources();
    public List<UserResources> findUserResourcesByUserId(int id);
    public List<UserResources> findUserResourcesByResource(Resource resource);
}
