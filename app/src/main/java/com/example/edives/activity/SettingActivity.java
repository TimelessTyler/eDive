package com.example.edives.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.edives.MainActivity;
import com.example.edives.R;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.PersonModel;
import com.example.edives.utils.DataCleanManager;
import com.example.edives.utils.NormalConfig;
import com.example.edives.utils.SharedPrefrenceUtils;
import com.example.edives.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends BaseMvpActivity<PersonModel> {

    @BindView(R.id.iv_gmm)
    ImageView mIvGmm;
    @BindView(R.id.tv_ChangePassword)
    TextView mTvChangePassword;
    @BindView(R.id.rl_setting_password)
    RelativeLayout mRlSettingPassword;
    @BindView(R.id.iv_gzfmm)
    ImageView mIvGzfmm;
    @BindView(R.id.tv_settingpayPassword)
    TextView mTvSettingpayPassword;
    @BindView(R.id.rl_setting_pay_password)
    RelativeLayout mRlSettingPayPassword;
    @BindView(R.id.iv_fk)
    ImageView mIvFk;
    @BindView(R.id.tv_Feedback)
    TextView mTvFeedback;
    @BindView(R.id.rl_Feedback)
    RelativeLayout mRlFeedback;
    @BindView(R.id.iv_us)
    ImageView mIvUs;
    @BindView(R.id.tv_AboutUs)
    TextView mTvAboutUs;
    @BindView(R.id.rl_aboutwe)
    RelativeLayout mRlAboutwe;
    @BindView(R.id.iv_clean)
    ImageView mIvClean;
    @BindView(R.id.tv_clean)
    TextView mTvClean;
    @BindView(R.id.tv_huancun)
    TextView mTvHuancun;
    @BindView(R.id.rl_Close)
    RelativeLayout mRlClose;
    @BindView(R.id.iv_update)
    ImageView mIvUpdate;
    @BindView(R.id.tv_update)
    TextView mTvUpdate;
    @BindView(R.id.rl_update)
    RelativeLayout mRlUpdate;
    @BindView(R.id.bt_ded)
    Button mBtDed;

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
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public PersonModel getModel() {
        return new PersonModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @OnClick({R.id.rl_setting_password, R.id.rl_setting_pay_password, R.id.rl_Feedback, R.id.rl_aboutwe, R.id.rl_Close, R.id.rl_update, R.id.bt_ded})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rl_setting_password:
                //修改密码
                break;
            case R.id.rl_setting_pay_password:
                //修改支付密码
                break;
            case R.id.rl_Feedback:
                //意见反馈
                break;
            case R.id.rl_aboutwe:
                //关于我们
                break;
            case R.id.rl_Close:
                //清除 缓存
                try {
                    String totalCacheSizes = DataCleanManager.getTotalCacheSize(SettingActivity.this);
                    if (totalCacheSizes.equals("0K")) {
                        ToastUtil.showLong("不需要清除缓存");
                    }else {
                        DataCleanManager.clearAllCache(SettingActivity.this);
                        ToastUtil.showLong("清除缓存成功");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    String totalCacheSize = DataCleanManager.getTotalCacheSize(SettingActivity.this);
                                    mTvHuancun.setText(totalCacheSize);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 200);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.rl_update:
                //检查更新
                break;
            case R.id.bt_ded:
                //注销
                SharedPrefrenceUtils.saveString(SettingActivity.this, NormalConfig.PHONE,"");
                SharedPrefrenceUtils.saveString(SettingActivity.this, NormalConfig.USER_PHOTO,"");
                SharedPrefrenceUtils.saveString(SettingActivity.this, NormalConfig.ICON,"");
                SharedPrefrenceUtils.saveString(SettingActivity.this, NormalConfig.NICKNAME,"");
                SharedPrefrenceUtils.saveString(SettingActivity.this, NormalConfig.TOKEN,"");
                startActivity(new Intent(SettingActivity.this, MainActivity.class));
                finish();
                break;
        }
    }
}
