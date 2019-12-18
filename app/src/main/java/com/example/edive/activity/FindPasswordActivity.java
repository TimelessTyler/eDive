package com.example.edive.activity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.edive.R;
import com.example.edive.bean.FindPasswordBean;
import com.example.edive.bean.VerificationBean;
import com.example.edive.design.CommonTitle;
import com.example.edive.frame.ApiConfig;
import com.example.edive.frame.BaseMvpActivity;
import com.example.edive.frame.MyServer;
import com.example.edive.model.LoginModel;
import com.example.edive.utils.AppValidationMgr;
import com.example.edive.utils.CountDownTimerUtils;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FindPasswordActivity extends BaseMvpActivity<LoginModel> {

    @BindView(R.id.findpass_toolbar)
    CommonTitle mFindpassToolbar;
    @BindView(R.id.findpass_ed_phone_emil)
    EditText mFindpassEdPhoneEmil;
    @BindView(R.id.findpass_ll_ed_phone_emil)
    LinearLayout mFindpassLlEdPhoneEmil;
    @BindView(R.id.findpass_getcode_iv)
    ImageView mFindpassGetcodeIv;
    @BindView(R.id.findpass_ed_code)
    EditText mFindpassEdCode;
    @BindView(R.id.findpass_btn_getcode)
    TextView mFindpassBtnGetcode;
    @BindView(R.id.findpass_ll_ed_code)
    RelativeLayout mFindpassLlEdCode;
    @BindView(R.id.findpass_ed_new_pass)
    EditText mFindpassEdNewPass;
    @BindView(R.id.findpass_ll_ed_new_pass)
    LinearLayout mFindpassLlEdNewPass;
    @BindView(R.id.findpass_queren_ed_new_pass)
    EditText mFindpassQuerenEdNewPass;
    @BindView(R.id.findpass_ll_queren_new_pass)
    LinearLayout mFindpassLlQuerenNewPass;
    @BindView(R.id.findpass_ok_btn)
    Button mFindpassOkBtn;
    private CountDownTimerUtils downTimerUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.findpassword_bg));
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_find_password;
    }

    @Override
    public void initView() {
        //倒计时工具类
        downTimerUtils = new CountDownTimerUtils(mFindpassBtnGetcode, 60000, 1000);
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
        switch (whichApi){
            case ApiConfig.FIND_PASSWORD:

                break;
        }
    }

    @OnClick({R.id.findpass_btn_getcode, R.id.findpass_ok_btn})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.findpass_btn_getcode:
                initgetcode();
                break;
            case R.id.findpass_ok_btn:
                initOk();
                break;
        }
    }

    private void initOk() {
        String uname = mFindpassEdPhoneEmil.getText().toString();
        String code = mFindpassEdCode.getText().toString();
        String password = mFindpassEdNewPass.getText().toString();
        String passwords = mFindpassQuerenEdNewPass.getText().toString();
        if (!TextUtils.isEmpty(uname) && !TextUtils.isEmpty(code)) {
            if (AppValidationMgr.isPhone(uname) || AppValidationMgr.isEmail(uname)) {
                if (!TextUtils.isEmpty(password) && !TextUtils.isEmpty(passwords)) {
                    if (password.equals(passwords)) {
                        MediaType type = MediaType.parse("application/json;charset=UTF-8");
                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put("authCode", code);
                            jsonObject.put("confirmPassword", passwords);
                            jsonObject.put("newPassword", password);
                            jsonObject.put("telephone", uname);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String string = jsonObject.toString();
                        RequestBody bodys = RequestBody.create(type, string);
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(MyServer.url)
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                        MyServer myServer = retrofit.create(MyServer.class);
                        Observable<FindPasswordBean> findPassword = myServer.getFindPassword(bodys);
                        findPassword.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Observer<FindPasswordBean>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(FindPasswordBean findPasswordBean) {
                                        if (findPasswordBean.getCode() == 200) {
                                            showLongToast(findPasswordBean.getMessage());
                                            finish();
                                        }
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        showToast(e.getMessage());
                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                });
                    }else {
                        showToast("密码不一致");
                    }
                }else {
                    showToast("密码不能为空");
                }
            }else {
                showToast("请输入正确的手机号或邮箱");
            }
        }else {
            showToast("手机号或邮箱或验证码不能为空");
        }
    }

    private void initgetcode() {
        String uanme = mFindpassEdPhoneEmil.getText().toString();
        if (!TextUtils.isEmpty(uanme)) {
            if (AppValidationMgr.isPhone(uanme) || AppValidationMgr.isEmail(uanme)) {
                downTimerUtils.start();
//                mPresenter.getData(ApiConfig.VER_GETCODE,uanme);
                Retrofit build = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(MyServer.url)
                        .build();
                MyServer myServer = build.create(MyServer.class);
                Observable<VerificationBean> verGetcode = myServer.getVerGetcode(uanme);
                verGetcode.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<VerificationBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(VerificationBean bean) {
                                String data = bean.getData();
                                mFindpassEdCode.setText(data);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }else {
                showToast("请输入正确的手机号或邮箱");
            }
        }else {
            showToast("手机号或验不能为空");
        }
    }
}
