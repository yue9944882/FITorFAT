package com.kimmin.ms.service;

import com.kimmin.ms.dao.UserDAO;
import com.kimmin.ms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by t-mijin on 8/6/2016.
 */

@Service
@Transactional
public class AuthService {

    @Autowired
    private UserDAO userDAO;


    public boolean checkUser(String uid, String password){
        User user = userDAO.queryById(uid);
        if(user == null) return false;
        try{
            byte[] orgPasswd = user.getPassword();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] rawPasswd = md.digest();
            return Arrays.equals(orgPasswd, rawPasswd);
        }catch (Throwable e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean registerUser(String uid, String password, String gender, String name, int upper){
        /** Check if user exists **/
        User user = userDAO.queryById(uid);
        if(user != null) return false;
        try{
            User newUser = new User();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] rawPasswd = md.digest();
            newUser.setGender(gender);
            newUser.setPassword(rawPasswd);
            newUser.setRegisterDate(new java.util.Date());
            newUser.setId(uid);
            newUser.setName(name);
            newUser.setUpper(upper);
            userDAO.insert(newUser);
            return true;
        }catch (Throwable e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyUser(String uid, String password, String gender, String name, int upper){
        /** Check if user exists **/
        User user = userDAO.queryById(uid);
        if(user == null) return false;
        try{
            if(password != null){
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                byte[] rawPasswd = md.digest();
                user.setPassword(rawPasswd);
            }
            if(gender != null) user.setGender(gender);
            if(name != null) user.setName(name);
            if(upper != 0) user.setUpper(upper);
            userDAO.update(user);
            return true;
        }catch (Throwable e){
            e.printStackTrace();
            return false;
        }
    }

    public User getUserById(String uid){
        return userDAO.queryById(uid);
    }


}
