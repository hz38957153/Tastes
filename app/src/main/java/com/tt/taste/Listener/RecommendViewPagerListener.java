package com.tt.taste.Listener;

import android.support.v4.view.ViewPager;
import android.widget.RadioButton;

import java.util.List;

/**
 * Created by hz on 2017/8/10.
 */

public class RecommendViewPagerListener implements ViewPager.OnPageChangeListener {

    private List<RadioButton> radios;
    private int _arg2 = 0;
    private int _arg0 = 0;

    public RecommendViewPagerListener(List<RadioButton> radios){
        this.radios = radios;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        radios.get(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
