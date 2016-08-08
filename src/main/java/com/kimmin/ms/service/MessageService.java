package com.kimmin.ms.service;

import com.kimmin.ms.dao.MenuDAO;
import com.kimmin.ms.dao.MessageDAO;
import com.kimmin.ms.dao.UserDAO;
import com.kimmin.ms.entity.Menu;
import com.kimmin.ms.entity.Message;
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

    public List<Message> getMessageByUser(String uid){
        return messageDAO.getMessageByUser(uid);
    }

    public Set<Message> getMessageByMenu(int mid){
        Menu menu = menuDAO.queryById(mid);
        return menu == null ? null : menu.getMessages();
    }

}
