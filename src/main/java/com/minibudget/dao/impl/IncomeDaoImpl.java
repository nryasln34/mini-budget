package com.minibudget.dao.impl;

import com.minibudget.dao.IncomeDao;
import com.minibudget.dao.UserDao;
import com.minibudget.model.IncomeEntity;
import com.minibudget.model.UsersEntity;
import com.minibudget.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

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
    public List<IncomeEntity> getAllIncome() {
        List<IncomeEntity> incomes = (List<IncomeEntity>) getCurrentSession.createQuery("from IncomeEntity");
        return incomes;
    }

}



