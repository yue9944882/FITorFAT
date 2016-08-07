package com.kimmin.ms.entity;

import javax.persistence.*;

/**
 * Created by t-mijin on 8/1/2016.
 */

@Entity
@Table
public class MU {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MU mu = (MU) o;

        if (id != mu.id) return false;
        if (mid != mu.mid) return false;
        return uid == mu.uid;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + mid;
        result = 31 * result + uid;
        return result;
    }

    private int mid;
    private int uid;
}
