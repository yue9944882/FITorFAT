package com.kimmin.ms.dao;

import java.io.Serializable;
import java.util.List;

public interface GeneralDAO<T> {
    T queryById(String id);
    T queryById(int id);
    List<T> queryAll();
    void insert(T t);
    void delete(T t);
    void update(T t);
    void deleteById(String id);
    void deleteById(int id);
    Serializable insertAuto(T t);
}
