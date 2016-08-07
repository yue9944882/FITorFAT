package com.kimmin.ms.dao;

import com.kimmin.ms.entity.Dish;

import java.util.List;

/**
 * Created by t-mijin on 8/6/2016.
 */
public interface DishDAO extends GeneralDAO<Dish> {
    List<Dish> getLowDishes();
    List<Dish> getMediumDishes();
    List<Dish> getHighDishes();
    List<Dish> getLatestDishes();
}
