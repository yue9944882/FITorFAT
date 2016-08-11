package com.kimmin.ms.service;

import com.kimmin.ms.dao.DIDAO;
import com.kimmin.ms.dao.DishDAO;
import com.kimmin.ms.dao.IngredientDAO;
import com.kimmin.ms.entity.DI;
import com.kimmin.ms.entity.Dish;
import com.kimmin.ms.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    @Autowired
    private DIDAO dIDAO;

    public void addDish(String name, int location, int weight, int energy, int type, List<Map<String, Object>> iids){
        Dish dish = new Dish();
        dish.setDolike(0);
        dish.setDislike(0);
        dish.setEnergy(energy);
        dish.setName(name);
        dish.setCreateTime(new Date());
        dish.setLocation(location);
        dish.setWeight(weight);
        dish.setType(type);
        dishDAO.createDish(dish, iids);
    }

    public void delDish(int did){
        dishDAO.deleteById(did);
    }

    public Set<Ingredient> getIngredientByDish(int did){
        Dish dish = dishDAO.queryById(did);
        Set<DI> dis = dish.getDis();
        Set<Ingredient> is = new HashSet<Ingredient>();
        for(DI di: dis){
            is.add(di.getIngredient());
        }
        return is;
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
