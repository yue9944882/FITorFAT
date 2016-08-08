package com.kimmin.ms.dao.impl;

import com.kimmin.ms.dao.MessageDAO;
import com.kimmin.ms.entity.Message;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by t-mijin on 8/7/2016.
 */
@Repository
public class MessageDAOImpl extends GeneralDAOImpl<Message> implements MessageDAO {
    public MessageDAOImpl(){
        super(Message.class);
    }

    public List<Message> getMessageByUser(String uid){
        String hql = "from Message where user = :user";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("user", uid);
        return (List<Message>) query.list();
    }

}
