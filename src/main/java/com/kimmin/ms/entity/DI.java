package com.kimmin.ms.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by t-mijin on 8/1/2016.
 */

@Table
@Entity
public class DI implements Serializable {

    private Dish dish;
    private Ingredient ingredient;
    private double percentage;

    @EmbeddedId
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "did", nullable = false)
    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @EmbeddedId
    @ManyToOne
    @JoinColumn(name = "iid", nullable = false)
    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Column(nullable = false)
    @Basic
    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DI di = (DI) o;

        if (Double.compare(di.percentage, percentage) != 0) return false;
        if (dish != null ? !dish.equals(di.dish) : di.dish != null) return false;
        return ingredient != null ? ingredient.equals(di.ingredient) : di.ingredient == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = dish != null ? dish.hashCode() : 0;
        result = 31 * result + (ingredient != null ? ingredient.hashCode() : 0);
        temp = Double.doubleToLongBits(percentage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
