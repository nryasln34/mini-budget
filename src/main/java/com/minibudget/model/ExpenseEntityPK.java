package com.minibudget.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ExpenseEntityPK implements Serializable {
    private int id;
    private int usersId;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "users_id")
    @Id
    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseEntityPK that = (ExpenseEntityPK) o;
        return id == that.id &&
                usersId == that.usersId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usersId);
    }
}
