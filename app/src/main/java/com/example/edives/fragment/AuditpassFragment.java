package com.example.edives.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edives.R;
import com.example.edives.frame.BaseMvpFragment;
import com.example.edives.model.ShoppingModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AuditpassFragment extends BaseMvpFragment<ShoppingModel> {


    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.sm)
    SmartRefreshLayout mSm;

    public AuditpassFragment() {
        // Required empty public constructor
    }



    @Override
    public int getLayoutId() {
        return R.layout.fragment_auditpass;
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
