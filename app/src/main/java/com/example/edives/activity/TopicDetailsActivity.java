package com.example.edives.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.edives.R;
import com.example.edives.adapter.VpTopicDetailsAdapter;
import com.example.edives.bean.FollowBean;
import com.example.edives.bean.NotFollowBean;
import com.example.edives.bean.TopicByIdBean;
import com.example.edives.fragment.HotDetailsFragment;
import com.example.edives.fragment.NewDynamicDetailsFragment;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.HomeModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class TopicDetailsActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.iv_show)
    ImageView mIvShow;
    @BindView(R.id.tv_topic_name)
    TextView mTvTopicName;
    @BindView(R.id.tv_topic_num)
    TextView mTvTopicNum;
    @BindView(R.id.tv_topic_text)
    TextView mTvTopicText;
    @BindView(R.id.iv_share)
    ImageView mIvShare;
    @BindView(R.id.iv_like)
    ImageView mIvLike;
    @BindView(R.id.iv_nolike)
    ImageView mIvNolike;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tb)
    Toolbar mTb;
    @BindView(R.id.colltb)
    CollapsingToolbarLayout mColltb;
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.appBar)
    AppBarLayout mAppBar;
    @BindView(R.id.vp)
    ViewPager mVp;

    private ArrayList<Fragment> fs;
    private VpTopicDetailsAdapter vpTopicDetailsAdapter;
    private int pos;
    private ArrayList<TopicByIdBean.DataBean> list;
    private List<TopicByIdBean.DataBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeStatusBarTransparent(TopicDetailsActivity.this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_topic_details;
    }

    @Override
    public void initView() {
        pos = getIntent().getExtras().getInt("id");
        list = new ArrayList<>();


        fs = new ArrayList<>();
        String userid = mApplication.userid;
        fs.add(new NewDynamicDetailsFragment(pos, userid));
        fs.add(new HotDetailsFragment(pos, userid));
        mTb.setTitle("");
        setSupportActionBar(mTb);
        mTab.addTab(mTab.newTab().setText("最新动态"));
        mTab.addTab(mTab.newTab().setText("最热动态"));
        vpTopicDetailsAdapter = new VpTopicDetailsAdapter(getSupportFragmentManager(), fs);
        mVp.setAdapter(vpTopicDetailsAdapter);
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
        mTab.setTabIndicatorFullWidth(false);

        mColltb.setTitle("");
        mColltb.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        mColltb.setExpandedTitleColor(getResources().getColor(R.color.white));
//        mColltb.addonoff
        mAppBar.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (state == State.EXPANDED) {

                    //展开状态
                    mTb.setTitle("");
                    mColltb.setTitle("");
                } else if (state == State.COLLAPSED) {
                    //折叠状态
                    mTb.setTitle(data.get(0).getTopicName());
                } else {
                    //中间状态
                    mTb.setTitle("");

                }
            }
        });
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.TOPICDESTIO_DATA, pos);
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
            case ApiConfig.TOPICDESTIO_DATA:
                TopicByIdBean bean = (TopicByIdBean) t[0];
                data = bean.getData();
//                mTb.setTitle(data.get(0).getTopicName());

                for (int d = 0; d < data.size(); d++) {
                    mTvTopicName.setText("#"+ data.get(d).getTopicName()+"#");
                    mTvTopicNum.setText(data.get(d).getTopicNum()+"动态");
                    mTvTopicText.setText(data.get(d).getTopicDescribes());
                    Glide.with(TopicDetailsActivity.this).load(data.get(d).getTopicPicture()).placeholder(R.mipmap.bg).into(mIvShow);
                    if (data.get(d).getIdentification() == 0) {
                        mIvLike.setVisibility(View.GONE);
                        mIvNolike.setVisibility(View.VISIBLE);
                    }else if (data.get(d).getIdentification()==1){
                        mIvNolike.setVisibility(View.GONE);
                        mIvLike.setVisibility(View.VISIBLE);
                    }
                }
                break;
            case ApiConfig.FOLLOWUSER:
                FollowBean followBean = (FollowBean) t[0];
                if (followBean.getCode() == 200) {
                    showToast("收藏成功");
                    mIvNolike.setVisibility(View.GONE);
                    mIvLike.setVisibility(View.VISIBLE);
                } else if (followBean.getCode() == 500) {
                    showToast(followBean.getMessage());
                }
                break;
            case ApiConfig.NOTFOLLOWS:
                NotFollowBean notFollowBean = (NotFollowBean) t[0];
                if (notFollowBean.getCode() == 200) {
                    showToast("取消收藏");
                    mIvLike.setVisibility(View.GONE);
                    mIvNolike.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    @OnClick({R.id.iv_share, R.id.iv_like, R.id.iv_nolike, R.id.iv_back})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_share:
                break;
            case R.id.iv_like:
                //收藏话题
                int ids = data.get(0).getId();
                MediaType types = MediaType.parse("application/json;charset=UTF-8");
                JSONObject jsonObjects = new JSONObject();
                try {
                    jsonObjects.put("favoriteType", 6);
                    jsonObjects.put("status", 2);
                    jsonObjects.put("targetId", ids);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String strings = jsonObjects.toString();
                RequestBody bodys = RequestBody.create(types, strings);
                mPresenter.getData(ApiConfig.NOTFOLLOWS,bodys);
                break;
            case R.id.iv_nolike:
                int id = data.get(0).getId();
                MediaType type = MediaType.parse("application/json;charset=UTF-8");
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("favoriteType", 6);
                    jsonObject.put("status", 1);
                    jsonObject.put("targetId", id);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String string = jsonObject.toString();
                RequestBody body = RequestBody.create(type, string);
                mPresenter.getData(ApiConfig.FOLLOWUSER,body);
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }

    //沉浸式状态栏
    public static void makeStatusBarTransparent(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int option = window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            window.getDecorView().setSystemUiVisibility(option);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getData(ApiConfig.TOPICDESTIO_DATA, pos);
    }

    public abstract static class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {
        public enum State {
            EXPANDED,
            COLLAPSED,
            IDLE
        }

        private State mCurrentState = State.IDLE;

        @Override
        public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (i == 0) {
                if (mCurrentState != State.EXPANDED) {
                    onStateChanged(appBarLayout, State.EXPANDED);
                }
                mCurrentState = State.EXPANDED;
            } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
                if (mCurrentState != State.COLLAPSED) {
                    onStateChanged(appBarLayout, State.COLLAPSED);
                }
                mCurrentState = State.COLLAPSED;
            } else {
                if (mCurrentState != State.IDLE) {
                    onStateChanged(appBarLayout, State.IDLE);
                }
                mCurrentState = State.IDLE;
            }
        }

        public abstract void onStateChanged(AppBarLayout appBarLayout, State state);
    }
}
