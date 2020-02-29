package com.minibudget.dao.impl;

import com.minibudget.dao.UserDao;
import com.minibudget.model.User;

public class UserDaoImpl extends SessionBuilder implements UserDao {

    @Override
    public User getUserbyUsername(String username) {
        User user = getCurrentSession().get(User.class, username);
        return user;
    }

    @Override
    public void registerUser(User user) {
        getCurrentSession().save(user);
    }

}
