package com.example.edives.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.example.edives.R;
import com.example.edives.design.CommonTitle;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.HomeModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class ShowVideoActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.title)
    CommonTitle mTitle;
    @BindView(R.id.video)
    JCVideoPlayerStandard mVideo;
    private String video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.findpassword_bg));//设置颜色
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_show_video;
    }

    @Override
    public void initView() {
        video = getIntent().getStringExtra("video");
        mVideo.backButton.setVisibility(View.GONE);
        mVideo.tinyBackImageView.setVisibility(View.GONE);
        mVideo.setUp(video, JCVideoPlayer.SCREEN_LAYOUT_LIST);
        mVideo.startVideo();

        Glide.with(ShowVideoActivity.this).load(video).into(mVideo.thumbImageView);
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
}
