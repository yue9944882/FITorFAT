package com.kimmin.ms.dao.impl;

import com.kimmin.ms.dao.MenuDAO;
import com.kimmin.ms.entity.Menu;

/**
 * Created by t-mijin on 8/7/2016.
 */
public class MenuDAOImpl extends GeneralDAOImpl<Menu> implements MenuDAO {
    public MenuDAOImpl(){
        super(Menu.class);
    }
}
