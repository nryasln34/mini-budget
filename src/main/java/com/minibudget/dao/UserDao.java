package com.minibudget.dao;

import com.minibudget.model.UsersEntity;

public interface UserDao {

    UsersEntity getUserbyUsername(String username);

    void registerUser(UsersEntity user);
}
