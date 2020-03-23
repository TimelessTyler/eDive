package com.example.edives.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.edives.R;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.HomeModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhotoRentActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.ll)
    LinearLayout mLl;
    @BindView(R.id.rl_chose)
    RelativeLayout mRlChose;
    @BindView(R.id.ll_l)
    LinearLayout mLlL;
    @BindView(R.id.rl_chos)
    RelativeLayout mRlChos;
    @BindView(R.id.tv_text)
    TextView mTvText;
    @BindView(R.id.iv_show)
    ImageView mIvShow;
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
        return R.layout.activity_photo_rent;
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

    @OnClick({R.id.rl_chose, R.id.bt_ok})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rl_chose:
                break;
            case R.id.bt_ok:
                break;
        }
    }
}
