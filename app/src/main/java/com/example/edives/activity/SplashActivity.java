package com.example.edives.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.RelativeLayout;

import com.example.edives.MainActivity;
import com.example.edives.R;
import com.example.edives.frame.BaseActivity;
import com.example.edives.utils.NormalConfig;
import com.example.edives.utils.SharedPrefrenceUtils;
import com.example.edives.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.rl)
    RelativeLayout mRl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
//        makeStatusBarTransparent(SplashActivity.this);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        setAnimation();
    }

    protected void setStatusBar() {
        //这里做了两件事情，1.使状态栏透明并使contentView填充到状态栏 2.预留出状态栏的位置，防止界面上的控件离顶部靠的太近。这样就可以实现开头说的第二种情况的沉浸式状态栏了
        StatusBarUtil.setTranslucentStatus(this);
    }

    private void setAnimation() {
        AlphaAnimation mAa = new AlphaAnimation((float) 0.5, 1);
        mAa.setDuration(2000);
        mAa.setFillAfter(true);
        AnimationSet mAs = new AnimationSet(true);
        mAs.addAnimation(mAa);
        mRl.startAnimation(mAs);
        mAs.setAnimationListener(mAnimationListener);
    }
    private Animation.AnimationListener mAnimationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

            String token = SharedPrefrenceUtils.getString(SplashActivity.this, NormalConfig.TOKEN,"");
            mApplication.Token = token;
            String userid = SharedPrefrenceUtils.getString(SplashActivity.this, NormalConfig.USER_PHOTO, "");
            mApplication.userid = userid;
            String icon = SharedPrefrenceUtils.getString(SplashActivity.this, NormalConfig.ICON, "");
            mApplication.icon = icon;
            String nickname = SharedPrefrenceUtils.getString(SplashActivity.this, NormalConfig.NICKNAME, "");
            mApplication.nickname = nickname;
            String phone = SharedPrefrenceUtils.getString(SplashActivity.this, NormalConfig.PHONE, "");
            mApplication.Phone = phone;
            String personmmal = SharedPrefrenceUtils.getString(SplashActivity.this, NormalConfig.PERSONALIZED, "");
            mApplication.Personalizedsignature = personmmal;
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
//            if (mApplication.Token.isEmpty()) {
//                startActivity(new Intent(SplashActivity.this, MainActivity.class));
//                finish();
//            }else {
                startActivity(new Intent(SplashActivity.this,HomeActivity.class));
                finish();
//            }
        }
    };

    public static void makeStatusBarTransparent(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int option = window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            window.getDecorView().setSystemUiVisibility(option);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
