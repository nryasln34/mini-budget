package com.minibudget.dao;

import com.minibudget.model.UsersEntity;

public interface UserDao {

    UsersEntity getUserbyEmail(String email);

    UsersEntity registerUser(UsersEntity user);
}
