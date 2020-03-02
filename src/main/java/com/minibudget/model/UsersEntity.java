package com.minibudget.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "mini_budget", catalog = "")
public class UsersEntity {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, password);
    }
}
