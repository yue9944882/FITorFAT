package com.kimmin.ms.service;

import com.kimmin.ms.dao.FollowDAO;
import com.kimmin.ms.entity.Follow;
import com.kimmin.ms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by t-mijin on 8/7/2016.
 */

@Service
@Transactional
public class FollowService {

    @Autowired
    private FollowDAO followDAO;

    public void addNewFollowRelation(User u1, User u2){
        Follow follow = new Follow();
        follow.setUser1(u1);
        follow.setUser2(u2);
        followDAO.insert(follow);
    }

    public void deleteFollowRelation(User u1, User u2){
        Follow follow = new Follow();
        follow.setUser1(u1);
        follow.setUser2(u2);
        followDAO.delete(follow);
    }

}
