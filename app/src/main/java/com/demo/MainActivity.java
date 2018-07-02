package com.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.demo.Adapter.LeftAdapter;
import com.demo.Adapter.RightAdapter;
import com.demo.bean.InnerBean;
import com.demo.bean.LeftBean;
import com.demo.bean.RightBean;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerLeft,recyclerRight;
    private LeftAdapter leftAdapter;
    private RightAdapter rightAdapter;
    //判断是点击还是滑动，
    private boolean clicked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerLeft = findViewById(R.id.recycler_left);
        recyclerRight = findViewById(R.id.recycler_right);
        initData();
        initRecylerView();
    }

    private void initData() {
        if (null == leftAdapter){
            ArrayList<LeftBean> leftBeans = new ArrayList<>();
            for (int i = 0; i < 5; i++){
                leftBeans.add(new LeftBean("我是左边第"+ i + "个"));
                //默认第一个为选中状态
                if (i == 0){
                    leftBeans.get(0).setSelected(true);
                }
            }
            leftAdapter = new LeftAdapter(this,leftBeans);
        }

        if (null == rightAdapter){
            ArrayList<RightBean> rightBeans = new ArrayList<>();
            for (int i = 0; i < 5; i++){
                ArrayList<InnerBean> innerBeans = new ArrayList<>();
                for (int j = 0; j < 5; j++){
                    innerBeans.add(new InnerBean("我是里边第"+ j + "个"));
                }
                rightBeans.add(new RightBean("我是右边第"+ i + "个",innerBeans));
            }
            rightAdapter = new RightAdapter(this,rightBeans);
        }
    }

    private void initRecylerView() {
        recyclerLeft.setLayoutManager(new LinearLayoutManager(this));
        recyclerLeft.setAdapter(leftAdapter);
        leftAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                recyclerRight.smoothScrollToPosition(position);
                leftAdapter.setSelectedPosition(position);
                clicked = true;
            }
        });
        //设置能够平滑到顶部的LayouManager
        recyclerRight.setLayoutManager(new ScrollTopLayoutManager(this));
        recyclerRight.setAdapter(rightAdapter);
        recyclerRight.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (clicked && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    clicked = false;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!clicked) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    int currentItem = linearLayoutManager.findFirstVisibleItemPosition();
                    linearLayoutManager.getChildAt(currentItem);
                    View v = linearLayoutManager.findViewByPosition(currentItem);
                    //右边滑动超过当前item一半时左边切换到下一个
                    if (v.getBottom() < v.getHeight() / 2 && currentItem >= 0) {
                        if (currentItem < linearLayoutManager.getItemCount() - 1){
                            leftAdapter.setSelectedPosition(currentItem + 1);
                        }
                    } else {
                        leftAdapter.setSelectedPosition(currentItem);
                    }
                }
            }
        });
    }
}
