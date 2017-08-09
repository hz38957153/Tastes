package com.tt.taste.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.tt.taste.R;
import com.tt.taste.view.fragment.Fragment_friends;
import com.tt.taste.view.fragment.Fragment_home;
import com.tt.taste.view.fragment.Fragment_mine;
import com.tt.taste.view.fragment.Fragment_recommend;
import com.tt.taste.view.fragment.Fragment_shopping_cart;

public class MainssActivity extends AppCompatActivity {

    private FragmentTransaction mFragmentTransaction;
    private FragmentManager mFragmentManager;
    private Fragment_home mFragmentHome;
    private Fragment_recommend mFragmentRecommend;
    private Fragment_friends mFragmentFriends;
    private Fragment_shopping_cart mFragmentShoppingCart;
    private Fragment_mine mFragmentMine;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showFragment(0);
                    return true;
                case R.id.navigation_recommend:
                    showFragment(1);
                    return true;
                case R.id.navigation_friends:
                    showFragment(2);
                    return true;
                case R.id.navigation_shopping_car:
                    showFragment(3);
                    return true;
                case R.id.navigation_mine:
                    showFragment(4);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mFragmentManager = getSupportFragmentManager();
        showFragment(0);
    }


    private void showFragment(int index){
        mFragmentTransaction = mFragmentManager.beginTransaction();
        hideFragment(mFragmentTransaction);
        switch (index){
            case 0:
                if(mFragmentHome==null){
                    mFragmentHome = new Fragment_home();
                    mFragmentTransaction.add(R.id.content,mFragmentHome);
                }
                else{
                    mFragmentTransaction.show(mFragmentHome);
                }
                break;
            case 1:
                if(mFragmentRecommend==null){
                    mFragmentRecommend = new Fragment_recommend();
                    mFragmentTransaction.add(R.id.content,mFragmentRecommend);
                }else{
                    mFragmentTransaction.show(mFragmentRecommend);
                }
                break;
            case 2:
                if(mFragmentFriends==null){
                    mFragmentFriends = new Fragment_friends();
                    mFragmentTransaction.add(R.id.content,mFragmentFriends);
                }else{
                    mFragmentTransaction.show(mFragmentFriends);
                }
                break;
            case 3:
                if(mFragmentShoppingCart==null){
                    mFragmentShoppingCart = new Fragment_shopping_cart();
                    mFragmentTransaction.add(R.id.content,mFragmentShoppingCart);
                }else{
                    mFragmentTransaction.show(mFragmentShoppingCart);
                }
                break;
            case 4:
                if(mFragmentMine==null){
                    mFragmentMine = new Fragment_mine();
                    mFragmentTransaction.add(R.id.content,mFragmentMine);
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

}
