package com.kimmin.ms.entity;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by t-mijin on 8/1/2016.
 */

@Entity
@Table
public class Ingredient {

    private int id;
    private String name;
    private String caloric;
    private Set<Dish> dishes;

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
    public String getCaloric() {
        return caloric;
    }

    public void setCaloric(String caloric) {
        this.caloric = caloric;
    }

    @ManyToMany(mappedBy = "ingredients")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (caloric != null ? !caloric.equals(that.caloric) : that.caloric != null) return false;
        return dishes != null ? dishes.equals(that.dishes) : that.dishes == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (caloric != null ? caloric.hashCode() : 0);
        result = 31 * result + (dishes != null ? dishes.hashCode() : 0);
        return result;
    }
}
