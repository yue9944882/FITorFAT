package com.kimmin.ms.entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by t-mijin on 8/1/2016.
 */

@Entity
@Table
public class Menu {

    private int id;
    private Date date;
    private int dolike;
    private int dislike;
    private Set<Dish> dishes = new HashSet<Dish>();
    @JsonIgnore
    private Set<Message> messages = new HashSet<Message>();
    private User user;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = false)
    @Basic
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(nullable = false)
    @Basic
    public int getDolike() {
        return dolike;
    }

    public void setDolike(int dolike) {
        this.dolike = dolike;
    }

    @Basic
    @Column(nullable = false)
    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "MD",
            joinColumns = {@JoinColumn(name = "did", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "mid", referencedColumnName = "id")}
    )
    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDish(Dish dish){
        this.dishes.add(dish);
    }

    public void removeDish(Dish dish){
        this.dishes.remove(dish);
    }

    @Basic
    @Column
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "menu", fetch = FetchType.EAGER)
    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public void addMessage(Message message){
        this.messages.add(message);
    }

    public void removeMessage(Message message){
        this.messages.remove(message);
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "uid", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (id != menu.id) return false;
        if (dolike != menu.dolike) return false;
        if (dislike != menu.dislike) return false;
        if (date != null ? !date.equals(menu.date) : menu.date != null) return false;
        return user != null ? user.equals(menu.user) : menu.user == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + dolike;
        result = 31 * result + dislike;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
