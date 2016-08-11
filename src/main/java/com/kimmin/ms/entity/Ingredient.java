package com.kimmin.ms.entity;



import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by t-mijin on 8/1/2016.
 */

@Entity
@Table
@Embeddable
public class Ingredient implements Serializable {

    private int id;
    private String name;
    private double caloric;
    //@JsonIgnore
    //private Set<Dish> dishes = new HashSet<Dish>();
    @JsonIgnore
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
    public double getCaloric() {
        return caloric;
    }

    public void setCaloric(double caloric) {
        this.caloric = caloric;
    }

//    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.EAGER)
//    public Set<Dish> getDishes() {
//        return dishes;
//    }
//
//    public void setDishes(Set<Dish> dishes) {
//        this.dishes = dishes;
//    }
//
//    public void addDish(Dish dish){
//        this.dishes.add(dish);
//    }
//
//    public void removeDish(Dish dish){
//        this.dishes.remove(dish);
//    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredient", fetch = FetchType.EAGER)
    public Set<DI> getDis() {
        return dis;
    }

    public void setDis(Set<DI> dis) {
        this.dis = dis;
    }

    public void addDi(DI di){
        this.dis.add(di);
    }

    public void removeDi(DI di){
        this.dis.remove(di);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (id != that.id) return false;
        if (Double.compare(that.caloric, caloric) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(caloric);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
