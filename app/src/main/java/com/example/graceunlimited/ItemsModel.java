package com.example.graceunlimited;

import java.io.Serializable;

public class ItemsModel implements Serializable {
    private String name;
    private String desc;

    public ItemsModel(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

