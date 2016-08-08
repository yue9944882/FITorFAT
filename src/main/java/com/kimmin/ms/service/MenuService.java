package com.kimmin.ms.service;

import com.kimmin.ms.dao.DishDAO;
import com.kimmin.ms.dao.MenuDAO;
import com.kimmin.ms.entity.Dish;
import com.kimmin.ms.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by t-mijin on 8/7/2016.
 */


@Service
@Transactional
public class MenuService {

    @Autowired
    private MenuDAO menuDAO;

    @Autowired
    private DishDAO dishDAO;

    public void addMenu(String uid, List<Integer> dids){
        Menu menu = new Menu();
        for(int did : dids){
            Dish dish = dishDAO.queryById(did);
            menu.addDish(dish);
        }
        menuDAO.insert(menu);
    }

    public void delMenu(int mid){
        menuDAO.deleteById(mid);
    }

}
