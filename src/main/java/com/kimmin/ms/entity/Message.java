package com.kimmin.ms.entity;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;

/**
 * Created by t-mijin on 8/1/2016.
 */


@Table
@Entity
public class Message {

    private int id;
    private String message;
    private User user;
    private Menu menu;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(nullable = false)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "uid", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "mid", nullable = false)
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;

        if (id != message1.id) return false;
        if (message != null ? !message.equals(message1.message) : message1.message != null) return false;
        if (user != null ? !user.equals(message1.user) : message1.user != null) return false;
        return menu != null ? menu.equals(message1.menu) : message1.menu == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (menu != null ? menu.hashCode() : 0);
        return result;
    }

}
