package com.kimmin.ms.entity;

import javax.persistence.*;

/**
 * Created by t-mijin on 8/1/2016.
 */

@Entity
@Table
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    private int id;

    @Basic
    @Column(name = "id1", nullable = false)
    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    @Basic
    @Column(name = "id2", nullable = false)
    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    private String id1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Follow follow = (Follow) o;

        if (id != follow.id) return false;
        if (id1 != null ? !id1.equals(follow.id1) : follow.id1 != null) return false;
        return id2 != null ? id2.equals(follow.id2) : follow.id2 == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (id1 != null ? id1.hashCode() : 0);
        result = 31 * result + (id2 != null ? id2.hashCode() : 0);
        return result;
    }

    private String id2;

}
