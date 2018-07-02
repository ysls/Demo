package com.demo.bean;

import java.util.ArrayList;

/**
 * Created by 梁遂 on 2018/7/2.
 */

public class RightBean {
    public RightBean(String title, ArrayList<InnerBean> innerBeans) {
        this.title = title;
        this.innerBeans = innerBeans;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<InnerBean> getInnerBeans() {
        return innerBeans;
    }

    public void setInnerBeans(ArrayList<InnerBean> innerBeans) {
        this.innerBeans = innerBeans;
    }

    private ArrayList<InnerBean> innerBeans;
}
