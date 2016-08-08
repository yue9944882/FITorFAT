package com.kimmin.ms.entity;

import javax.persistence.*;

/**
 * Created by t-mijin on 8/1/2016.
 */


@Deprecated
public class MD {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int mid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MD md = (MD) o;

        if (id != md.id) return false;
        if (mid != md.mid) return false;
        return did == md.did;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + mid;
        result = 31 * result + did;
        return result;
    }

    private int did;

}
