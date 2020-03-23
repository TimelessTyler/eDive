package com.example.edives.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.example.edives.R;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.HomeModel;
import com.lljjcoder.style.citypickerview.CityPickerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//订单发布
public class OrderissueActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.tl_research_order)
    RelativeLayout mTlResearchOrder;
    @BindView(R.id.rl_trip_order)
    RelativeLayout mRlTripOrder;
    @BindView(R.id.rl_server_order)
    RelativeLayout mRlServerOrder;

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
        return R.layout.activity_orderissue;
    }

    @Override
    public void initView() {

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

    @OnClick({R.id.tl_research_order, R.id.rl_trip_order, R.id.rl_server_order})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
                //考证订单
            case R.id.tl_research_order:
                startActivity(new Intent(OrderissueActivity.this,DivingResearchActivity.class));
                break;
                //行程订单
            case R.id.rl_trip_order:
                startActivity(new Intent(OrderissueActivity.this,DivingTripActivity.class));
                break;
                //服务订单
            case R.id.rl_server_order:
                startActivity(new Intent(OrderissueActivity.this,DivingServerActivity.class));
                break;
        }
    }
}
