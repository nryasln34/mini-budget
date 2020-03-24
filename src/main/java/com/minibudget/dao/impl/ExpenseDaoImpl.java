package com.minibudget.dao.impl;

import com.minibudget.dao.ExpenseDao;
import com.minibudget.model.ExpenseEntity;
import com.minibudget.model.UsersEntity;
import com.minibudget.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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
    public List<ExpenseEntity> getAllExpense(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            //Şuanki tarih
            Date current = new Date();
            String currentDateSTR = format.format(current);

            //30 gün önceki tarih
            Date old = new Date();
            old.setMonth(old.getMonth() - 1);
            String oldDateSTR = format.format(old);
            //session.createNativeQuery("select0 * from users table").list();

            Query qry = session.createQuery("From ExpenseEntity as rb where str(rb.usersId) like :userId and rb.date between :stDate AND :edDate");
            qry.setString("stDate",oldDateSTR);
            qry.setString("edDate",currentDateSTR);
            qry.setInteger("userId",userId);
            List<ExpenseEntity> expenses = (List<ExpenseEntity>) qry.list();
            return expenses;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
