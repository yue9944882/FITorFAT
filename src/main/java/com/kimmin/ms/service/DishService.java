package com.kimmin.ms.service;

import com.kimmin.ms.dao.DishDAO;
import com.kimmin.ms.dao.IngredientDAO;
import com.kimmin.ms.entity.Dish;
import com.kimmin.ms.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by t-mijin on 8/7/2016.
 */


@Service
@Transactional
public class DishService {

    @Autowired
    private DishDAO dishDAO;

    @Autowired
    private IngredientDAO ingredientDAO;

    public void addDish(String name, int location, int weight, int energy, int type, List<Integer> iids){
        Dish dish = new Dish();
        dish.setDolike(0);
        dish.setDislike(0);
        dish.setEnergy(energy);
        dish.setName(name);
        dish.setCreateTime(new Date());
        dish.setLocation(location);
        dish.setWeight(weight);
        dish.setType(type);
        for(Integer iid : iids){
            Ingredient i = ingredientDAO.queryById(iid);
            if(i == null){
                return;
            }else{
                dish.addIngredient(i);
            }
        }
        dishDAO.insert(dish);
    }

    public void delDish(int did){
        dishDAO.deleteById(did);
    }

    public Set<Ingredient> getIngredientByDish(int did){
        Dish dish = dishDAO.queryById(did);
        return dish.getIngredients();
    }

    public void addIngredient(Ingredient ingredient){
        ingredientDAO.insert(ingredient);
    }

    public void delIngredient(int iid){
        ingredientDAO.deleteById(iid);
    }

    public Ingredient getIngredientById(int iid){
        return ingredientDAO.queryById(iid);
    }



}
