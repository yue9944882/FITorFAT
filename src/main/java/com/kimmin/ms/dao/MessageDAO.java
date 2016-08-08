package com.kimmin.ms.dao;

import com.kimmin.ms.entity.Message;

import java.util.List;

/**
 * Created by t-mijin on 8/7/2016.
 */
public interface MessageDAO extends GeneralDAO<Message> {
    List<Message> getMessageByUser(String uid);
}
