package com.demo.bean;

/**
 * Created by 梁遂 on 2018/7/2.
 */

public class LeftBean extends SelectedBean {
    public LeftBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
