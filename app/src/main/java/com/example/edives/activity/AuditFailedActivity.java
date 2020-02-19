package com.example.edives.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.edives.R;
import com.example.edives.adapter.RlvRefundAdapter;
import com.example.edives.bean.ApplyBean;
import com.example.edives.bean.ApplyDeatilsBean;
import com.example.edives.bean.OrderDetailsBean;
import com.example.edives.design.GlideRoundTransform;
import com.example.edives.design.RoundImage;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.local_utils.TimeUtils;
import com.example.edives.local_utils.TimesUtils;
import com.example.edives.model.ShoppingModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AuditFailedActivity extends BaseMvpActivity<ShoppingModel> {

    @BindView(R.id.iv_tk)
    ImageView mIvTk;
    @BindView(R.id.tv_order)
    TextView mTvOrder;
    @BindView(R.id.tv_Destials)
    TextView mTvDestials;
    @BindView(R.id.rl_1)
    RelativeLayout mRl1;
    @BindView(R.id.tv_order_num)
    TextView mTvOrderNum;
    @BindView(R.id.rl2)
    RelativeLayout mRl2;
    @BindView(R.id.iv_show)
    ImageView mIvShow;
    @BindView(R.id.iv_co_show)
    RoundImage mIvCoShow;
    @BindView(R.id.tv_co_name)
    TextView mTvCoName;
    @BindView(R.id.tv_co_dj)
    TextView mTvCoDj;
    @BindView(R.id.tv_picse)
    TextView mTvPicse;
    @BindView(R.id.tv_text)
    TextView mTvText;
    @BindView(R.id.rl)
    RelativeLayout mRl;
    @BindView(R.id.viewt)
    View mViewt;
    @BindView(R.id.rl_baoming)
    RelativeLayout mRlBaoming;
    @BindView(R.id.tv_return_text)
    TextView mTvReturnText;
    @BindView(R.id.ll2)
    LinearLayout mLl2;
    private String orderid;
    private OrderDetailsBean.ResultBean result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.app_setting));
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_audit_failed;
    }

    @Override
    public void initView() {
        orderid = getIntent().getStringExtra("orderid");
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.ORDER_DETAILS,orderid);
        mPresenter.getData(ApiConfig.APPLYDEATILS,orderid);
    }

    @Override
    public ShoppingModel getModel() {
        return new ShoppingModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi){
            case ApiConfig.APPLYDEATILS:
                ApplyDeatilsBean applyDeatilsBean = (ApplyDeatilsBean) t[0];
                if (applyDeatilsBean.getCode() == 200) {
                    ApplyDeatilsBean.ResultBean results = applyDeatilsBean.getResult();
                    mTvOrderNum.setText("订单编号："+results.getOrderSn());
                    mTvReturnText.setText(results.getFailureReason());
                }
                break;
            case ApiConfig.ORDER_DETAILS:
                OrderDetailsBean bean = (OrderDetailsBean) t[0];
                if (bean.getCode() == 200) {
                    result = bean.getResult();
                    mTvCoName.setText(result.getNickName()+"");
//                    mTvCoDj.setText("V"+result.getCoachGrade());
                    Glide.with(AuditFailedActivity.this).load(result.getUserIcon()).placeholder(R.mipmap.bg).into(mIvCoShow);
                    Glide.with(AuditFailedActivity.this).load(result.getProductPic()).transform(new CenterCrop(),new GlideRoundTransform(AuditFailedActivity.this,5)).placeholder(R.mipmap.bg).into(mIvShow);
                    mTvText.setText(result.getProductTitle()+"");
                    mTvPicse.setText("￥"+result.getPayAmount());

                }else {
                    showToast(bean.getCode()+":"+bean.getMessage());
                }
                break;
        }
    }
}
