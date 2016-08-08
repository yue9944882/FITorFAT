package com.kimmin.ms.service;

import com.kimmin.ms.dao.DishDAO;
import com.kimmin.ms.dao.MenuDAO;
import com.kimmin.ms.dao.UserDAO;
import com.kimmin.ms.entity.Dish;
import com.kimmin.ms.entity.Menu;
import com.kimmin.ms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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

    @Autowired
    private UserDAO userDAO;

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

    public Set<Dish> getDishOfMenu(int mid){
        Menu menu = menuDAO.queryById(mid);
        return menu.getDishes();
    }

    public Set<Menu> getMenuByUser(String uid){
        User user = userDAO.queryById(uid);
        Set<Menu> menus = user.getMenus();
        return menus;
    }

}
