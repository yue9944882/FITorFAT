package com.kimmin.ms.service;

import com.kimmin.ms.dao.MenuDAO;
import com.kimmin.ms.dao.MessageDAO;
import com.kimmin.ms.dao.UserDAO;
import com.kimmin.ms.entity.Menu;
import com.kimmin.ms.entity.Message;
import com.kimmin.ms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by t-mijin on 8/7/2016.
 */
public class MessageService {

    @Autowired
    private MessageDAO messageDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private MenuDAO menuDAO;

    public void addCommentMessage(String uid, int mid, String msg){
        User user = userDAO.queryById(uid);
        Menu menu = menuDAO.queryById(mid);
        Message message = new Message();
        message.setMenu(menu);
        message.setUser(user);
        message.setMessage(msg);
        messageDAO.insert(message);
    }

    public void delCommentMessage(int messageId){
        messageDAO.deleteById(messageId);
    }

}
