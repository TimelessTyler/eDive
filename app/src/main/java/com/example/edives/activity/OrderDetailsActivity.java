package com.example.edives.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.edives.R;
import com.example.edives.bean.ApplyBean;
import com.example.edives.bean.CompletedBean;
import com.example.edives.bean.OrderDetailsBean;
import com.example.edives.design.GlideRoundTransform;
import com.example.edives.design.RoundImage;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.local_utils.TimeUtils;
import com.example.edives.local_utils.TimesUtils;
import com.example.edives.model.ShoppingModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class OrderDetailsActivity extends BaseMvpActivity<ShoppingModel> {

    @BindView(R.id.iv_tk)
    ImageView mIvTk;
    @BindView(R.id.tv_order)
    TextView mTvOrder;
    @BindView(R.id.tv_Destials)
    TextView mTvDestials;
    @BindView(R.id.rl_1)
    RelativeLayout mRl1;
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
    @BindView(R.id.tv_order_num)
    TextView mTvOrderNum;
    @BindView(R.id.tv_pay_num)
    TextView mTvPayNum;
    @BindView(R.id.tv_pay_other)
    TextView mTvPayOther;
    @BindView(R.id.tv_pay_time)
    TextView mTvPayTime;
    @BindView(R.id.ll2)
    LinearLayout mLl2;
    @BindView(R.id.tv_picse_all)
    TextView mTvPicseAll;
    @BindView(R.id.tv_integral_num)
    TextView mTvIntegralNum;
    @BindView(R.id.tv_pisce_blue)
    TextView mTvPisceBlue;
    @BindView(R.id.ll)
    LinearLayout mLl;
    @BindView(R.id.bt_ok)
    Button mBtOk;
//    @BindView(R.id.bt_nook)
//    Button mBtNook;
    @BindView(R.id.rl_tk)
    RelativeLayout mRlTk;
    private String order;
    private int status;
    private String orderSn;
    private OrderDetailsBean.ResultBean result;
    private CountDownTimer countDownTimer;
    private int productType;
    private int returnStatus;
    private double payAmount;
    private int orderId;

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
        return R.layout.activity_order_details;
    }

    @Override
    public void initView() {
        productType = getIntent().getExtras().getInt("productType");
        order = getIntent().getStringExtra("order");
        status = getIntent().getExtras().getInt("status");
//        if (productType == 3||productType==4) {
//            mRlTk.setVisibility(View.GONE);
//        }

        if (status == 1) {
            mTvOrder.setText("订单已付款");
            mBtOk.setText("申请退款");
            mTvDestials.setVisibility(View.GONE);
            mRlTk.setVisibility(View.GONE);
        } else if (status == 2) {
            mTvOrder.setText("订单进行中");
            mBtOk.setText("确认完成");
            mTvDestials.setVisibility(View.GONE);
            mRlTk.setVisibility(View.GONE);
        } else if (status == 3) {
            mTvOrder.setText("订单已完成");
            mBtOk.setText("评价");
            mTvDestials.setVisibility(View.GONE);
            mRlTk.setVisibility(View.GONE);
        } else if (status == 6) {
            mTvOrder.setText("订单退款中");
//            mBtOk.setText("退款进度");
            mTvDestials.setVisibility(View.VISIBLE);
        } else if (status == 0) {
            mTvOrder.setText("订单未付款");
            mBtOk.setText("付款");
            mTvPayOther.setVisibility(View.GONE);
        } else if (status == 5) {
            mTvOrder.setText("订单退款中");
//            mBtOk.setText("退款进度");

        }
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.ORDER_DETAILS,order);
    }

    @Override
    public ShoppingModel getModel() {
        return new ShoppingModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        showToast(e.getMessage());
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi){
            case ApiConfig.ORDER_DETAILS:
                OrderDetailsBean bean = (OrderDetailsBean) t[0];
                if (bean.getCode() == 200) {
                    result = bean.getResult();
                    returnStatus = result.getReturnStatus();
                    if (returnStatus == 0&&status==5) {
                        mRlTk.setVisibility(View.VISIBLE);
                    } else if (returnStatus == 3) {
                        mTvOrder.setText("审核未通过");
                    }
                    orderSn = result.getOrderSn();
                    mTvCoName.setText(result.getNickName()+"");
                    mTvCoDj.setText("V"+result.getCoachGrade());
                    Glide.with(OrderDetailsActivity.this).load(result.getUserIcon()).placeholder(R.mipmap.bg).into(mIvCoShow);
                    Glide.with(OrderDetailsActivity.this).load(result.getProductPic()).transform(new CenterCrop(),new GlideRoundTransform(OrderDetailsActivity.this,5)).placeholder(R.mipmap.bg).into(mIvShow);
                    mTvPicse.setText("￥"+ result.getTotalAmount());
                    mTvPicseAll.setText("￥"+ result.getTotalAmount());
                    mTvIntegralNum.setText("￥"+ result.getIntegrationAmount());
                    payAmount = result.getPayAmount();
                    orderId = result.getOrderId();
                    mTvPisceBlue.setText("￥"+ result.getPayAmount());
                    mTvOrderNum.setText(result.getOrderSn());
                    mTvPayNum.setText("￥"+ result.getPayAmount());
                    mTvPayTime.setText(result.getCreatedTime());
                    mTvText.setText(result.getProductTitle()+"");
                    String createdTime = result.getCreatedTime();
                    String returnApplyTime = result.getReturnApplyTime();
                    String s4 = TimesUtils.addDateMinut(returnApplyTime, 24);
                    String date = TimeUtils.getStringDate();
                    int compare_date = TimesUtils.compare_date(s4, date);
                    Long aLong = Long.getLong(createdTime);
                    if (returnStatus == 0) {
                        mTvDestials.setVisibility(View.VISIBLE);
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        try
                        {
                            Date d1 = df.parse(s4);
                            Date d2 = df.parse(date);
                            long diff = d1.getTime() - d2.getTime();//这样得到的差值是毫秒级别
                            if (diff > 0) {
                                long days = diff / (1000 * 60 * 60 * 24);

                                long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
                                long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
                                mTvDestials.setText(hours + "小时" + minutes + "分钟自动确认");
                            }else {
                                mTvDestials.setVisibility(View.GONE);
                            }

                        }catch (Exception e)
                        {
                        }
                    }


//                    mTvDestials.setText("还剩23小时45分自动确认");
                    int payType = result.getPayType();
                    if (payType == 1) {
                        mTvPayOther.setText("支付宝支付");
                    } else if (payType == 2) {
                        mTvPayOther.setText("微信支付");
                    } else if (payType == 3) {

                        mTvPayOther.setText("积分支付");
                        if (productType == 4) {
                            mRl.setVisibility(View.GONE);
                            mRl2.setVisibility(View.GONE);
                            double payAmount = result.getPayAmount();
                            double productPrice = result.getProductPrice();
                            String s2 = String.valueOf(productPrice);
                            String s = String.valueOf(payAmount);
                            String s1 = subZeroAndDot(s);
                            String s3 = subZeroAndDot(s2);
                            mTvPicseAll.setText(s1+"积分");
                            mTvPisceBlue.setText(s1+"积分");
                            mTvIntegralNum.setText(s1+"积分");
                            mTvPayNum.setText(s1+"积分");
                        }
                    } else if (payType == 0) {
                        mTvPayOther.setText("未支付");
                    }


                }else {
                    showToast(bean.getCode()+":"+bean.getMessage());
                }
                break;
            case ApiConfig.COMPLETEDORDER:
                CompletedBean completedBean = (CompletedBean) t[0];
                if (completedBean.getCode() == 200) {
                    showToast(completedBean.getMessage());
                    finish();
                }else {
                    showToast(completedBean.getMessage());
                }
                break;
            case ApiConfig.APPLKCOMIND:
                ApplyBean applyBean = (ApplyBean) t[0];
                if (applyBean.getCode() == 200) {
                    showToast(applyBean.getMessage());
                    finish();
                }
                break;
        }
    }

    @OnClick({R.id.bt_ok})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_ok:
                //进度
                if (returnStatus == 3) {
                    Intent intent = new Intent(OrderDetailsActivity.this, AuditFailedActivity.class);
                    intent.putExtra("orderid",order);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(OrderDetailsActivity.this, RefundscheduleActivity.class);
                    intent.putExtra("orderid",order);
                    startActivity(intent);
                    finish();
                }

//                MediaType type = MediaType.parse("application/json;charset=UTF-8");
//                JSONObject jsonObject = new JSONObject();
//                try {
//                    jsonObject.put("status", 1);
//                    jsonObject.put("returnApplyId", orderId);
//                    jsonObject.put("returnAmount", payAmount);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                String string = jsonObject.toString();
//                RequestBody body = RequestBody.create(type, string);
//                mPresenter.getData(ApiConfig.APPLKCOMIND,body);
                break;
//            case R.id.bt_nook:
//                //拒绝
//
//                break;
        }
    }
    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }
}
