package com.minibudget.dao;
import com.minibudget.model.User;

public interface UserDao {

    User getUserbyUsername(String username);

    void registerUser(User user);
}
