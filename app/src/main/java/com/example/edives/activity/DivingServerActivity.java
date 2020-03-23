package com.example.edives.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.edives.R;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.HomeModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DivingServerActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.iv_show)
    ImageView mIvShow;
    @BindView(R.id.rl_photo_server)
    RelativeLayout mRlPhotoServer;
    @BindView(R.id.iv_shows)
    ImageView mIvShows;
    @BindView(R.id.rl_photo_rent)
    RelativeLayout mRlPhotoRent;
    @BindView(R.id.iv_s)
    ImageView mIvS;

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
        return R.layout.activity_diving_server;
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

    @OnClick({R.id.rl_photo_server, R.id.rl_photo_rent})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
                //拍照服务
            case R.id.rl_photo_server:
                startActivity(new Intent(DivingServerActivity.this,PhotoServerActivity.class));
                break;
                //相机租赁
            case R.id.rl_photo_rent:
                startActivity(new Intent(DivingServerActivity.this,PhotoRentActivity.class));
                break;
        }
    }
}
