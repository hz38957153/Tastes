package com.tt.taste.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.tt.taste.R;

/**
 * Created by hz on 2017/8/8.
 */

public class MainActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    private void shouFragment(int inidex){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home:
                break;
            case R.id.recommend:
                break;
            case R.id.friends:
                break;
            case R.id.shoppingCart:
                break;
            case R.id.mine:
                break;

        }
    }
}
