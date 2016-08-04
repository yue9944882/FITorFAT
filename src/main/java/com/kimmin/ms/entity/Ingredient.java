package com.kimmin.ms.entity;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

/**
 * Created by t-mijin on 8/1/2016.
 */

@Entity
@Table
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return caloric != null ? caloric.equals(that.caloric) : that.caloric == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (caloric != null ? caloric.hashCode() : 0);
        return result;
    }

    private String caloric;

}
