package com.kimmin.ms.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by t-mijin on 8/1/2016.
 */


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (upper != user.upper) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (!Arrays.equals(password, user.password)) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        return registerDate != null ? registerDate.equals(user.registerDate) : user.registerDate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(password);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + upper;
        return result;
    }

    private byte[] password;


    private String gender;
    private Date registerDate;
    private int upper;

}
