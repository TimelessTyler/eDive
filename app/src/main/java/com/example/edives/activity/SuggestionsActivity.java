package com.example.edives.activity;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edives.R;
import com.example.edives.adapter.QuestionFeedbackAdapter;
import com.example.edives.adapter.RlvSuggestAdapter;
import com.example.edives.bean.SuggestBean;
import com.example.edives.bean.SuggestTiBean;
import com.example.edives.bean.UpLoadBean;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseApplication;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.local_utils.MediaLoader;
import com.example.edives.local_utils.StringUtils;
import com.example.edives.model.PersonModel;
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

public class SuggestionsActivity extends BaseMvpActivity<PersonModel> {

    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.tv_numss)
    TextView mTvNumss;
    @BindView(R.id.ed_text)
    EditText mEdText;
    @BindView(R.id.rec_photo)
    RecyclerView mRecPhoto;
    @BindView(R.id.bt_ok)
    Button mBtOk;
    private PopupWindow popupWindow;
    private ArrayList<SuggestBean.DataBean> list;
    private RlvSuggestAdapter adapter;
    private int id;
    private ArrayList<String> photolist;
    private QuestionFeedbackAdapter adapters;
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
        return R.layout.activity_suggestions;
    }

    @Override
    public void initView() {
        getPermission();
        PicList = new ArrayList<>();
        list = new ArrayList<>();
        photolist = new ArrayList<>();
        Album.initialize(AlbumConfig.newBuilder(SuggestionsActivity.this).setAlbumLoader(new MediaLoader()).build());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(SuggestionsActivity.this, 3);
        mRecPhoto.setLayoutManager(gridLayoutManager);
        adapters = new QuestionFeedbackAdapter(SuggestionsActivity.this, photolist);
        mRecPhoto.setAdapter(adapters);
        adapters.setonclick(new QuestionFeedbackAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                photolist.remove(pos);
                PicList.remove(pos);
                adapters.notifyDataSetChanged();
            }
        });
        adapters.setOnItemClickListener(new QuestionFeedbackAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                initAlbum();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SuggestionsActivity.this);
        mRec.setLayoutManager(linearLayoutManager);
        adapter = new RlvSuggestAdapter(SuggestionsActivity.this, list);
        mRec.setAdapter(adapter);
        adapter.setonclick(new RlvSuggestAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                id = list.get(pos).getId();
//                showToast(id + "");

            }
        });
        mEdText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = s.length();
                if (length > 200) {
                    showToast("不能超过200字");
                    hideInput();
                    mTvNumss.setText("200/200");
                }else {

                }
                mTvNumss.setText(length+"/200");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initAlbum() {
        Album.image(SuggestionsActivity.this)
                .multipleChoice()
                .camera(true)
                .columnCount(3)
                .selectCount(3)
                .onResult(new Action<ArrayList<AlbumFile>>() {
                    @Override
                    public void onAction(@NonNull ArrayList<AlbumFile> result) {
                        for (int i = 0; i < result.size(); i++) {
                            String path = result.get(i).getPath();
                            photolist.add(path);
                        }
                        adapters.notifyDataSetChanged();
                        initapp();
                    }
                }).onCancel(new Action<String>() {
            @Override
            public void onAction(@NonNull String result) {
//                finish();
            }
        }).start();
    }
    protected void hideInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        View v = getWindow().peekDecorView();
        if (null != v) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }


    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.SUGGEST);
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
        switch (whichApi) {
            case ApiConfig.SUGGEST:
                SuggestBean suggestBean = (SuggestBean) t[0];
                if (suggestBean.getCode() == 200) {
                    List<SuggestBean.DataBean> data = suggestBean.getData();
                    list.addAll(data);
                    adapter.notifyDataSetChanged();
                } else {
                    showToast(suggestBean.getMessage());
                }
                break;
            case ApiConfig.TIJIAOYIJIAN:
                SuggestTiBean suggestTiBean = (SuggestTiBean) t[0];
                if (suggestTiBean.getCode() == 200) {
                    showToast(suggestTiBean.getMessage());
                    finish();
                } else {
                    showToast(suggestTiBean.getMessage());
                }
                break;

        }
    }

    @OnClick(R.id.bt_ok)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_ok:
                if (id == 0) {
                    showToast("请选择你想要反馈的问题类型");
                }else {
                    String s = mEdText.getText().toString();
                    if (!TextUtils.isEmpty(s)) {
                        String join = StringUtils.join(PicList, ",");
                        MediaType type = MediaType.parse("application/json;charset=UTF-8");
                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put("picture", join);
                            jsonObject.put("problemDescription", mEdText.getText().toString());
                            jsonObject.put("problemId", id);
                            jsonObject.put("userId", mApplication.userid);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String strings = jsonObject.toString();
                        RequestBody body = RequestBody.create(type, strings);
                        mPresenter.getData(ApiConfig.TIJIAOYIJIAN, body);
                    }else {
                        showToast("内容不能为空");
                    }

                }
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
    private void initapp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();
        for (int i = 0; i < photolist.size(); i++) {

            /**
             * 封装文件上传的  请求体
             */
            File file = new File(photolist.get(i));
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
                                    PicList.add(data);
                                    if (photolist.size() == PicList.size()) {


                                    }
                                } else {
//                                            Toast.makeText(PublishDynamicActivity.this,upLoadBean.getCode(),Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(SuggestionsActivity.this, "错误", Toast.LENGTH_SHORT).show();
                            }


                        }
                    });
                }
            });
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        id = 0;
    }
}
