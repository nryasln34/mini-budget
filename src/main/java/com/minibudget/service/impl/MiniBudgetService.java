package com.minibudget.service.impl;

import com.minibudget.dao.UserDao;
import com.minibudget.dao.impl.UserDaoImpl;
import com.minibudget.model.User;
import org.springframework.stereotype.Service;
import com.minibudget.util.PasswordUtil;

@Service
public class MiniBudgetService {


    private PasswordUtil passwordUtil;

    private UserDaoImpl userDao;

    public User getUserbyUsername(String username) {
        return userDao.getUserbyUsername(username);
    }

    public boolean checkUser(User user) {
        if(user == null) return false;
        User userFound = userDao.getUserbyUsername(user.getUserName());
        if(userFound == null) {
            return false;
        } else if(user.getUserPassword().equals(userFound.getUserPassword())) {
            return false;
        } else {
            return true;
        }
    }

    /*
    public void registerUser(User user) {
        user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
        userDao.registerUser(user);
    }

    public void addMessage(Message m) {
    }*/
}
