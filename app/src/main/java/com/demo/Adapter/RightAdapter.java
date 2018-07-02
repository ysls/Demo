package com.demo.Adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.demo.bean.RightBean;
import com.demo.viewholder.RightHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

/**
 * Created by 梁遂 on 2018/7/2.
 */

public class RightAdapter extends RecyclerArrayAdapter<RightBean> {

    public RightAdapter(Context context) {
        super(context);
    }

    public RightAdapter(Context context, RightBean[] objects) {
        super(context, objects);
    }

    public RightAdapter(Context context, List<RightBean> objects) {
        super(context, objects);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new RightHolder(parent);
    }
}
