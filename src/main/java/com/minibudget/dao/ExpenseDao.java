package com.minibudget.dao;

import com.minibudget.model.ExpenseEntity;

import java.util.List;

public interface ExpenseDao {

    ExpenseEntity addExpense(ExpenseEntity expense);

    List<ExpenseEntity> getAllExpense(int userId);
}
