package com.demo.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.R;
import com.demo.bean.InnerBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by 梁遂 on 2018/7/2.
 */

public class InnerHolder extends BaseViewHolder<InnerBean> {

    private TextView textView;
    public InnerHolder(ViewGroup itemView) {
        this(itemView, R.layout.item_inner);
    }

    public InnerHolder(ViewGroup parent, int res) {
        super(parent, res);
        textView = $(R.id.text_title);
    }

    @Override
    public void setData(InnerBean data) {
        super.setData(data);
        textView.setText(data.getTitle());
    }
}
