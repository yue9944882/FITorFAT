package com.kimmin.ms.service;

import com.kimmin.ms.dao.DishDAO;
import com.kimmin.ms.entity.Dish;
import com.kimmin.ms.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by t-mijin on 8/7/2016.
 */


@Service
@Transactional
public class DishService {

    @Autowired
    private DishDAO dishDAO;

    public void addDish(Dish dish){
        dishDAO.insert(dish);
    }

    public void delDish(int did){
        dishDAO.deleteById(did);
    }

    public Set<Ingredient> getIngredientByDish(int did){
        Dish dish = dishDAO.queryById(did);
        return dish.getIngredients();
    }

}
