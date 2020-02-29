package com.minibudget.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "expense table", schema = "mini_budget", catalog = "")
public class Expense {
    private int expenseId;
    private String expenseType;
    private int expenseAmount;
    private String expenseCurrency;
    private String expenseDate;
    private String expenseNotes;

    @Id
    @Column(name = "expense id")
    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    @Basic
    @Column(name = "expense type")
    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    @Basic
    @Column(name = "expense amount")
    public int getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(int expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    @Basic
    @Column(name = "expense currency")
    public String getExpenseCurrency() {
        return expenseCurrency;
    }

    public void setExpenseCurrency(String expenseCurrency) {
        this.expenseCurrency = expenseCurrency;
    }

    @Basic
    @Column(name = "expense date")
    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    @Basic
    @Column(name = "expense notes")
    public String getExpenseNotes() {
        return expenseNotes;
    }

    public void setExpenseNotes(String expenseNotes) {
        this.expenseNotes = expenseNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense that = (Expense) o;
        return expenseId == that.expenseId &&
                expenseAmount == that.expenseAmount &&
                Objects.equals(expenseType, that.expenseType) &&
                Objects.equals(expenseCurrency, that.expenseCurrency) &&
                Objects.equals(expenseDate, that.expenseDate) &&
                Objects.equals(expenseNotes, that.expenseNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expenseId, expenseType, expenseAmount, expenseCurrency, expenseDate, expenseNotes);
    }
}
