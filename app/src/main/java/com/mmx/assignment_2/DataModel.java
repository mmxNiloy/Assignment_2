package com.mmx.assignment_2;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class DataModel {
    private String name;
    private String id;

    public DataModel() {
        name = "";
        id = "";
    }

    public DataModel(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
