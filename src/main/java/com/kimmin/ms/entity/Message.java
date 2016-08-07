package com.kimmin.ms.entity;

import javax.persistence.*;

/**
 * Created by t-mijin on 8/1/2016.
 */


@Table
@Entity
public class Message {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;

        if (id != message1.id) return false;
        if (uid != null ? !uid.equals(message1.uid) : message1.uid != null) return false;
        if (mid != null ? !mid.equals(message1.mid) : message1.mid != null) return false;
        return message != null ? message.equals(message1.message) : message1.message == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (mid != null ? mid.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String uid;

    private String mid;
    private String message;

}
