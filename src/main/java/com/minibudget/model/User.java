package com.minibudget.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users table", schema = "mini_budget", catalog = "")
public class User {
    private int userId;
    private String userName;
    private String userSurname;
    private String userEmail;
    private String userPassword;

    @Id
    @Column(name = "user id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user surname")
    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    @Basic
    @Column(name = "user email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                userName.equals(user.userName) &&
                userSurname.equals(user.userSurname) &&
                userEmail.equals(user.userEmail) &&
                userPassword.equals(user.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userSurname, userEmail, userPassword);
    }
}
