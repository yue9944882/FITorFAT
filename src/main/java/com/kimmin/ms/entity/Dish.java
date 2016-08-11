package com.kimmin.ms.entity;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by t-mijin on 8/1/2016.
 */

@Entity
@Table
@Embeddable
public class Dish implements Serializable {

    private int id;
    private String name;
    private Date createTime;
    private int weight;
    private int dolike;
    private int dislike;
    private int location;
    private int energy;
    private int type;
    @JsonIgnore
    private Set<Menu> menus = new HashSet<Menu>();
    //private Set<Ingredient> ingredients = new HashSet<Ingredient>();
    private Set<DI> dis = new HashSet<DI>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(nullable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(nullable = false)
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Basic
    @Column(nullable = false)
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

    @Basic
    @Column(nullable = false)
    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    @Basic
    @Column(nullable = false)
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Basic
    @Column(nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @ManyToMany(mappedBy = "dishes", fetch = FetchType.EAGER)
    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

//    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinTable(name = "DI",
//            joinColumns = {@JoinColumn(name = "did", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "iid", referencedColumnName = "id")}
//    )
//    public Set<Ingredient> getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(Set<Ingredient> ingredients) {
//        this.ingredients = ingredients;
//    }
//
//    public void addIngredient(Ingredient ingredient){
//        this.ingredients.add(ingredient);
//    }
//
//    public void removeIngredient(Ingredient ingredient){
//        this.ingredients.remove(ingredient);
//    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dish", fetch = FetchType.EAGER)
    public Set<DI> getDis() {
        return dis;
    }

    public void setDis(Set<DI> dis) {
        this.dis = dis;
    }

    public void addDi(DI di){
        dis.add(di);
    }

    public void removeDi(DI di){
        dis.remove(di);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (id != dish.id) return false;
        if (weight != dish.weight) return false;
        if (dolike != dish.dolike) return false;
        if (dislike != dish.dislike) return false;
        if (location != dish.location) return false;
        if (energy != dish.energy) return false;
        if (type != dish.type) return false;
        if (name != null ? !name.equals(dish.name) : dish.name != null) return false;
        return createTime != null ? createTime.equals(dish.createTime) : dish.createTime == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + weight;
        result = 31 * result + dolike;
        result = 31 * result + dislike;
        result = 31 * result + location;
        result = 31 * result + energy;
        result = 31 * result + type;
        return result;
    }
}
