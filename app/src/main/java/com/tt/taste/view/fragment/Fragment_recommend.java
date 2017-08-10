package com.tt.taste.view.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.tt.taste.Adapters.RecommendPagerAdapter;
import com.tt.taste.Listener.RecommendViewPagerListener;
import com.tt.taste.R;
import com.tt.taste.onclicklistener.RecommendViewPagerOnClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hz on 2017/8/9.
 */

public class Fragment_recommend extends Fragment {

    private ViewPager pager;
    private RadioButton rdNew, rdHot, rdCook, rdWine, rdCoffee, rdGoods;
    private LinearLayout llNew,llHot,llCook,llWine,llCoffee,llGoods;
    private List<LinearLayout> pagers;
    private List<RadioButton> radioButtons;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recommend,container,false);
        initView();
        initPager();
        return view;
    }

    private void initView(){
        pager = (ViewPager) view.findViewById(R.id.recommend_pager);
        rdNew = (RadioButton) view.findViewById(R.id.rdNew);
        rdHot = (RadioButton) view.findViewById(R.id.rdHot);
        rdCook = (RadioButton) view.findViewById(R.id.rdCook);
        rdWine = (RadioButton) view.findViewById(R.id.rdWine);
        rdCoffee = (RadioButton) view.findViewById(R.id.rdCoffee);
        rdGoods = (RadioButton) view.findViewById(R.id.rdGoods);

    }

    private void initPager(){
        LayoutInflater inflater =getActivity().getLayoutInflater();
        llNew = (LinearLayout) inflater.inflate(R.layout.recommend_viewpager_new,null);
        llHot = (LinearLayout) inflater.inflate(R.layout.recommend_viewpager_hot,null);
        llCook = (LinearLayout) inflater.inflate(R.layout.recommend_viewpager_cook,null);
        llWine = (LinearLayout) inflater.inflate(R.layout.recommend_viewpager_wine,null);
        llCoffee = (LinearLayout) inflater.inflate(R.layout.recommend_viewpager_coffee,null);
        llGoods = (LinearLayout) inflater.inflate(R.layout.recommend_viewpager_goods,null);
        pagers = new ArrayList<LinearLayout>();
        radioButtons = new ArrayList<RadioButton>();
        pagers.add(llNew);
        pagers.add(llHot);
        pagers.add(llCook);
        pagers.add(llWine);
        pagers.add(llCoffee);
        pagers.add(llGoods);
        radioButtons.add(rdNew);
        radioButtons.add(rdHot);
        radioButtons.add(rdCook);
        radioButtons.add(rdWine);
        radioButtons.add(rdCoffee);
        radioButtons.add(rdGoods);
        pager.setCurrentItem(0);
        pager.setOnPageChangeListener(new RecommendViewPagerListener(radioButtons));
        RecommendPagerAdapter adapter = new RecommendPagerAdapter(pagers);
        pager.setAdapter(adapter);
        setRecommendPagerCurrentItem();

    }

    /**
     * radioButton点击事件
     */
    private void setRecommendPagerCurrentItem(){
        rdNew.setOnClickListener(new RecommendViewPagerOnClickListener(0,pager));
        rdHot.setOnClickListener(new RecommendViewPagerOnClickListener(1,pager));
        rdCook.setOnClickListener(new RecommendViewPagerOnClickListener(2,pager));
        rdWine.setOnClickListener(new RecommendViewPagerOnClickListener(3,pager));
        rdCoffee.setOnClickListener(new RecommendViewPagerOnClickListener(4,pager));
        rdGoods.setOnClickListener(new RecommendViewPagerOnClickListener(5,pager));

    }
}
