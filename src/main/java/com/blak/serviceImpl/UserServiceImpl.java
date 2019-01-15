package com.blak.serviceImpl;

import com.blak.csvgenerator.user.UserCsvWriter;
import com.blak.dao.UserDAO;
import com.blak.model.User;
import com.blak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserCsvWriter UserCsvWriter;

    @Override
    @Transactional
    public User getUser(int id) {
        return userDao.getUser(id);
    }


    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void getCSVUsers(Path path) throws Exception {
        this.UserCsvWriter.writeCsv(path);
    }

    @Override
    @Transactional
    public boolean deleteUser(int id) {
        return userDao.deleteUser(id);
    }


    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public User getUser(String email) {
        return userDao.getUser(email);
    }


}
