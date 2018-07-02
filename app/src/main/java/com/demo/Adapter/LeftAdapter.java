package com.demo.Adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.demo.bean.LeftBean;
import com.demo.viewholder.LeftHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

/**
 * Created by 梁遂 on 2018/7/2.
 */

public class LeftAdapter extends RecyclerArrayAdapter<LeftBean> {

    private int prePosition = 0;

    public LeftAdapter(Context context) {
        super(context);
    }

    public LeftAdapter(Context context, LeftBean[] objects) {
        super(context, objects);
    }

    public LeftAdapter(Context context, List<LeftBean> objects) {
        super(context, objects);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new LeftHolder(parent);
    }

    public void setSelectedPosition(int position){
        if (prePosition != position){
            mRecyclerView.smoothScrollToPosition(position);
            mObjects.get(prePosition).setSelected(false);
            notifyItemChanged(prePosition);
            prePosition = position;
            mObjects.get(prePosition).setSelected(true);
            notifyItemChanged(position);
        }
    }

}
