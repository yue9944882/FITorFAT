package com.kimmin.ms.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by t-mijin on 8/1/2016.
 */

@Entity
@Table
public class Follow implements Serializable {

    private User user1;
    private User user2;

    @EmbeddedId
    @JoinColumn(name = "user1", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false, targetEntity = User.class)
    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    @EmbeddedId
    @JoinColumn(name = "user2", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false, targetEntity = User.class)
    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

}
