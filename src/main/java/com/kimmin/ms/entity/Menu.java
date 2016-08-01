package com.kimmin.ms.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by t-mijin on 8/1/2016.
 */

@Entity
@Table
public class Menu {

    private int id;
    private Date date;
    private String dishId;
    private int like;
    private int dislike;

}
