package com.example.edives.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.edives.R;
import com.example.edives.design.CommonTitle;
import com.example.edives.frame.BaseMvpFragment;
import com.example.edives.model.ShoppingModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends BaseMvpFragment<ShoppingModel> {


    @BindView(R.id.tit)
    CommonTitle mTit;


    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_shopping;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {

    }

    @Override
    public ShoppingModel getModel() {
        return new ShoppingModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

}
