package com.example.edive.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.edive.R;
import com.example.edive.adapter.RlvHomesAdapter;
import com.example.edive.bean.BannerInfo;
import com.example.edive.frame.ApiConfig;
import com.example.edive.frame.BaseMvpFragment;
import com.example.edive.model.HomeModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseMvpFragment<HomeModel> {


    @BindView(R.id.tv_te)
    TextView mTvTe;
    @BindView(R.id.iv_search)
    ImageView mIvSearch;
    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.iv_reduction)
    ImageView mIvReduction;
    @BindView(R.id.iv_integral)
    ImageView mIvIntegral;
    @BindView(R.id.iv_apply)
    ImageView mIvApply;
    @BindView(R.id.iv_divinglog)
    ImageView mIvDivinglog;
    @BindView(R.id.ll)
    LinearLayout mLl;
    @BindView(R.id.tv_color)
    TextView mTvColor;
    @BindView(R.id.tv_jif)
    TextView mTvJif;
    @BindView(R.id.tv_nero)
    TextView mTvNero;
    @BindView(R.id.tv_topic_all)
    TextView mTvTopicAll;
    @BindView(R.id.rl)
    RelativeLayout mRl;
    @BindView(R.id.rec_class)
    RecyclerView mRecClass;
    @BindView(R.id.home_tabs)
    TabLayout mHomeTabs;
    @BindView(R.id.homevp)
    ViewPager mHomevp;
    private ArrayList<BannerInfo.DataBean> list;
    private RlvHomesAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRec.setLayoutManager(linearLayoutManager);
        adapter = new RlvHomesAdapter(getActivity(), list);
        mRec.setAdapter(adapter);

    }

    @Override
    public void initData() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        String time = simpleDateFormat.format(date);
        MediaType type = MediaType.parse("application/json;charset=UTF-8");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("startTime", time);
            jsonObject.put("endTime", time);
            jsonObject.put("type", "1");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String string = jsonObject.toString();
        RequestBody body = RequestBody.create(type, string);
        mPresenter.getData(ApiConfig.HomeTest_DATA, body);
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
            case ApiConfig.HomeTest_DATA:
                BannerInfo bean = (BannerInfo) t[0];
                if (bean.getCode() == 200) {
                    List<BannerInfo.DataBean> results = bean.getData();
                    list.addAll(results);
                    adapter.notifyDataSetChanged();
                }else {
                    showToast(bean.getMessage());
                }
                break;
        }
    }

    @OnClick({R.id.iv_search, R.id.tv_topic_all, R.id.iv_reduction, R.id.iv_integral, R.id.iv_apply, R.id.iv_divinglog})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_search:

                break;
            case R.id.iv_reduction:

                break;
            case R.id.iv_integral:

                break;
            case R.id.iv_apply:

                break;
            case R.id.iv_divinglog:

                break;
            case R.id.tv_topic_all:

                break;
        }
    }
}
