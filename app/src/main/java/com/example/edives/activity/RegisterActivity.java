package com.example.edives.activity;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.edives.R;
import com.example.edives.bean.UpLoadBean;
import com.example.edives.bean.VerificationBean;
import com.example.edives.design.GlideRoundTransform;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.frame.MyServer;
import com.example.edives.local_utils.MediaLoader;
import com.example.edives.model.LoginModel;
import com.example.edives.utils.AppValidationMgr;
import com.example.edives.utils.CountDownTimerUtils;
import com.google.gson.Gson;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.XXPermissions;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumConfig;
import com.yanzhenjie.album.AlbumFile;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends BaseMvpActivity<LoginModel> {

    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.et_code)
    EditText mEtCode;
    @BindView(R.id.et_password)
    EditText mEtPassworde;
    @BindView(R.id.et_passwords)
    EditText mEtPasswordes;
    @BindView(R.id.tv_getVerificationCode)
    TextView mBtGetcode;
    @BindView(R.id.tv_Registered)
    TextView mRegis;
    @BindView(R.id.bt_ok)
    Button mBtOk;

    private CountDownTimerUtils downTimerUtils;
    private ArrayList<String> list;
    private String path;
    private String data;
    private String datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.Setting_bg));
        }
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
//        getPermission();
//倒计时工具类
        downTimerUtils = new CountDownTimerUtils(mBtGetcode, 60000, 1000);
        Album.initialize(AlbumConfig.newBuilder(RegisterActivity.this).setAlbumLoader(new MediaLoader()).build());
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

    @OnClick({R.id.bt_getcode, R.id.bt_ok,R.id.tv_Registered})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_getcode:
                initgetcode();
                break;
            case R.id.bt_ok:
                initok();
                break;
                //用户注册协议
            case R.id.tv_Registered:

                break;
        }
    }

    private void initgetcode() {
        String phone = mEtPhone.getText().toString();
        if (!TextUtils.isEmpty(phone)) {
            if (AppValidationMgr.isPhone(phone)) {
                //获取验证码
                downTimerUtils.start();
                Retrofit build = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(MyServer.url)
                        .build();
                MyServer myServer = build.create(MyServer.class);
                Observable<VerificationBean> verGetcode = myServer.getVerGetcode(phone);
                verGetcode.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<VerificationBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(VerificationBean bean) {
                                data = bean.getData();
                                mEtCode.setText(data);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            } else {
                showToast("请输入正确的手机号");
            }
        } else {
            showToast("手机号不能为空");
        }
    }

    private void initok() {
        String phone = mEtPhone.getText().toString();
        String code = mEtCode.getText().toString();
        String pass = mEtPassworde.getText().toString();
        String passw = mEtPasswordes.getText().toString();
        if (!TextUtils.isEmpty(phone)) {
            if (AppValidationMgr.isPhone(phone)) {
                if (!TextUtils.isEmpty(code)) {
                    if (!TextUtils.isEmpty(pass)) {
                        if (!TextUtils.isEmpty(passw)) {
                            if (pass.equals(passw)) {
                                showToast("ok");
                            }else {
                                showToast("密码不一致");
                            }
                        }else {
                            showToast("密码不能为空");
                        }
                    }else {
                        showToast("密码不能为空");
                    }
//                    if (!TextUtils.isEmpty(path)) {
//
//                        MediaType type = MediaType.parse("application/json;charset=UTF-8");
//                        JSONObject jsonObject = new JSONObject();
//                        try {
//                            jsonObject.put("authCode", data);
//                            jsonObject.put("certificatePic", datas);
//                            jsonObject.put("phone", mEtPhone.getText().toString());
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        String string = jsonObject.toString();
//                        RequestBody bodys = RequestBody.create(type, string);
////                                                mPresenter.getData(ApiConfig.ADDDYNAMIC, bodys);
//                        Retrofit build = new Retrofit.Builder()
//                                .addConverterFactory(GsonConverterFactory.create())
//                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                                .baseUrl(MyServer.url)
//                                .build();
//                        MyServer myServer = build.create(MyServer.class);
//                        Observable<VerificationBean> verGetcode = myServer.getRegister(bodys);
//                        verGetcode.subscribeOn(Schedulers.io())
//                                .observeOn(AndroidSchedulers.mainThread())
//                                .subscribe(new Observer<VerificationBean>() {
//                                    @Override
//                                    public void onSubscribe(Disposable d) {
//
//                                    }
//
//                                    @Override
//                                    public void onNext(VerificationBean bean) {
//                                        showToast(bean.getMessage());
////                                        finish();
//                                    }
//
//                                    @Override
//                                    public void onError(Throwable e) {
//
//                                    }
//
//                                    @Override
//                                    public void onComplete() {
//
//                                    }
//                                });
//                    }else {
//                        showToast("请上传照片");
//                    }
                }else {
                    showToast("验证码不能为空");
                }
            }else {
                showToast("请输入正确的手机号");
            }
        }else {
            showToast("手机号不能为空");
        }
    }


}
