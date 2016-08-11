package com.kimmin.ms.dao.impl;

import com.kimmin.ms.dao.DishDAO;
import com.kimmin.ms.dao.GeneralDAO;
import com.kimmin.ms.entity.DI;
import com.kimmin.ms.entity.Dish;
import com.kimmin.ms.entity.Ingredient;
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
        return null;
    }

    public List<Dish> getMediumDishes(){
        return null;
    }

    public List<Dish> getLowDishes(){
        return null;
    }

    public List<Dish> getLatestDishes(){
        return null;
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
