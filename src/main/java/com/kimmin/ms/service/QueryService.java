package com.kimmin.ms.service;

import com.kimmin.ms.dao.DishDAO;
import com.kimmin.ms.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by t-mijin on 8/6/2016.
 */
@Service
@Transactional
public class QueryService {

    @Autowired
    private DishDAO dishDAO;


    public Dish queryDish(int id){
        return dishDAO.queryById(id);
    }

    public List<Dish> queryLowDishes(){
        return dishDAO.getLowDishes();
    }

    public List<Dish> queryMediumDishes(){
        return dishDAO.getMediumDishes();
    }

    public List<Dish> queryHighDishes(){
        return dishDAO.getHighDishes();
    }

    public List<Dish> queryLatestDishes(){
        return dishDAO.getLatestDishes();
    }

}
