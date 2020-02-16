package com.minibudget.service.impl;

import com.minibudget.model.LoginResult;
import com.minibudget.model.Message;
import com.minibudget.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minibudget.util.PasswordUtil;

import com.minibudget.dao.UserDao;
import com.minibudget.dao.MessageDao;

@Service
public class MiniBudgetService {


    private PasswordUtil passwordUtil;

    private UserDao userDao;

    private MessageDao messageDao;

    public User getUserbyUsername(String username) {
        return userDao.getUserbyUsername(username);
    }

    public LoginResult checkUser(User user) {
        LoginResult result = new LoginResult();
        User userFound = userDao.getUserbyUsername(user.getUsername());
        if(userFound == null) {
            result.setError("Invalid username");
        } else if(!PasswordUtil.verifyPassword(user.getPassword(), userFound.getPassword())) {
            result.setError("Invalid password");
        } else {
            result.setUser(userFound);
        }

        return result;
    }
    public void registerUser(User user) {
        user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
        userDao.registerUser(user);
    }

    public void addMessage(Message m) {
    }
}
