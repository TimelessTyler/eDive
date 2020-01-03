package com.example.edives.activity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edives.R;
import com.example.edives.bean.UpdateCoachMessageBean;
import com.example.edives.bean.VerificationBean;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.frame.MyServer;
import com.example.edives.model.PersonModel;
import com.example.edives.utils.AppValidationMgr;
import com.example.edives.utils.CountDownTimerUtils;
import com.example.edives.utils.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
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

public class UpdatePhoneActivity extends BaseMvpActivity<PersonModel> {

    @BindView(R.id.iv_phone)
    ImageView mIvPhone;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.iv_pn)
    ImageView mIvPn;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.iv_yanz)
    ImageView mIvYanz;
    @BindView(R.id.et_code)
    EditText mEtCode;
    @BindView(R.id.bt_getcode)
    Button mBtGetcode;
    @BindView(R.id.bt_succss)
    Button mBtSuccss;
    private CountDownTimerUtils downTimerUtils;

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
        return R.layout.activity_update_phone;
    }

    @Override
    public void initView() {
        String phone = getIntent().getStringExtra("phone");
        mTvPhone.setText("当前手机号码："+phone);
        downTimerUtils = new CountDownTimerUtils(mBtGetcode, 60000, 1000);
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
        switch (whichApi){
            case ApiConfig.XIUGAIGERENXX:
                UpdateCoachMessageBean updateCoachMessageBean = (UpdateCoachMessageBean) t[0];
                if (updateCoachMessageBean.getCode() == 200) {
                    showToast(updateCoachMessageBean.getMessage());
                    finish();
                }else {
                    showToast(updateCoachMessageBean.getMessage());
                }
                break;
        }
    }

    @OnClick({R.id.bt_getcode, R.id.bt_succss})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_getcode:
                initgetCode();
                break;
            case R.id.bt_succss:
                initok();
                break;
        }
    }
    private void initgetCode() {
        String uname = mEtPhone.getText().toString();
        if (!TextUtils.isEmpty(uname)) {
            if (AppValidationMgr.isPhone(uname) || AppValidationMgr.isEmail(uname)) {
                //获取验证码
                downTimerUtils.start();
//                mPresenter.getData(ApiConfig.VER_GETCODE,uname);
                Retrofit build = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(MyServer.url)
                        .build();
                MyServer myServer = build.create(MyServer.class);
                Observable<VerificationBean> verGetcode = myServer.getVerGetcode(uname);
                verGetcode.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<VerificationBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(VerificationBean bean) {
                                String data = bean.getData();
                                mEtCode.setText(data);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }else {
                ToastUtil.showLong("请填写正确的手机号或邮箱");
            }
        }else {
            ToastUtil.showLong("手机号或邮箱不能为空");
        }
    }
    private void initok() {
        String phone = mEtPhone.getText().toString();
        String code = mEtCode.getText().toString();
        if (!phone.isEmpty()) {
            if (!code.isEmpty()) {
                MediaType types = MediaType.parse("application/json;charset=UTF-8");
                JSONObject jsonObjects = new JSONObject();
                try {
                    jsonObjects.put("phone", mEtPhone.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String str = jsonObjects.toString();
                RequestBody body = RequestBody.create(types, str);
                mPresenter.getData(ApiConfig.XIUGAIGERENXX,body);
            }else {
                showToast("验证码为空");
            }
        }else {
            showToast("手机号不能为空");
        }
    }
}
