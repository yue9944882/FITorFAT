package com.kimmin.ms.dao.impl;

import com.kimmin.ms.dao.DishDAO;
import com.kimmin.ms.dao.GeneralDAO;
import com.kimmin.ms.entity.DI;
import com.kimmin.ms.entity.Dish;
import com.kimmin.ms.entity.Ingredient;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by t-mijin on 8/6/2016.
 */


@Repository
public class DishDAOImpl extends GeneralDAOImpl<Dish> implements DishDAO {

    public DishDAOImpl(){
        super(Dish.class);
    }

    public List<Dish> getHighDishes(){
        String hql = "from Dish where type = :type";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("type", 0);
        query.setMaxResults(6);
        return query.list();
    }

    public List<Dish> getMediumDishes(){
        String hql = "from Dish where type = :type";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("type", 1);
        query.setMaxResults(6);
        return query.list();
    }

    public List<Dish> getLowDishes(){
        String hql = "from Dish where type = :type";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("type", 2);
        query.setMaxResults(6);
        return query.list();
    }

    public List<Dish> getLatestDishes(){
        String hql = "from Dish order by createTime";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setMaxResults(6);
        return query.list();
    }

    public void createDish(Dish dish, List<Map<String, Object>> iids){
        Session session = sessionFactory.getCurrentSession();
        Transaction tx= session.beginTransaction();
        tx.setTimeout(5);
        Integer did = (Integer) session.save(dish);
        Dish d = (Dish) session.get(Dish.class, did);
        for(Map<String, Object> iid : iids){
            Integer _iid = (Integer) iid.get("id");
            Double p = (Double) iid.get("percentage");
            Ingredient i = (Ingredient) session.get(Ingredient.class, _iid);
            DI di = new DI();
            di.setIngredient(i);
            di.setPercentage(p);
            di.setDish(d);
            d.addDi(di);
            i.addDi(di);
//            session.saveOrUpdate(i);
            session.saveOrUpdate(di);
//            session.saveOrUpdate(d);
        }
//        session.saveOrUpdate(d);
        tx.commit();
        session.flush();
    }

}
