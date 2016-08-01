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
    private String caloric;

}
