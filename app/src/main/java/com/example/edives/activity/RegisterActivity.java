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
    @BindView(R.id.tv_co)
    TextView mTvCo;
    @BindView(R.id.iv_addphoto)
    ImageView mIvAddphoto;
    @BindView(R.id.bt_ok)
    Button mBtOk;
    @BindView(R.id.tv_ss)
    TextView mTvSs;
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
            window.setStatusBarColor(getResources().getColor(R.color.findpassword_bg));
        }
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        getPermission();
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

    @OnClick({R.id.bt_getcode, R.id.iv_addphoto, R.id.bt_ok})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_getcode:
                initgetcode();
                break;
            case R.id.iv_addphoto:
                initAlbum();
                break;
            case R.id.bt_ok:
                initok();
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
        if (!TextUtils.isEmpty(phone)) {
            if (AppValidationMgr.isPhone(phone)) {
                if (!TextUtils.isEmpty(code)) {
                    if (!TextUtils.isEmpty(path)) {

                        MediaType type = MediaType.parse("application/json;charset=UTF-8");
                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put("authCode", data);
                            jsonObject.put("certificatePic", datas);
                            jsonObject.put("phone", mEtPhone.getText().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String string = jsonObject.toString();
                        RequestBody bodys = RequestBody.create(type, string);
//                                                mPresenter.getData(ApiConfig.ADDDYNAMIC, bodys);
                        Retrofit build = new Retrofit.Builder()
                                .addConverterFactory(GsonConverterFactory.create())
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                .baseUrl(MyServer.url)
                                .build();
                        MyServer myServer = build.create(MyServer.class);
                        Observable<VerificationBean> verGetcode = myServer.getRegister(bodys);
                        verGetcode.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Observer<VerificationBean>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(VerificationBean bean) {
                                        showToast(bean.getMessage());
//                                        finish();
                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                });
                    }else {
                        showToast("请上传照片");
                    }
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

    private void getPermission() {
        XXPermissions.with(this)
                .constantRequest() //可设置被拒绝后继续申请，直到用户授权或者永久拒绝
                //.permission(Permission.SYSTEM_ALERT_WINDOW, Permission.REQUEST_INSTALL_PACKAGES) //支持请求 6.0 悬浮窗权限 8.0 请求安装权限
                .permission(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE) //不指定权限则自动获取清单中的危险权限
                .request(new OnPermission() {

                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {

                    }

                    @Override
                    public void noPermission(List<String> denied, boolean quick) {
                        if (denied.size() != 0) showToast("拒绝权限影响您正常使用");
                    }
                });
        //XXPermissions.gotoPermissionSettings(this);//跳转到权限设置页面
    }

    private void initAlbum() {
        Album.image(RegisterActivity.this)
                .multipleChoice()
                .camera(true)
                .columnCount(3)
                .selectCount(1)
                .onResult(new Action<ArrayList<AlbumFile>>() {
                    @Override
                    public void onAction(@NonNull ArrayList<AlbumFile> result) {
                        for (int i = 0; i < result.size(); i++) {
                            String path = result.get(i).getPath();
                            list.add(path);
                        }
                        path = result.get(0).getPath();
                        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                .build();
                        /**
                         * 封装文件上传的  请求体
                         */
                        File file = new File(path);
                        //1.设置文件以及文件上传类型封装
                        RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), file);

                        //2.文件上传的请求体封装
                        MultipartBody body = new MultipartBody.Builder()
                                .setType(MultipartBody.FORM)//设置文件上传Type类型为multipart/form-data
                                .addFormDataPart("files", file.getName(), requestBody)//设置文件参数
                                .build();

                        Request request = new Request.Builder()
                                .url("http://47.107.50.253:8080/DmdMall/sso/saveFile")
                                .post(body)
                                .build();

                        Call call = okHttpClient.newCall(request);

                        call.enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                Log.e("onFailure",e.getMessage());
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                String str = response.body().string();

                                Gson gson = new Gson();
                                final UpLoadBean upLoadBean = gson.fromJson(str, UpLoadBean.class);

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (upLoadBean != null) {
                                            if (upLoadBean.getCode() == 200) {
//                                Glide.with(PublishVideoActivity.this).load(upLoadBean.getData().getUrl()).into(img);
//                                            showToast("上传成功");
                                                Log.e("ben", upLoadBean.toString());
                                                //上传成功之后返回的图片路径
                                                datas = upLoadBean.getData();
                                                Glide.with(RegisterActivity.this).load(datas).transform(new CenterCrop(),new GlideRoundTransform(RegisterActivity.this,5)).into(mIvAddphoto);

//                                                finish();
//                                                FileUtils.deleteDir();//删除保存内容

                                            } else {
                                            Toast.makeText(RegisterActivity.this,upLoadBean.getCode(),Toast.LENGTH_SHORT).show();
                                            }
                                        } else {
                                            Toast.makeText(RegisterActivity.this, "错误", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        });


//                        adapter.notifyDataSetChanged();
                    }
                }).onCancel(new Action<String>() {
            @Override
            public void onAction(@NonNull String result) {
//                finish();
            }
        }).start();
    }

}
