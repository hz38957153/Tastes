package com.tt.taste.onclicklistener;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by hz on 2017/8/10.
 */

public class RecommendViewPagerOnClickListener implements View.OnClickListener {

    private int position;
    private ViewPager pager;

    public RecommendViewPagerOnClickListener(int position, ViewPager pager) {
        this.position = position;
        this.pager = pager;
    }

    @Override
    public void onClick(View v) {
        pager.setCurrentItem(position);
    }
}
