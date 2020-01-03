package com.example.edives.activity;

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

import com.example.edives.MainActivity;
import com.example.edives.R;
import com.example.edives.bean.VerificationBean;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.frame.MyServer;
import com.example.edives.model.LoginModel;
import com.example.edives.utils.AppValidationMgr;
import com.example.edives.utils.CountDownTimerUtils;

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

public class VerificationLoginActivity extends BaseMvpActivity<LoginModel> {

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
    @BindView(R.id.et_VerificationCode)
    EditText mEtVerificationCode;
    @BindView(R.id.tv_getVerificationCode)
    TextView mTvGetVerificationCode;
    @BindView(R.id.lltwo)
    LinearLayout mLltwo;
    @BindView(R.id.iv_Login)
    ImageView mIvLogin;
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
    private CountDownTimerUtils downTimerUtils;


    @Override
    public int getLayoutId() {
        return R.layout.activity_verification_login;
    }

    @Override
    public void initView() {
        setTextViewStyles(mTvVerificationCodeLogin);
        setTextViewStyles(mTvGetVerificationCode);
        makeStatusBarTransparent(VerificationLoginActivity.this);

        //倒计时工具类
        downTimerUtils = new CountDownTimerUtils(mTvGetVerificationCode, 60000, 1000);
    }

    @Override
    public void initData() {

    }

    @Override
    public LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @OnClick({R.id.tv_uanmeloginString, R.id.tv_VerificationCodeLogin, R.id.tv_getVerificationCode, R.id.iv_Login, R.id.tv_Registered, R.id.tv_ForgetPassword, R.id.tv_QuickLogin, R.id.iv_wechatLogin})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
                //账号密码登录
            case R.id.tv_uanmeloginString:
                startActivity(new Intent(VerificationLoginActivity.this, MainActivity.class));
                finish();
                break;
                //
            case R.id.tv_VerificationCodeLogin:
                break;
                //获取验证码
            case R.id.tv_getVerificationCode:
                initgetcode();
                break;
                //登录
            case R.id.iv_Login:
                initLogin();
                break;
                //注册
            case R.id.tv_Registered:
                startActivity(new Intent(VerificationLoginActivity.this, RegisterActivity.class));
                break;
                //忘记密码
            case R.id.tv_ForgetPassword:
                startActivity(new Intent(VerificationLoginActivity.this, FindPasswordActivity.class));
                break;
            case R.id.tv_QuickLogin:
                break;
                //微信
            case R.id.iv_wechatLogin:

                break;
        }
    }

    private void initLogin() {
        String uname = mEtUname.getText().toString();
        String code = mEtVerificationCode.getText().toString();
        if (!TextUtils.isEmpty(uname) && !TextUtils.isEmpty(code)) {
            if (AppValidationMgr.isPhone(uname) || AppValidationMgr.isEmail(uname)) {
                //登陆
                
            }else {
                showToast("请填写正确的手机号或邮箱");
            }
        }else {
            showToast("请填写手机号或邮箱获取验证码");
        }
    }

    private void initgetcode() {
        String username = mEtUname.getText().toString();
        if (!TextUtils.isEmpty(username)) {
            if (AppValidationMgr.isPhone(username) || AppValidationMgr.isEmail(username)) {
                downTimerUtils.start();
//                mPresenter.getData(ApiConfig.VER_GETCODE,urls);
                Retrofit build = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(MyServer.url)
                        .build();
                MyServer myServer = build.create(MyServer.class);
                Observable<VerificationBean> verGetcode = myServer.getVerGetcode(username);
                verGetcode.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<VerificationBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(VerificationBean bean) {
                                String data = bean.getData();
                                mEtVerificationCode.setText(data);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }else {
                showToast("请填写正确的手机号或邮箱");
            }
        }else {
            showToast("请填写手机号或邮箱");
        }
    }

    private void setTextViewStyles(TextView textView) {
        LinearGradient mLinearGradient = new LinearGradient(0, 0, textView.getPaint().getTextSize() * textView.getText().length(), 0, Color.parseColor("#FF076BF0"), Color.parseColor("#FF35A6FF"), Shader.TileMode.CLAMP);
        textView.getPaint().setShader(mLinearGradient);
        textView.invalidate();
    }
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
}
