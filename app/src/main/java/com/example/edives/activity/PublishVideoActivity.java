package com.example.edives.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
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
import com.example.edives.R;
import com.example.edives.bean.UpLoadBean;
import com.example.edives.frame.BaseApplication;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.HomeModel;
import com.google.gson.Gson;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.XXPermissions;

import java.io.File;
import java.io.IOException;
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

public class PublishVideoActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.bt_ok)
    Button mBtOk;
    @BindView(R.id.tv_top)
    TextView mTvTop;
    @BindView(R.id.et_text)
    EditText mEtText;
    @BindView(R.id.iv_addVideo)
    ImageView mIvAddVideo;
    @BindView(R.id.tv_conversation)
    TextView mTvConversation;
    @BindView(R.id.tv_location)
    TextView mTvLocation;
    private String VIDEOPATH = "";
    private File file;
    private int topicid;

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
        return R.layout.activity_publish_video;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        getPermission();
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

    @OnClick({R.id.iv_back, R.id.bt_ok, R.id.iv_addVideo, R.id.tv_conversation, R.id.tv_location})
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
                    uploadFile();
                }else {
                    showToast("请输入文字");
                }
                break;
            case R.id.iv_addVideo:
                if (!TextUtils.isEmpty(VIDEOPATH)) {
                    Intent intent = new Intent(PublishVideoActivity.this, ShowVideoActivity.class);
                    intent.putExtra("video",VIDEOPATH);
                    startActivity(intent);
                }else {
                    choiceVideo();
                }
                break;
            case R.id.tv_conversation:
                //话题
                Intent intent = new Intent(PublishVideoActivity.this, ChooesConversationActivity.class);
                startActivityForResult(intent,100);
                break;
            case R.id.tv_location:
                //位置
                Intent intent1 = new Intent(PublishVideoActivity.this, LocationActivity.class);
                startActivityForResult(intent1,100);
                break;
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
    private void uploadFile() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();
        /**
         * 封装文件上传的  请求体
         */
        //1.设置文件以及文件上传类型封装
        RequestBody requestBody = RequestBody.create(MediaType.parse("*/mp4"), file);

        //2.文件上传的请求体封装
        MultipartBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)//设置文件上传Type类型为multipart/form-data
                .addFormDataPart("fileName", file.getName(), requestBody)//设置文件参数
                .build();

        Request request = new Request.Builder()
                .url("http://192.168.0.246:8000/uploadFile/uploadFile")
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
//                Log.e("ben",upLoadBean.toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (upLoadBean!=null){
                            if (upLoadBean.getCode() == 200){
//                                Glide.with(PublishVideoActivity.this).load(upLoadBean.getData().getUrl()).into(img);
                                showToast("发布成功");
                                finish();
                            }else {
                                Toast.makeText(PublishVideoActivity.this,upLoadBean.getCode(),Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(PublishVideoActivity.this,"错误",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
    private void choiceVideo() {
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        i.setType("video/*"); //选择视频
        startActivityForResult(i, 66);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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
        if (requestCode == 66 && resultCode == RESULT_OK && null != data) {
            Uri selectedVideo = data.getData();
            String[] filePathColumn = {MediaStore.Video.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedVideo,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            VIDEOPATH = cursor.getString(columnIndex);
            String image = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
            cursor.close();
            Glide.with(PublishVideoActivity.this).load(image).into(mIvAddVideo);
            Log.e("video",VIDEOPATH);
            file = new File(VIDEOPATH);

        }
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

    }
}
