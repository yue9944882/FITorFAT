package com.kimmin.ms.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by t-mijin on 8/1/2016.
 */


@Table
@Entity
public class User {

    public void setId(String id) {
        this.id = id;
    }

    @Id
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (upper != user.upper) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (!Arrays.equals(password, user.password)) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        return registerDate != null ? registerDate.equals(user.registerDate) : user.registerDate == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(password);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + upper;
        return result;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(nullable = false, length = 48)
    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public int getUpper() {
        return upper;
    }

    public void setUpper(int upper) {
        this.upper = upper;
    }

    private byte[] password;


    private String gender;
    private Date registerDate;
    private int upper;

}
