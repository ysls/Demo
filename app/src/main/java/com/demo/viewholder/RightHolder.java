package com.demo.viewholder;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.R;
import com.demo.bean.InnerBean;
import com.demo.bean.RightBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 梁遂 on 2018/7/2.
 */

public class RightHolder extends BaseViewHolder<RightBean>{
    private TextView textView;
    private RecyclerView recyclerInner;
    private RecyclerArrayAdapter<InnerBean> arrayAdapter;
    public RightHolder(ViewGroup itemView) {
        this(itemView, R.layout.item_right);
    }

    public RightHolder(ViewGroup parent, int res) {
        super(parent, res);
        textView = $(R.id.text_title);
        recyclerInner = $(R.id.recycler_inner);
        arrayAdapter = new RecyclerArrayAdapter<InnerBean>(getContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new InnerHolder(parent);
            }
        };
    }

    @Override
    public void setData(RightBean data) {
        super.setData(data);
        textView.setText(data.getTitle());
        recyclerInner.setLayoutManager(new GridLayoutManager(getContext(),3));
        arrayAdapter.addAll(data.getInnerBeans());
        recyclerInner.setAdapter(arrayAdapter);
    }
}
