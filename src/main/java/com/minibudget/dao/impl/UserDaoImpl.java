package com.minibudget.dao.impl;

import com.minibudget.dao.UserDao;
import com.minibudget.model.UsersEntity;
import com.minibudget.util.HibernateUtil;
import org.eclipse.jetty.server.Authentication;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public UsersEntity getUserbyUsername(String username) {
        UsersEntity user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //session.createNativeQuery("select * from users table").list();
            Query qry = session.createQuery("From UsersEntity as rb where rb.name like :name ");
            if (username!= null)
            {
                qry.setString("name","%"+username+"%");
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
    public void registerUser(UsersEntity user) {
    }

}
