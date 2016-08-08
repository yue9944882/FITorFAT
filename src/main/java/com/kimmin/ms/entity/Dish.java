package com.kimmin.ms.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by t-mijin on 8/1/2016.
 */

@Entity
@Table
public class Dish {

    private int id;
    private String name;
    private Date createTime;
    private int weight;
    private int dolike;
    private int dislike;
    private int location;
    private int energy;
    private int type;
    private Set<Menu> menus;
    private Set<Ingredient> ingredients;

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

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "MD",
            joinColumns = {@JoinColumn(name = "did", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "mid", referencedColumnName = "id")}
    )
    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "DI",
            joinColumns = {@JoinColumn(name = "did", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "iid", referencedColumnName = "id")}
    )
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient){
        this.ingredients.remove(ingredient);
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
        if (createTime != null ? !createTime.equals(dish.createTime) : dish.createTime != null) return false;
        if (menus != null ? !menus.equals(dish.menus) : dish.menus != null) return false;
        return ingredients != null ? ingredients.equals(dish.ingredients) : dish.ingredients == null;

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
        result = 31 * result + (menus != null ? menus.hashCode() : 0);
        result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
        return result;
    }
}
