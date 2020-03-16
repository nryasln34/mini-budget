package com.minibudget.dao;

import com.minibudget.model.IncomeEntity;

import java.util.List;

public interface IncomeDao {

     IncomeEntity addIncome(IncomeEntity income);

     List<IncomeEntity> getAllIncome();
}
