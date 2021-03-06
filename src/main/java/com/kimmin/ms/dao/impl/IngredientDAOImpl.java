package com.kimmin.ms.dao.impl;

import com.kimmin.ms.dao.IngredientDAO;
import com.kimmin.ms.entity.Ingredient;
import org.springframework.stereotype.Repository;

/**
 * Created by t-mijin on 8/7/2016.
 */
@Repository
public class IngredientDAOImpl extends GeneralDAOImpl<Ingredient> implements IngredientDAO {

    public IngredientDAOImpl(){
        super(Ingredient.class);
    }

}
