package com.demo;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by 梁遂 on 2017/9/1.
 * 平滑到position顶部的manager
 */

public class ScrollTopLayoutManager extends LinearLayoutManager {

    public ScrollTopLayoutManager(Context context) {
        super(context);
    }

    public ScrollTopLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public ScrollTopLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        super.smoothScrollToPosition(recyclerView, state, position);
        TopLinearSmoothScroller topLinearSmoothScroller = new TopLinearSmoothScroller(recyclerView.getContext());
        topLinearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(topLinearSmoothScroller);
    }

    private static class TopLinearSmoothScroller extends LinearSmoothScroller {

        public TopLinearSmoothScroller(Context context) {
            super(context);
        }

        @Override
        protected int getVerticalSnapPreference() {
            return SNAP_TO_START;
        }
    }
}
