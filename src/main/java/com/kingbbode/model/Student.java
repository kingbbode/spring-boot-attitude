package com.kingbbode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by YG-MAC on 2017. 3. 26..
 */
@Entity
public class Student {
    @Id
    private Long idx;

    @Column
    private String name;

    public Long getIdx() {
        return idx;
    }

    public String getName() {
        return name;
    }
}
