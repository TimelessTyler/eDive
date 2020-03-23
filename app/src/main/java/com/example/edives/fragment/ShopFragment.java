package com.example.edives.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.edives.R;
import com.example.edives.activity.MyOrder;
import com.example.edives.activity.OrderissueActivity;
import com.example.edives.activity.ShopSettingActivity;
import com.example.edives.frame.BaseMvpFragment;
import com.example.edives.model.ShopModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends BaseMvpFragment<ShopModel> {


    @BindView(R.id.iv_kefu)
    ImageView mIvKefu;
    @BindView(R.id.iv_show)
    ImageView mIvShow;
    @BindView(R.id.tv_shop_name)
    TextView mTvShopName;
    @BindView(R.id.tv_shop_fans)
    TextView mTvShopFans;
    @BindView(R.id.iv_shop_share)
    ImageView mIvShopShare;
    @BindView(R.id.tv_page_num)
    TextView mTvPageNum;
    @BindView(R.id.ll_jrll)
    LinearLayout mLlJrll;
    @BindView(R.id.tv_order_num)
    TextView mTvOrderNum;
    @BindView(R.id.ll_jrdds)
    LinearLayout mLlJrdds;
    @BindView(R.id.tv_order_picse)
    TextView mTvOrderPicse;
    @BindView(R.id.ll_jrddje)
    LinearLayout mLlJrddje;
    @BindView(R.id.ll_ddfb)
    LinearLayout mLlDdfb;
    @BindView(R.id.ll_ddgl)
    LinearLayout mLlDdgl;
    @BindView(R.id.ll_dpdt)
    LinearLayout mLlDpdt;
    @BindView(R.id.ll_ptsq)
    LinearLayout mLlPtsq;
    @BindView(R.id.ll_schy)
    LinearLayout mLlSchy;
    @BindView(R.id.ll_wdqb)
    LinearLayout mLlWdqb;
    @BindView(R.id.ll_shdd)
    LinearLayout mLlShdd;
    @BindView(R.id.ll_dpgl)
    LinearLayout mLlDpgl;
    @BindView(R.id.iv_xzxz)
    ImageView mIvXzxz;
    @BindView(R.id.iv_more)
    ImageView mIvMore;
    @BindView(R.id.tv_more)
    TextView mTvMore;
    @BindView(R.id.rec)
    RecyclerView mRec;



    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_shop;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public ShopModel getModel() {
        return new ShopModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @OnClick({R.id.iv_kefu,R.id.iv_shop_share, R.id.iv_show, R.id.tv_shop_name, R.id.tv_shop_fans, R.id.ll_jrll, R.id.ll_jrdds, R.id.ll_jrddje, R.id.ll_ddfb, R.id.ll_ddgl, R.id.ll_dpdt, R.id.ll_ptsq, R.id.ll_schy, R.id.ll_wdqb, R.id.ll_shdd, R.id.ll_dpgl, R.id.iv_more, R.id.tv_more})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
                //客服
            case R.id.iv_kefu:

                break;
                //店铺分享
            case R.id.iv_shop_share:

                break;
                //店铺照片
            case R.id.iv_show:
                startActivity(new Intent(getActivity(), ShopSettingActivity.class));
                break;
                //店铺名称
            case R.id.tv_shop_name:
                startActivity(new Intent(getActivity(), ShopSettingActivity.class));
                break;
                //粉丝
            case R.id.tv_shop_fans:
                break;
                //今日浏览
            case R.id.ll_jrll:
                break;
                //今日订单数
            case R.id.ll_jrdds:
                break;
                //今日订单金额
            case R.id.ll_jrddje:
                break;
                //订单发布
            case R.id.ll_ddfb:
                startActivity(new Intent(getActivity(), OrderissueActivity.class));
                break;
                //订单管理
            case R.id.ll_ddgl:
                startActivity(new Intent(getActivity(), MyOrder.class));
                break;
                //店铺动态
            case R.id.ll_dpdt:
                break;
                //平台社圈
            case R.id.ll_ptsq:
                break;
                //色彩还原
            case R.id.ll_schy:
                break;
                //我的钱包
            case R.id.ll_wdqb:
                break;
                //售后订单
            case R.id.ll_shdd:
                break;
                //店铺管理
            case R.id.ll_dpgl:
                break;
                //更多
            case R.id.iv_more:
                break;
                //更多
            case R.id.tv_more:
                break;
        }
    }
}
