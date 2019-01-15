package com.blak.serviceImpl;

import com.blak.csvgenerator.UserRes.UserResCsvWriter;
import com.blak.dao.UserResourcesDAO;
import com.blak.model.User;
import com.blak.model.UserResources;
import com.blak.service.UserResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.util.List;

@Service
public class UserResourcesServiceImpl implements UserResourcesService {

    @Autowired
    private UserResourcesDAO userResourcesDAO;

    @Autowired
    private UserResCsvWriter userResCsvWriter;

    @Override
    @Transactional
    public UserResources getUserResource(int id) {
        return userResourcesDAO.getUserResource(id);
    }

    @Override
    @Transactional
    public void saveUserResource(UserResources userResources) {
        userResourcesDAO.saveUserResource(userResources);
    }

    @Override
    @Transactional
    public boolean deleteUserResource(int id) {
        return userResourcesDAO.deleteUserResource(id);
    }

    @Override
    @Transactional
    public void getCSVUserResources(Path path) throws Exception {
        this.userResCsvWriter.writeCsv(path);
    }

    @Override
    @Transactional
    public User getUserFromResId(int id) {
        return userResourcesDAO.getUserFromResId(id);
    }

    @Override
    @Transactional
    public List<UserResources> getAllUsersResources() {
        return userResourcesDAO.getAllUsersResources();
    }

    @Override
    @Transactional
    public List<UserResources> findUserResourcesByUserId(int userId) {
        return userResourcesDAO.findUserResourcesByUserId(userId);
    }
}

