package com.example.edives.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.edives.R;
import com.example.edives.activity.AttentionActivity;
import com.example.edives.activity.MyDynamicDetailsPersonActivity;
import com.example.edives.activity.MyOrder;
import com.example.edives.activity.MyauditActivity;
import com.example.edives.activity.MytraineeActivity;
import com.example.edives.activity.PersonalDataActivity;
import com.example.edives.activity.SettingActivity;
import com.example.edives.bean.PersonalMessagerBean;
import com.example.edives.design.RoundOrCircleImage;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpFragment;
import com.example.edives.model.PersonModel;

import butterknife.BindView;
import butterknife.OnClick;

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
    @BindView(R.id.tv_guanz)
    TextView mTvGuanz;
    @BindView(R.id.iv_not)
    ImageView mIvNot;
    @BindView(R.id.tv_like_num)
    TextView mTvLikeNum;
    @BindView(R.id.tv_fb_num)
    TextView mTvFbNum;
    @BindView(R.id.tv_grade)
    TextView MtvGrade;
    @BindView(R.id.tv_invitationcode)
    TextView MtvInitationCode;
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
    @Override
    public void onHiddenChanged(boolean hidden) {
        // TODO Auto-generated method stub
        super.onHiddenChanged(hidden);
        if (!hidden) {
            mPresenter.getData(ApiConfig.PERSONALMESSAGER);
        }
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        showLoadingDialog();
        mPresenter.getData(ApiConfig.PERSONALMESSAGER);
    }

    @Override
    public PersonModel getModel() {
        return new PersonModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
            showToast(e.getMessage());
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        hideLoadingDialog();
        switch (whichApi){
            case ApiConfig.PERSONALMESSAGER:
                PersonalMessagerBean personalMessagerBean = (PersonalMessagerBean) t[0];
                if (personalMessagerBean.getCode() == 200) {
                    PersonalMessagerBean.ResultBean result = personalMessagerBean.getResult();
                    String name = result.getNickName();
                    String icon = result.getIcon();
                    String grade = result.getCoachGrade();
                    int totalInvitations = result.getTotalInvitations();
                    int totalFollow = result.getTotalFollow();
                    int totalProduct = result.getTotalProduct();
                    mTvName.setText(name);
                    mTvLikeNum.setText(totalFollow+"");
                    MtvGrade.setText("V"+grade+"教练");
                    mTvStudentNum.setText(totalInvitations+"");
                    mTvFbNum.setText(totalProduct+"");
                    Glide.with(getActivity()).load(icon).error(R.mipmap.morentouxiang).placeholder(R.mipmap.morentouxiang).into(mIvShow);
                    MtvInitationCode.setText("邀请码："+result.getInvitationCode());
                }else {
                    showToast(personalMessagerBean.getMessage());
                }
                break;
        }
    }


    @OnClick({R.id.iv_setting,R.id.tv_guanz, R.id.iv_show, R.id.tv_name, R.id.ll_coachgral, R.id.tv_xueyuan, R.id.tv_student_num, R.id.tv_like_num, R.id.tv_fb_num, R.id.rl_myorder, R.id.rl_myshenghe, R.id.rl_mydynamic, R.id.rl_mywallet, R.id.rl_myclub})
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
                startActivity(new Intent(getActivity(), PersonalDataActivity.class));
                break;
            case R.id.tv_name:
                //名称
                startActivity(new Intent(getActivity(), PersonalDataActivity.class));
                break;
            case R.id.ll_coachgral:
                //教练等级

                break;
            case R.id.tv_xueyuan:
                //
                startActivity(new Intent(getActivity(), MytraineeActivity.class));
                break;
            case R.id.tv_student_num:
                //学员数
                startActivity(new Intent(getActivity(), MytraineeActivity.class));
                break;
            case R.id.tv_guanz:
                //关注
                startActivity(new Intent(getActivity(), AttentionActivity.class));
                break;
            case R.id.tv_like_num:
                //关注
                startActivity(new Intent(getActivity(), AttentionActivity.class));
                break;
            case R.id.tv_fb_num:
                //发布

                break;
            case R.id.rl_myorder:
                //订单
                startActivity(new Intent(getActivity(), MyOrder.class));
                break;
            case R.id.rl_myshenghe:
                //审核
                startActivity(new Intent(getActivity(), MyauditActivity.class));
                break;
            case R.id.rl_mydynamic:
                //动态
                startActivity(new Intent(getActivity(), MyDynamicDetailsPersonActivity.class));
                break;
            case R.id.rl_mywallet:
                //钱包

                break;
            case R.id.rl_myclub:
                //俱乐部
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getData(ApiConfig.PERSONALMESSAGER);
    }
}
