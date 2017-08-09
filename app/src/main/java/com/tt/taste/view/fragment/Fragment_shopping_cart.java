package com.tt.taste.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tt.taste.R;

/**
 * Created by hz on 2017/8/9.
 */

public class Fragment_shopping_cart extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shopping_cart,container,false);
        return view;
    }
}
