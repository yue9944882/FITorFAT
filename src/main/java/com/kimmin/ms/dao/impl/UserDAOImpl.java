package com.kimmin.ms.dao.impl;

import com.kimmin.ms.dao.GeneralDAO;
import com.kimmin.ms.dao.UserDAO;
import com.kimmin.ms.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by t-mijin on 8/6/2016.
 */


@Repository
public class UserDAOImpl extends GeneralDAOImpl<User> implements UserDAO {
    public UserDAOImpl(){
        super(User.class);
    }

}
