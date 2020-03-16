package com.minibudget.dao.impl;

import com.minibudget.dao.ExpenseDao;
import com.minibudget.model.ExpenseEntity;
import com.minibudget.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ExpenseDaoImpl implements ExpenseDao {

    @Override
    public ExpenseEntity addExpense(ExpenseEntity expense) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(expense);

        session.getTransaction().commit();

        return expense;
    }

    @Override
    public List<ExpenseEntity> getAllExpense() {
        List<ExpenseEntity> expenses = (List<ExpenseEntity>) HibernateUtil.getSessionFactory().openSession().createQuery("from ExpenseEntity").list();
        return expenses;
    }


}
