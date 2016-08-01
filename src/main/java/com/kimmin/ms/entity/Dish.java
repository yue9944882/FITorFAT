package com.kimmin.ms.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by t-mijin on 8/1/2016.
 */

@Entity
@Table
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int weight;
    private int like;
    private int dislike;
    private int location;

}
