package edu.icet.dao.util.custom.impl;

import edu.icet.dao.util.HibernateUtil;
import edu.icet.dao.util.custom.UserDao;
import edu.icet.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean save(User entity) throws SQLException {
        Session session = HibernateUtil.getSession();;
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User entity) throws SQLException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        User user = session.find(User.class, entity.getEMail());
        user.setEMail(entity.getEMail());
        user.setPassWord(entity.getPassWord());
        user.setUserType(entity.getUserType());
        session.save(user);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(String value) throws SQLException {

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(User.class,value));
        transaction.commit();
        return true;
    }

    @Override
    public List<User> getAll() throws SQLException {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM User");
        List<User> list = query.list();
        return list;
    }

}
