package com.minibudget.service.impl;

import com.minibudget.dao.UserDao;
import com.minibudget.dao.impl.UserDaoImpl;
import com.minibudget.model.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minibudget.util.PasswordUtil;

@Service
public class MiniBudgetService {


    private PasswordUtil passwordUtil;

    @Autowired
    private UserDao userDao;

    public UsersEntity getUserbyUsername(String username) {
        return userDao.getUserbyUsername(username);
    }

    public boolean checkUser(UsersEntity user) {
        if(user == null) return false;
        UsersEntity userFound = userDao.getUserbyUsername(user.getName());
        if(userFound == null) {
            return false;
        } else if(!user.getPassword().equals(userFound.getPassword())) {
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
