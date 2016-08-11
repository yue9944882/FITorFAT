package com.kimmin.ms.dao.impl;

import com.kimmin.ms.dao.GeneralDAO;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class GeneralDAOImpl<T> implements GeneralDAO<T> {
    private Class<T> entityClass;

    public GeneralDAOImpl(Class<T> classes){
        this.entityClass = classes;
//        Configuration cfg = new Configuration();
//        sessionFactory = cfg.buildSessionFactory();
    }

    @Autowired
    protected SessionFactory sessionFactory;

    public void insert(T t){
        sessionFactory.getCurrentSession().save(t);
    }

    public Serializable insertAuto(T t){
        return sessionFactory.getCurrentSession().save(t);
    }

    public void delete(T t){
        sessionFactory.getCurrentSession().delete(t);
    }
    public void update(T t){
        sessionFactory.getCurrentSession().update(t);
    }

    @SuppressWarnings("unchecked")
    public T queryById(String id){
        return (T) sessionFactory.getCurrentSession().get(entityClass,id);
    }

    @SuppressWarnings("unchecked")
    public T queryById(int id) {
        return (T) sessionFactory.getCurrentSession().get(entityClass, id);
    }

    public List<T> queryAll(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(entityClass);
        return criteria.list();
    }
    public void deleteById(String id){
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        T t = (T) session.get(entityClass, id);
        session.delete(t);
        tx.commit();
    }

    public void deleteById(int id){
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        T t = (T) session.get(entityClass, id);
        session.delete(t);
        tx.commit();
    }
}
