package com.tt.taste.view.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.tt.taste.R;
import com.tt.taste.util.To;
import com.tt.taste.view.fragment.Fragment_friends;
import com.tt.taste.view.fragment.Fragment_home;
import com.tt.taste.view.fragment.Fragment_mine;
import com.tt.taste.view.fragment.Fragment_recommend;
import com.tt.taste.view.fragment.Fragment_shopping_cart;

/**
 * Created by hz on 2017/8/8.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentTransaction mFragmentTransaction;
    private FragmentManager mFragmentManager;
    private Fragment_home mFragmentHome;
    private Fragment_recommend mFragmentRecommend;
    private Fragment_friends mFragmentFriends;
    private Fragment_shopping_cart mFragmentShoppingCart;
    private Fragment_mine mFragmentMine;
    private Context mContext;
    private RadioButton home,recommend,friends,shopping,mine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mContext=this;

        mFragmentManager = getSupportFragmentManager();
        bindRadioButtonClicck();
        showFragment(0);
    }
    /**
     * 绑定radio按钮
     */
    private void bindRadioButtonClicck(){
        home = (RadioButton) findViewById(R.id.radioHome);
        recommend = (RadioButton) findViewById(R.id.radioRecommend);
        friends = (RadioButton) findViewById(R.id.friends);
        shopping = (RadioButton) findViewById(R.id.shoppingCart);
        mine = (RadioButton) findViewById(R.id.mine);
        home.setOnClickListener(this);
        recommend.setOnClickListener(this);
        friends.setOnClickListener(this);
        shopping.setOnClickListener(this);
        mine.setOnClickListener(this);
    }

    /**
     * 显示切换fragment
     * @param index
     */
    private void showFragment(int index){
        mFragmentTransaction = mFragmentManager.beginTransaction();
        hideFragment(mFragmentTransaction);
        switch (index){
            case 0:
                if(mFragmentHome==null){
                    mFragmentHome = new Fragment_home();
                    mFragmentTransaction.add(R.id.fragment,mFragmentHome);
                }
                else{
                    mFragmentTransaction.show(mFragmentHome);
                }
                break;
            case 1:
                if(mFragmentRecommend==null){
                    mFragmentRecommend = new Fragment_recommend();
                    mFragmentTransaction.add(R.id.fragment,mFragmentRecommend);
                }else{
                    mFragmentTransaction.show(mFragmentRecommend);
                }
                break;
            case 2:
                if(mFragmentFriends==null){
                    mFragmentFriends = new Fragment_friends();
                    mFragmentTransaction.add(R.id.fragment,mFragmentFriends);
                }else{
                    mFragmentTransaction.show(mFragmentFriends);
                }
                break;
            case 3:
                if(mFragmentShoppingCart==null){
                    mFragmentShoppingCart = new Fragment_shopping_cart();
                    mFragmentTransaction.add(R.id.fragment,mFragmentShoppingCart);
                }else{
                    mFragmentTransaction.show(mFragmentShoppingCart);
                }
                break;
            case 4:
                if(mFragmentMine==null){
                    mFragmentMine = new Fragment_mine();
                    mFragmentTransaction.add(R.id.fragment,mFragmentMine);
                }else{
                    mFragmentTransaction.show(mFragmentMine);
                }
                break;
        }
        mFragmentTransaction.commit();
    }

    private void hideFragment(FragmentTransaction fragmentTransaction){
        if(mFragmentHome!=null){
            fragmentTransaction.hide(mFragmentHome);
        }
        if(mFragmentRecommend!=null){
            fragmentTransaction.hide(mFragmentRecommend);
        }
        if(mFragmentFriends!=null){
            fragmentTransaction.hide(mFragmentFriends);
        }
        if(mFragmentShoppingCart!=null){
            fragmentTransaction.hide(mFragmentShoppingCart);
        }
        if(mFragmentMine!=null){
            fragmentTransaction.hide(mFragmentMine);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radioHome:
                showFragment(0);
                break;
            case R.id.radioRecommend:
                showFragment(1);
                break;
            case R.id.friends:
                showFragment(2);
                break;
            case R.id.shoppingCart:
                showFragment(3);
                break;
            case R.id.mine:
                showFragment(4);
                break;

        }
    }
}
