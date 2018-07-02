package com.demo.bean;

/**
 * Created by 梁遂 on 2018/7/2.
 */

public class InnerBean {
    public InnerBean(String title) {
        Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    private String Title;
}
