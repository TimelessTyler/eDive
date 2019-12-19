package com.example.edive.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.edive.R;
import com.example.edive.activity.SettingActivity;
import com.example.edive.design.RoundOrCircleImage;
import com.example.edive.frame.BaseMvpFragment;
import com.example.edive.model.PersonModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends BaseMvpFragment<PersonModel> {


    @BindView(R.id.iv_setting)
    ImageView mIvSetting;
    @BindView(R.id.iv_show)
    RoundOrCircleImage mIvShow;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.ll_coachgral)
    LinearLayout mLlCoachgral;
    @BindView(R.id.tv_xueyuan)
    TextView mTvXueyuan;
    @BindView(R.id.tv_student_num)
    TextView mTvStudentNum;
    @BindView(R.id.tv_yifabu)
    TextView mTvYifabu;
    @BindView(R.id.iv_not)
    ImageView mIvNot;
    @BindView(R.id.tv_like_num)
    TextView mTvLikeNum;
    @BindView(R.id.tv_fb_num)
    TextView mTvFbNum;
    @BindView(R.id.rl_myorder)
    RelativeLayout mRlMyorder;
    @BindView(R.id.rl_myshenghe)
    RelativeLayout mRlMyshenghe;
    @BindView(R.id.rl_mydynamic)
    RelativeLayout mRlMydynamic;
    @BindView(R.id.rl_mywallet)
    RelativeLayout mRlMywallet;
    @BindView(R.id.rl_myclub)
    RelativeLayout mRlMyclub;
    private View view;
    private Unbinder unbinder;

    public PersonalFragment() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
////        return inflater.inflate(, container, false);
//    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

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

    }


    @OnClick({R.id.iv_setting, R.id.iv_show, R.id.tv_name, R.id.ll_coachgral, R.id.tv_xueyuan, R.id.tv_student_num, R.id.tv_like_num, R.id.tv_fb_num, R.id.rl_myorder, R.id.rl_myshenghe, R.id.rl_mydynamic, R.id.rl_mywallet, R.id.rl_myclub})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_setting:
                //设置
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
            case R.id.iv_show:
                //头像
                break;
            case R.id.tv_name:
                //名称
                break;
            case R.id.ll_coachgral:
                //教练等级
                break;
            case R.id.tv_xueyuan:
                //
                break;
            case R.id.tv_student_num:
                //学员数
                break;
            case R.id.tv_like_num:
                //关注
                break;
            case R.id.tv_fb_num:
                //发布
                break;
            case R.id.rl_myorder:
                //订单
                break;
            case R.id.rl_myshenghe:
                //审核
                break;
            case R.id.rl_mydynamic:
                //动态
                break;
            case R.id.rl_mywallet:
                //钱包
                break;
            case R.id.rl_myclub:
                //俱乐部
                break;
        }
    }
}
