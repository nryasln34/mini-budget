package com.minibudget.dao.impl;

import com.minibudget.dao.IncomeDao;
import com.minibudget.dao.UserDao;
import com.minibudget.model.IncomeEntity;
import com.minibudget.model.UsersEntity;
import com.minibudget.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class IncomeDaoImpl implements IncomeDao {

    private Session getCurrentSession;

    @Override
    public IncomeEntity addIncome(IncomeEntity income) {

      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();

      session.save(income);

      session.getTransaction().commit();

      return income;


        }

    @Override
    public List<IncomeEntity> getAllIncome(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //Şuanki tarih
            Date current = new Date();
            String currentDateSTR = format.format(current);

            //30 gün önceki tarih
            Date old = new Date();
            old.setMonth(old.getMonth() - 1);
            String oldDateSTR = format.format(old);

            Query qry = session.createQuery("From IncomeEntity as rb where str(rb.usersId) like :userId and rb.date between :stDate AND :edDate");
            qry.setString("stDate",oldDateSTR);
            qry.setString("edDate",currentDateSTR);
            qry.setInteger("userId",userId);
            List<IncomeEntity> incomes = (List<IncomeEntity>) qry.list();
            return incomes;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}



