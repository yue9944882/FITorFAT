package com.kimmin.ms.entity;

import javax.persistence.*;

/**
 * Created by t-mijin on 8/1/2016.
 */


public class Follow {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Follow follow = (Follow) o;

        if (id != follow.id) return false;
        if (id1 != follow.id1) return false;
        return id2 == follow.id2;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + id1;
        result = 31 * result + id2;
        return result;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id1", nullable = false)
    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    @Basic
    @Column(name = "id2", nullable = false)
    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    private int id;
    private int id1;
    private int id2;

}
