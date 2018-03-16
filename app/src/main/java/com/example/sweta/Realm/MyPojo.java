package com.example.sweta.Realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by sweta on 3/16/18.
 */

public class MyPojo extends RealmObject {

    @PrimaryKey
    private Integer id;

    private String name;

    private Integer roll;

    public MyPojo(Integer id, String name, Integer roll) {
        this.id = id;
        this.name = name;
        this.roll = roll;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }
}
