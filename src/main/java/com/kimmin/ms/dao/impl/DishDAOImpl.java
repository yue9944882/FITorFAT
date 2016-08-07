package com.kimmin.ms.dao.impl;

import com.kimmin.ms.dao.DishDAO;
import com.kimmin.ms.dao.GeneralDAO;
import com.kimmin.ms.entity.Dish;
import org.springframework.stereotype.Repository;

import java.util.List;

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

}
