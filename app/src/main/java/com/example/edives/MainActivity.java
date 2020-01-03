package com.example.edives;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.edives.activity.FindPasswordActivity;
import com.example.edives.activity.HomeActivity;
import com.example.edives.activity.RegisterActivity;
import com.example.edives.activity.VerificationLoginActivity;
import com.example.edives.bean.LoginBean;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.frame.MyServer;
import com.example.edives.model.HomeModel;
import com.example.edives.utils.AppValidationMgr;
import com.example.edives.utils.NormalConfig;
import com.example.edives.utils.SharedPrefrenceUtils;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.tv_loginString)
    TextView mTvLoginString;
    @BindView(R.id.tv_uanmeloginString)
    TextView mTvUanmeloginString;
    @BindView(R.id.iv_line)
    ImageView mIvLine;
    @BindView(R.id.tv_VerificationCodeLogin)
    TextView mTvVerificationCodeLogin;
    @BindView(R.id.et_uname)
    EditText mEtUname;
    @BindView(R.id.ll)
    LinearLayout mLl;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.lltwo)
    LinearLayout mLltwo;
    @BindView(R.id.iv_unameandpasswordLogin)
    ImageView mIvUnameandpasswordLogin;
    @BindView(R.id.rlone)
    RelativeLayout mRlone;
    @BindView(R.id.tv_Registered)
    TextView mTvRegistered;
    @BindView(R.id.tv_ForgetPassword)
    TextView mTvForgetPassword;
    @BindView(R.id.llthree)
    LinearLayout mLlthree;
    @BindView(R.id.tv_QuickLogin)
    TextView mTvQuickLogin;
    @BindView(R.id.rl)
    RelativeLayout mRl;
    @BindView(R.id.iv_wechatLogin)
    ImageView mIvWechatLogin;
    private String type = "password";
    private String loginType = "coach";


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        makeStatusBarTransparent(MainActivity.this);
        setTextViewStyles(mTvUanmeloginString);
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


    @OnClick({R.id.tv_uanmeloginString, R.id.tv_VerificationCodeLogin, R.id.iv_unameandpasswordLogin, R.id.tv_Registered, R.id.tv_ForgetPassword, R.id.tv_QuickLogin, R.id.iv_wechatLogin})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_uanmeloginString:

                break;
            case R.id.tv_VerificationCodeLogin:
                //验证码登录
                startActivity(new Intent(MainActivity.this, VerificationLoginActivity.class));
                finish();
                break;
            case R.id.iv_unameandpasswordLogin:
                //登录
                initLogin();
                break;
            case R.id.tv_Registered:
                //注册
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                break;
            case R.id.tv_ForgetPassword:
                //找回密码
                startActivity(new Intent(MainActivity.this, FindPasswordActivity.class));
                break;
            case R.id.tv_QuickLogin:

                break;
            case R.id.iv_wechatLogin:
                //微信

                break;
        }
    }

    private void initLogin() {
        String phone = mEtUname.getText().toString();
        String password = mEtPassword.getText().toString();
        if (!TextUtils.isEmpty(phone) && !TextUtils.isEmpty(password)) {
            if (AppValidationMgr.isPhone(phone) || AppValidationMgr.isEmail(phone)) {
                Retrofit build = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(MyServer.url)
                        .build();
                MyServer myServer = build.create(MyServer.class);
                Observable<LoginBean> login = myServer.getPasswordLogin(type, phone, password,loginType);
                login.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<LoginBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(LoginBean bean) {
                                if (bean.getCode() == 200) {
                                    int id = bean.getData().getAdditionalInformation().getId();
                                    showLongToast(bean.getMessage());
                                    mApplication.Phone = bean.getData().getAdditionalInformation().getUsername();
                                    mApplication.Token = bean.getData().getValue();
                                    mApplication.userid = String.valueOf(id);
                                    mApplication.nickname = bean.getData().getAdditionalInformation().getNickName();
                                    mApplication.icon = bean.getData().getAdditionalInformation().getIcon();
//                                    mApplication.Personalizedsignature = bean.getData().getAdditionalInformation().getPersonalizedSignature();
//                                    SharedPrefrenceUtils.saveString(MainActivity.this, NormalConfig.PERSONALIZED,bean.getData().getAdditionalInformation().getPersonalizedSignature());
                                    SharedPrefrenceUtils.saveString(MainActivity.this, NormalConfig.TOKEN,bean.getData().getValue());
                                    SharedPrefrenceUtils.saveString(MainActivity.this, NormalConfig.PHONE,bean.getData().getAdditionalInformation().getUsername());
                                    SharedPrefrenceUtils.saveString(MainActivity.this, NormalConfig.USER_PHOTO,String.valueOf(id));
                                    SharedPrefrenceUtils.saveString(MainActivity.this, NormalConfig.NICKNAME,bean.getData().getAdditionalInformation().getNickName());
                                    SharedPrefrenceUtils.saveString(MainActivity.this, NormalConfig.ICON,bean.getData().getAdditionalInformation().getIcon());
                                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                                    finish();
                                }else {
                                    showToast(bean.getMessage());
                                }

                            }

                            @Override
                            public void onError(Throwable e) {
                                showLog(e.getMessage());
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }else {
                showToast("请输入正确的手机号或邮箱");
            }
        }else {
            showToast("手机号或密码不能为空");
        }
    }

    //沉浸式状态栏
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

    private void setTextViewStyles(TextView textView) {
        LinearGradient mLinearGradient = new LinearGradient(0, 0, textView.getPaint().getTextSize() * textView.getText().length(), 0, Color.parseColor("#FF076BF0"), Color.parseColor("#FF35A6FF"), Shader.TileMode.CLAMP);
        textView.getPaint().setShader(mLinearGradient);
        textView.invalidate();
    }
}
