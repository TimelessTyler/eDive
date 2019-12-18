package com.example.edive.frame;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseMvpFragment<M> extends BaseFragment implements ICommonView {
    private Unbinder mBind;
    public CommonPresenter mPresenter;
    public M mModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View inflate = inflater.inflate(getLayoutId(), null);
        mBind = ButterKnife.bind(this, inflate);
        initView();
        mPresenter = getPresenter();
        mModel = getModel();
        if (mPresenter != null && mModel != null) mPresenter.attach(this, (ICommonModel) mModel);
        initData();
        return inflate;
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();

    public CommonPresenter getPresenter(){
        return new CommonPresenter();
    }

    public abstract M getModel();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBind.unbind();
        mPresenter.detach();
    }

    protected int getLoadType(Object[] t){
        return  t != null && t.length>1 ? (int) t[1] : 0;
    }
}
