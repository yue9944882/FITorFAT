package com.kimmin.ms.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * Created by t-mijin on 8/1/2016.
 */

@Table
@Entity
public class DI {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int did;
    private int iid;
    private double percentage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DI di = (DI) o;

        if (id != di.id) return false;
        if (did != di.did) return false;
        if (iid != di.iid) return false;
        return Double.compare(di.percentage, percentage) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + did;
        result = 31 * result + iid;
        temp = Double.doubleToLongBits(percentage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
