package com.minibudget.dao.impl;

import com.minibudget.dao.UserDao;
import com.minibudget.model.UsersEntity;
import com.minibudget.util.HibernateUtil;
import org.eclipse.jetty.server.Authentication;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public UsersEntity getUserbyEmail(String email) {
        UsersEntity user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //session.createNativeQuery("select0 * from users table").list();
            Query qry = session.createQuery("From UsersEntity as rb where rb.email like :email ");
            if (email!= null)
            {
                qry.setString("email","%"+email+"%");
            }
            List users = qry.list();
            Iterator it = users.iterator();
            while (it.hasNext()) {
                UsersEntity us = (UsersEntity) it.next();
                return us;
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UsersEntity registerUser(UsersEntity user) {

        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return user;

        }
    }


