package com.example.edive.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.system.Os;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.example.edive.R;
import com.example.edive.adapter.QuestionFeedbackAdapter;
import com.example.edive.bean.UpLoadBean;
import com.example.edive.frame.ApiConfig;
import com.example.edive.frame.BaseApplication;
import com.example.edive.frame.BaseMvpActivity;
import com.example.edive.local_utils.MediaLoader;
import com.example.edive.local_utils.StringUtils;
import com.example.edive.model.HomeModel;
import com.example.edive.utils.SharedPrefrenceUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AcademicEvidenceActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.rg_CertificateName)
    RadioGroup mCertificateName;
    @BindView(R.id.rb_OWD)
    RadioButton mOWD;
    @BindView(R.id.rb_OW)
    RadioButton mOW;
    @BindView(R.id.rl_certificate_address)
    RelativeLayout mCertificateAddress;
    @BindView(R.id.et_certificate_title)
    EditText mCertificateTitle;
    @BindView(R.id.et_certificate_price)
    EditText mCertificatePrice;
    @BindView(R.id.et_certificate_time)
    EditText mcertificateTime;
    @BindView(R.id.rl_MostPeople)
    RelativeLayout mMostPeople;
    @BindView(R.id.rg_timelimit)
    RadioGroup mTimeLimit;
    @BindView(R.id.rb_Time_Yes)
    RadioButton mTimeYes;
    @BindView(R.id.rb_Time_No)
    RadioButton mTimeNo;
    @BindView(R.id.tv_StartTime)
    TextView mStartTime;
    @BindView(R.id.tv_EndTime)
    TextView mEndTime;
    @BindView(R.id.ll_send_photo)
    RecyclerView mSendPhoto;
    @BindView(R.id.et_Cost_includes)
    EditText mCostIncludes;
    @BindView(R.id.et_Nocost_contain)
    EditText mNocostContain;
    @BindView(R.id.et_ApplicationNotes)
    EditText mApplicationNotes;
    @BindView(R.id.et_Location_introduction)
    EditText mLocationIntroduction;
    @BindView(R.id.Formation_arrangement)
    RecyclerView mFormationArrangement;
    @BindView(R.id.btn_addScheduling)
    Button maddScheduling;
    @BindView(R.id.tv_mytrip)
    TextView mytrip;

    private TimePickerView pvTime;
    private String mCertificate;
    private QuestionFeedbackAdapter adapter;
    private int topicid;
    private ArrayList<String> list;
    private ArrayList<String> PicList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.findpassword_bg));//设置颜色
        }

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_academic_evidence;
    }

    @Override
    public void initView() {
        getPermission();
        list = new ArrayList<>();
        PicList = new ArrayList<>();
        Album.initialize(AlbumConfig.newBuilder(AcademicEvidenceActivity.this).setAlbumLoader(new MediaLoader()).build());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(AcademicEvidenceActivity.this,3);
        mSendPhoto.setLayoutManager(gridLayoutManager);
        adapter = new QuestionFeedbackAdapter(AcademicEvidenceActivity.this,list);
        mSendPhoto.setAdapter(adapter);
        adapter.setonclick(new QuestionFeedbackAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                list.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
        adapter.setOnItemClickListener(new QuestionFeedbackAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                initAlbum();
            }

            private void initAlbum() {
                Album.image(AcademicEvidenceActivity.this)
                        .multipleChoice()
                        .camera(true)
                        .columnCount(3)
                        .selectCount(9)
                        .onResult(new Action<ArrayList<AlbumFile>>() {
                            @Override
                            public void onAction(@NonNull ArrayList<AlbumFile> result) {
                                for (int i = 0; i < result.size(); i++) {
                                    String path = result.get(i).getPath();
                                    list.add(path);
                                }
                                adapter.notifyDataSetChanged();
                            }
                        }).onCancel(new Action<String>() {
                    @Override
                    public void onAction(@NonNull String result) {
//                finish();
                    }
                }).start();
            }
        });

    }




    @Override
    public void initData() {
        initTime();

        //选择证书
        mCertificateName.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (mOWD.getId() == checkedId){
                    mCertificate = mOWD.getText().toString();
                }
                if (mOW.getId() == checkedId){
                    mCertificate = mOW.getText().toString();
                }
                //
                Toast.makeText(mApplication, "您选择的证书为: "+ mCertificate, Toast.LENGTH_SHORT).show();
            }
        });
        //是否时间限制
        mTimeLimit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (mTimeYes.getId() == checkedId){

                }
                if (mTimeNo.getId() == checkedId){

                }
            }
        });


    }



    @Override
    public HomeModel getModel() {
        return null;
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @OnClick({R.id.rl_certificate_address,R.id.et_certificate_title,R.id.et_certificate_price,R.id.et_certificate_time, R.id.rl_MostPeople,R.id.et_Cost_includes,R.id.ll_send_photo,
            R.id.et_Nocost_contain,R.id.et_ApplicationNotes,R.id.et_Location_introduction,R.id.Formation_arrangement})
    public void OnClick(View v){
        switch (v.getId()){
            default:
                break;
            case R.id.rl_certificate_address:


                break;
            case R.id.et_certificate_title:

                break;
            case R.id.et_certificate_price:

                break;
            case R.id.et_certificate_time:


                break;
            case R.id.rl_MostPeople:


                break;
            case R.id.et_Cost_includes:


                break;
            case R.id.ll_send_photo:
                initOK();
                break;
            case R.id.et_Nocost_contain:


                break;
            case R.id.et_ApplicationNotes:


                break;
            case R.id.et_Location_introduction:



                break;
            case R.id.Formation_arrangement:

                break;
        }
    }




    private void initTime() {
        mStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvTime.show(mStartTime);
            }
        });
        mEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvTime.show(mEndTime);
            }
        });
        pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                TextView view = (TextView)v;
                view.setText(getTimes(date));
            }
        })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(new boolean[]{true, true, true, true, true, false})
                .setLabel("年", "月", "日", "时", "分", "")
                .isCenterLabel(true)
                .setDividerColor(Color.DKGRAY)
                .setContentSize(21)
                .setDecorView(null)
                .build();
    }
    private void initOK() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();
        for (int i = 0; i < list.size(); i++) {

            /**
             * 封装文件上传的  请求体
             */
            File file = new File(list.get(i));
            //1.设置文件以及文件上传类型封装
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), file);

            //2.文件上传的请求体封装
            MultipartBody body = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)//设置文件上传Type类型为multipart/form-data
                    .addFormDataPart("files", file.getName(), requestBody)//设置文件参数
                    .build();

            Request request = new Request.Builder()
                    .url("http://192.168.0.246:8000/uploadFile/saveFile")
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
                                    PicList.add(data);
                                    if (PicList.size() == list.size()) {
                                        String userid = mApplication.userid;
                                        String topicids = SharedPrefrenceUtils.getString(AcademicEvidenceActivity.this, "topicid");
                                        topicid = Integer.valueOf(topicids);
                                        MediaType type = MediaType.parse("application/json;charset=UTF-8");
                                        JSONObject jsonObject = new JSONObject();
                                        try {
                                            jsonObject.put("userId", userid);
                                            jsonObject.put("topicids", topicid);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                        String string = jsonObject.toString();
                                        RequestBody bodys = RequestBody.create(type, string);
                                        mPresenter.getData(ApiConfig.ADDDYNAMIC, bodys);
//                                                finish();
//                                                FileUtils.deleteDir();//删除保存内容
                                    }
                                } else {
//                                            Toast.makeText(PublishDynamicActivity.this,upLoadBean.getCode(),Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(AcademicEvidenceActivity.this, "错误", Toast.LENGTH_SHORT).show();
                            }


                        }
                    });
                }
            });
        }
    }

    private String getTimes(Date date) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
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
    }
}
