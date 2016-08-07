package com.kimmin.ms.dao.impl;

import com.kimmin.ms.dao.FollowDAO;
import com.kimmin.ms.entity.Follow;
import com.kimmin.ms.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by t-mijin on 8/6/2016.
 */

@Repository
public class FollowDAOImpl extends GeneralDAOImpl<Follow> implements FollowDAO {
    public FollowDAOImpl(){
        super(Follow.class);
    }


}
