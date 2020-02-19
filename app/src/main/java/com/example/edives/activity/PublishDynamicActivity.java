package com.example.edives.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import com.example.edives.R;
import com.example.edives.adapter.QuestionFeedbackAdapter;
import com.example.edives.bean.AddDynamicBean;
import com.example.edives.bean.UpLoadBean;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseApplication;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.local_utils.MediaLoader;
import com.example.edives.local_utils.StringUtils;
import com.example.edives.model.HomeModel;
import com.example.edives.utils.SharedPrefrenceUtils;
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
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PublishDynamicActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.bt_ok)
    Button mBtOk;
    @BindView(R.id.tv_top)
    TextView mTvTop;
    @BindView(R.id.et_text)
    EditText mEtText;
    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.tv_conversation)
    TextView mTvConversation;
    @BindView(R.id.tv_location)
    TextView mTvLocation;
    private QuestionFeedbackAdapter adapter;
    private ArrayList<String> list;
    private ArrayList<String> PicList;
    private int topicid;
    private String location;

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
        return R.layout.activity_publish_dynamic;
    }

    @Override
    public void initView() {
        getPermission();
        list = new ArrayList<>();
        PicList = new ArrayList<>();
        Album.initialize(AlbumConfig.newBuilder(PublishDynamicActivity.this).setAlbumLoader(new MediaLoader()).build());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(PublishDynamicActivity.this, 3);
        mRec.setLayoutManager(gridLayoutManager);
        adapter = new QuestionFeedbackAdapter(PublishDynamicActivity.this, list);
        mRec.setAdapter(adapter);
        adapter.setonclick(new QuestionFeedbackAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                list.remove(pos);
                PicList.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
        adapter.setOnItemClickListener(new QuestionFeedbackAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                initAlbum();
            }
        });
    }
    private void initAlbum() {
        Album.image(PublishDynamicActivity.this)
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
                        initApply();
                    }
                }).onCancel(new Action<String>() {
            @Override
            public void onAction(@NonNull String result) {
//                finish();
            }
        }).start();
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
        switch (whichApi){
            case ApiConfig.ADDDYNAMIC:
                AddDynamicBean upLoadBean = (AddDynamicBean) t[0];
                if (upLoadBean.getCode() == 200) {
                    showToast(upLoadBean.getMessage());
//                    startActivity(new Intent(PublishDynamicActivity.this,HomeActivity.class));
//                    this.finish();
                    finish();
                }else {
                    showToast(upLoadBean.getMessage());
                }
                break;
        }
    }

    @OnClick({R.id.iv_back, R.id.bt_ok, R.id.tv_conversation, R.id.tv_location})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_ok:
                String text = mEtText.getText().toString();
                if (!TextUtils.isEmpty(text)) {
                    initupload();
                }else {
                    showToast("请输入内容");
                }
                break;
            case R.id.tv_conversation:
                Intent intent = new Intent(PublishDynamicActivity.this, ChooesConversationActivity.class);
                startActivityForResult(intent,100);
                break;
            case R.id.tv_location:
                Intent intent1 = new Intent(PublishDynamicActivity.this, LocationActivity.class);
                startActivityForResult(intent1,100);
                break;
        }
    }
    private void initupload() {
        String join = StringUtils.join(PicList, ",");
        String nickname = mApplication.nickname;
        String content = mEtText.getText().toString();
        String userid = mApplication.userid;
        location = mTvLocation.getText().toString();
        if (location.equals("添加地点")) {
            location = "";
        }
        String topicids = SharedPrefrenceUtils.getString(PublishDynamicActivity.this, "topicid");
        if (!TextUtils.isEmpty(topicids)) {
            topicid = Integer.valueOf(topicids);
        }
        MediaType type = MediaType.parse("application/json;charset=UTF-8");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("dynamicAddress", location);
            jsonObject.put("dynamicAuthor", nickname);
            jsonObject.put("dynamicContent", content);
            jsonObject.put("dynamicPicture", join);
            jsonObject.put("topicId", topicid);
            jsonObject.put("userId", userid);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String string = jsonObject.toString();
        RequestBody bodys = RequestBody.create(type, string);
        mPresenter.getData(ApiConfig.ADDDYNAMIC,bodys);
    }

    private void initApply() {
        showLoadingDialog();
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
                    hideLoadingDialog();
                    String str = response.body().string();

                    Gson gson = new Gson();
                    final UpLoadBean upLoadBean = gson.fromJson(str, UpLoadBean.class);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (upLoadBean!=null){
                                if (upLoadBean.getCode() == 200){
                                    Log.e("ben",upLoadBean.toString());
                                    //上传成功之后返回的图片路径
                                    String data = upLoadBean.getData();
                                    PicList.add(data);
                                    if (PicList.size() == list.size()) {

                                    }
                                }else {
//                                            Toast.makeText(PublishDynamicActivity.this,upLoadBean.getCode(),Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(PublishDynamicActivity.this,"错误",Toast.LENGTH_SHORT).show();
                            }


                        }
                    });
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            String topicname = data.getStringExtra("topicname");
            topicid = data.getExtras().getInt("topicid");
            String lo = data.getStringExtra("lo");
            if (!TextUtils.isEmpty(topicname)) {
                mTvTop.setText("#"+topicname);
            }
            if (!TextUtils.isEmpty(lo)) {
                mTvLocation.setText(lo);
            }
        }
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
//                                      String datas = ArrayListToString(PicList);
                                        String join = StringUtils.join(PicList, ",");
                                        String nickname = mApplication.nickname;
                                        String content = mEtText.getText().toString();
                                        String userid = mApplication.userid;
                                        location = mTvLocation.getText().toString();
                                        if (location.equals("添加地点")) {
                                            location = "";
                                        }
                                        String topicids = SharedPrefrenceUtils.getString(PublishDynamicActivity.this, "topicid");
                                        topicid = Integer.valueOf(topicids);
                                        MediaType type = MediaType.parse("application/json;charset=UTF-8");
                                        JSONObject jsonObject = new JSONObject();
                                        try {
                                            jsonObject.put("dynamicAddress", location);
                                            jsonObject.put("dynamicAuthor", nickname);
                                            jsonObject.put("dynamicContent", content);
                                            jsonObject.put("dynamicPicture", join);
                                            jsonObject.put("topicId", topicid);
                                            jsonObject.put("userId", userid);
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
                                            Toast.makeText(PublishDynamicActivity.this,upLoadBean.getCode()+upLoadBean.getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(PublishDynamicActivity.this, "错误", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            });
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
}
