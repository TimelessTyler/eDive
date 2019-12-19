package com.example.edive.activity;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edive.R;
import com.example.edive.adapter.QuestionFeedbackAdapter;
import com.example.edive.frame.BaseMvpActivity;
import com.example.edive.local_utils.MediaLoader;
import com.example.edive.model.HomeModel;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.XXPermissions;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumConfig;
import com.yanzhenjie.album.AlbumFile;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        Album.initialize(AlbumConfig.newBuilder(PublishDynamicActivity.this).setAlbumLoader(new MediaLoader()).build());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(PublishDynamicActivity.this, 3);
        mRec.setLayoutManager(gridLayoutManager);
        adapter = new QuestionFeedbackAdapter(PublishDynamicActivity.this, list);
        mRec.setAdapter(adapter);
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

    }

    @OnClick({R.id.iv_back, R.id.bt_ok, R.id.tv_conversation, R.id.tv_location})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_back:
                break;
            case R.id.bt_ok:
                break;
            case R.id.tv_conversation:
                break;
            case R.id.tv_location:
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
}
