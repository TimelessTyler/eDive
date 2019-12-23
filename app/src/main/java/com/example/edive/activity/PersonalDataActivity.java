package com.example.edive.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.edive.R;
import com.example.edive.adapter.QuestionFeedbackAdapter;
import com.example.edive.bean.MyPersonBean;
import com.example.edive.bean.UpLoadBean;
import com.example.edive.bean.UpdateCoachMessageBean;
import com.example.edive.design.RoundOrCircleImage;
import com.example.edive.frame.ApiConfig;
import com.example.edive.frame.BaseApplication;
import com.example.edive.frame.BaseMvpActivity;
import com.example.edive.local_utils.MediaLoader;
import com.example.edive.local_utils.StringUtils;
import com.example.edive.model.PersonModel;
import com.example.edive.utils.NormalConfig;
import com.google.gson.Gson;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.XXPermissions;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumConfig;
import com.yanzhenjie.album.AlbumFile;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.app.TakePhotoImpl;
import org.devio.takephoto.compress.CompressConfig;
import org.devio.takephoto.model.CropOptions;
import org.devio.takephoto.model.TResult;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PersonalDataActivity extends BaseMvpActivity<PersonModel> implements TakePhoto.TakeResultListener{

    @BindView(R.id.iv_photomore)
    ImageView mIvPhotomore;
    @BindView(R.id.iv_photos)
    RoundOrCircleImage mIvPhotos;
    @BindView(R.id.rl_iv_photo)
    RelativeLayout mRlIvPhoto;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.rl_name)
    RelativeLayout mRlName;
    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.tv_sex)
    TextView mTvSex;
    @BindView(R.id.rl_sex)
    RelativeLayout mRlSex;
    @BindView(R.id.iv_phone_more)
    ImageView mIvPhoneMore;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.rl_phone)
    RelativeLayout mRlPhone;
    @BindView(R.id.tv_coachgral)
    TextView mTvCoachgral;
    @BindView(R.id.rl_coachgral)
    RelativeLayout mRlCoachgral;
    @BindView(R.id.iv_wechat_more)
    ImageView mIvWechatMore;
    @BindView(R.id.tv_wechat)
    TextView mTvWechat;
    @BindView(R.id.rl_wechat)
    RelativeLayout mRlWechat;
    @BindView(R.id.iv_m)
    ImageView mIvM;
    @BindView(R.id.et_text)
    TextView mEtText;
    @BindView(R.id.ll_textperson)
    RelativeLayout mLlTextperson;
    @BindView(R.id.tv_ph)
    TextView mTvPh;
    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.rl_photo)
    RelativeLayout mRlPhoto;
    private PopupWindow popupWindow;
    private TakePhotoImpl mTakephoto;
    private String name;
    private String string;
    private String phone;
    private ArrayList<String> photoList;
    private QuestionFeedbackAdapter adapters;
    private ArrayList<String> strList;

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
        return R.layout.activity_personal_data;
    }

    @Override
    public void initView() {
        getPermission();
        mTakephoto = new TakePhotoImpl(this, this);
        Album.initialize(AlbumConfig.newBuilder(PersonalDataActivity.this).setAlbumLoader(new MediaLoader()).build());
        strList = new ArrayList<>();
        photoList = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(PersonalDataActivity.this, 3);
        photoList = new ArrayList<>();
        mRec.setLayoutManager(gridLayoutManager);
        adapters = new QuestionFeedbackAdapter(PersonalDataActivity.this, photoList);
        mRec.setAdapter(adapters);
        adapters.setonclick(new QuestionFeedbackAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                photoList.remove(pos);
                adapters.notifyDataSetChanged();
                String join = StringUtils.join(photoList, ",");

                MediaType types = MediaType.parse("application/json;charset=UTF-8");
                JSONObject jsonObjects = new JSONObject();
                try {
                    jsonObjects.put("personalAlbum", join);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String str = jsonObjects.toString();
                RequestBody body = RequestBody.create(types, str);
                mPresenter.getData(ApiConfig.XIUGAIGERENXX,body);

            }
        });
        adapters.setOnItemClickListener(new QuestionFeedbackAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                initAlbum();
            }
        });
    }
    private void initAlbum() {
        Album.image(PersonalDataActivity.this)
                .multipleChoice()
                .camera(true)
                .columnCount(3)
                .selectCount(5)
                .onResult(new Action<ArrayList<AlbumFile>>() {
                    @Override
                    public void onAction(@NonNull ArrayList<AlbumFile> result) {
                        for (int i = 0; i < result.size(); i++) {
                            String path = result.get(i).getPath();
                            photoList.add(path);
                            adapters.notifyDataSetChanged();
                        }
                        initupdate();

                    }
                }).onCancel(new Action<String>() {
            @Override
            public void onAction(@NonNull String result) {
//                finish();
            }
        }).start();
    }

    private void initupdate() {

        for (int j = 0; j < photoList.size(); j++) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .build();
            /**
             * 封装文件上传的  请求体
             */
            File file = new File(photoList.get(j));
            //1.设置文件以及文件上传类型封装
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), file);

            //2.文件上传的请求体封装
            MultipartBody body = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)//设置文件上传Type类型为multipart/form-data
                    .addFormDataPart("files", file.getName(), requestBody)//设置文件参数
                    .build();

            Request request = new Request.Builder()
                    .url("http://47.107.50.253:8080/DmdMall/uploadFile/saveFile")
                    .addHeader("Authorization","Bearer " + BaseApplication.getInstance().Token)
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
                            if (upLoadBean!=null){
                                if (upLoadBean.getCode() == 200){
//                                Glide.with(PublishVideoActivity.this).load(upLoadBean.getData().getUrl()).into(img);
//                                            showToast("上传成功");
                                    Log.e("ben",upLoadBean.toString());
                                    //上传成功之后返回的图片路径
                                    String data = upLoadBean.getData();
                                    strList.add(data);
                                    if (photoList.size() == strList.size()) {
                                        String join = StringUtils.join(strList, ",");
                                        MediaType types = MediaType.parse("application/json;charset=UTF-8");
                                        JSONObject jsonObjects = new JSONObject();
                                        try {
                                            jsonObjects.put("personalAlbum", join);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                        String str = jsonObjects.toString();
                                        RequestBody body = RequestBody.create(types, str);
                                        mPresenter.getData(ApiConfig.XIUGAIGERENXX,body);
//
                                    }
                                }else {
//                                            Toast.makeText(PublishDynamicActivity.this,upLoadBean.getCode(),Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(PersonalDataActivity.this,"错误",Toast.LENGTH_SHORT).show();
                            }


                        }
                    });
                }
            });
        }
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.MYPERSONDESTIALS);
    }

    @Override
    public PersonModel getModel() {
        return new PersonModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        Log.e("PersonalDataActivity",e.getMessage());
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi){
            case ApiConfig.MYPERSONDESTIALS:
                MyPersonBean myPersonBean = (MyPersonBean) t[0];
                if (myPersonBean.getCode() == 200) {
                    photoList.clear();
                    MyPersonBean.ResultBean result = myPersonBean.getResult();
                    phone = result.getPhone();
                    string = result.getPersonalProfile();
                    name = result.getNickName();
                    mTvCoachgral.setText("V"+result.getCoachGrade());
                    Glide.with(PersonalDataActivity.this).load(result.getIcon()).placeholder(R.mipmap.morentouxiang).into(mIvPhotos);
                    mTvName.setText(result.getNickName());
                    mTvPhone.setText(result.getPhone());
                    mEtText.setText(string);
                    String dynamicPicture = result.getPersonalAlbum();
                    if (!TextUtils.isEmpty(dynamicPicture)) {
                        String[] split = dynamicPicture.split(",");
                        for (int j = 0; j < split.length; j++) {
                            photoList.add(split[j]);
                        }
                        adapters.notifyDataSetChanged();
                    }
                }else {
                    showToast(myPersonBean.getMessage());
                }
                break;
                case ApiConfig.XIUGAIGERENXX:
                    UpdateCoachMessageBean updateCoachMessageBean = (UpdateCoachMessageBean) t[0];
                    if (updateCoachMessageBean.getCode() == 200) {
                        showToast(updateCoachMessageBean.getMessage());
                        mPresenter.getData(ApiConfig.MYPERSONDESTIALS);
                    }else {
                        showToast(updateCoachMessageBean.getMessage());
                    }
                    break;
        }
    }

    @OnClick({R.id.rl_iv_photo, R.id.rl_name, R.id.rl_sex, R.id.rl_phone, R.id.rl_coachgral, R.id.rl_wechat, R.id.ll_textperson})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rl_iv_photo:
                //头像
                initPops();
                break;
            case R.id.rl_name:
                //昵称
                Intent intent = new Intent(PersonalDataActivity.this, UpdateNameActivity.class);
                intent.putExtra("name", name);
                startActivityForResult(intent,100);
                break;
            case R.id.rl_sex:
                //性别
                break;
            case R.id.rl_phone:
                //手机号
                Intent intent2 = new Intent(PersonalDataActivity.this, UpdatePhoneActivity.class);
                intent2.putExtra("phone",phone);
                startActivity(intent2);
                break;
            case R.id.rl_coachgral:
                //教练等级
                break;
            case R.id.rl_wechat:
                //微信
                break;
            case R.id.ll_textperson:
                //个人简介
                Intent intent1 = new Intent(PersonalDataActivity.this, UpdateMyTextActivity.class);
                intent1.putExtra("text", string);
                startActivity(intent1);
                break;
        }

    }

    private void initPops() {
        View inflate1 = LayoutInflater.from(this).inflate(R.layout.layout_popo_person_photo, null);
        TextView tv_photo = inflate1.findViewById(R.id.tv_photo);
        TextView tv_camer = inflate1.findViewById(R.id.tv_camer);
        TextView tv_colse = inflate1.findViewById(R.id.tv_colse);
        popupWindow = new PopupWindow(inflate1, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(R.style.PopupAnimation);
        popupWindow.showAtLocation(inflate1, Gravity.BOTTOM, 0, 0);
        //进去popupWindow时背景
        final WindowManager.LayoutParams lp = PersonalDataActivity.this.getWindow().getAttributes();
        lp.alpha = 0.7f;//代表透明程度，范围为0 - 1.0f
        PersonalDataActivity.this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        PersonalDataActivity.this.getWindow().setAttributes(lp);
        /**
         * 退出popupWindow时取消暗背景
         */
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                lp.alpha = 1.0f;
                PersonalDataActivity.this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                PersonalDataActivity.this.getWindow().setAttributes(lp);
            }
        });
        tv_camer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initCamer();
            }
        });
        tv_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPhoto();
            }
        });
        tv_colse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
    private void initCamer() {
        //压缩图片
        mTakephoto.onEnableCompress(new CompressConfig.Builder().setMaxSize(50 * 1024).setMaxPixel(1080).create(), true);
        //从相册获取并裁剪
        mTakephoto.onPickFromCaptureWithCrop(getUri(), getOption());
        popupWindow.dismiss();
    }

    private void initPhoto() {
        mTakephoto.onEnableCompress(new CompressConfig.Builder().setMaxSize(50 * 1024).setMaxPixel(1080).create(), true);
        mTakephoto.onPickFromGalleryWithCrop(getUri(), getOption());
        popupWindow.dismiss();
    }
    private Uri getUri() {
        File file = new File(Environment.getExternalStorageDirectory(), "/diving/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Uri imageUri = Uri.fromFile(file);
        return imageUri;
    }
    private CropOptions getOption() {
        return new CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(false).create();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mTakephoto.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            String name = data.getStringExtra("name");
            mTvName.setText(name );
        }
    }

    @Override
    public void takeSuccess(TResult result) {
        String path = result.getImage().getCompressPath() != null ? result.getImage().getCompressPath() : result.getImage().getOriginalPath();
        if (!TextUtils.isEmpty(path)) {
            Glide.with(PersonalDataActivity.this).load(path).into(mIvPhotos);
            OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
            File file = new File(path);
            //1.设置文件以及文件上传类型封装
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), file);

            //2.文件上传的请求体封装
            MultipartBody body = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)//设置文件上传Type类型为multipart/form-data
                    .addFormDataPart("files", file.getName(), requestBody)//设置文件参数
                    .build();

            Request request = new Request.Builder()
                    .url("http://47.107.50.253:8080/DmdMall/uploadFile/saveFile")
                    .addHeader("Authorization", "Bearer " + BaseApplication.getInstance().Token)
                    .post(body)
                    .build();

            Call call = okHttpClient.newCall(request);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("onFailure", e.getMessage());
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
                                    Log.e("ben", upLoadBean.toString());
                                    //上传成功之后返回的图片路径
                                    String data = upLoadBean.getData();
                                    MediaType types = MediaType.parse("application/json;charset=UTF-8");
                                    JSONObject jsonObjects = new JSONObject();
                                    try {
                                        jsonObjects.put("icon", data);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    String str = jsonObjects.toString();
                                    RequestBody body = RequestBody.create(types, str);
                                    mPresenter.getData(ApiConfig.XIUGAIGERENXX, body);


                                } else {
//                                            Toast.makeText(PublishDynamicActivity.this,upLoadBean.getCode(),Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(PersonalDataActivity.this, "错误", Toast.LENGTH_SHORT).show();
                            }


                        }
                    });
                }
            });
        } else {
            showToast("no Path");
        }
    }

    @Override
    public void takeFail(TResult result, String msg) {

    }

    @Override
    public void takeCancel() {

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

    @Override
    protected void onResume() {
        super.onResume();
//        photoList.clear();
//        mPresenter.getData(ApiConfig.MYPERSONDESTIALS);
    }
}
