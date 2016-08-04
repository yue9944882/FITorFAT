package com.kimmin.ms.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by t-mijin on 8/1/2016.
 */

@Entity
@Table
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    private int like;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (id != menu.id) return false;
        if (like != menu.like) return false;
        if (dislike != menu.dislike) return false;
        return date != null ? date.equals(menu.date) : menu.date == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + like;
        result = 31 * result + dislike;
        return result;
    }

    private int dislike;
}
