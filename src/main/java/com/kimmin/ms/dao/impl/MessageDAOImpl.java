package com.kimmin.ms.dao.impl;

import com.kimmin.ms.dao.MessageDAO;
import com.kimmin.ms.entity.Message;

/**
 * Created by t-mijin on 8/7/2016.
 */
public class MessageDAOImpl extends GeneralDAOImpl<Message> implements MessageDAO {
    public MessageDAOImpl(){
        super(Message.class);
    }
}
