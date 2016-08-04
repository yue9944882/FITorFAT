package com.kimmin.ms.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by t-mijin on 8/1/2016.
 */

@Entity
@Table
public class Dish {


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (id != dish.id) return false;
        if (weight != dish.weight) return false;
        if (like != dish.like) return false;
        if (dislike != dish.dislike) return false;
        if (location != dish.location) return false;
        return name != null ? name.equals(dish.name) : dish.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + weight;
        result = 31 * result + like;
        result = 31 * result + dislike;
        result = 31 * result + location;
        return result;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Date createTime;
    private int weight;
    private int like;
    private int dislike;
    private int location;
    private int energy;
    private int type;

}
