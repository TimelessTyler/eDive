package com.example.edives.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.edives.R;
import com.example.edives.design.CommonTitle;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.HomeModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DivingTripActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.title)
    CommonTitle mTitle;
    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.bt_ok)
    Button mBtOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.app_setting));
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_diving_trip;
    }

    @Override
    public void initView() {
        //布局rec  item_tric
    }

    @Override
    public void initData() {

    }

    @Override
    public HomeModel getModel() {
        return new HomeModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @OnClick(R.id.bt_ok)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
                //发布新行程
            case R.id.bt_ok:

                break;
        }
    }
}
