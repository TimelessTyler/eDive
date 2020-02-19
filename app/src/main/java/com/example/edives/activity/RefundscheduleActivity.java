package com.example.edives.activity;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RefundscheduleActivity extends BaseMvpActivity<ShoppingModel> {

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
    @BindView(R.id.tv_state)
    TextView mTvState;
    @BindView(R.id.tv_picse)
    TextView mTvPicse;
    @BindView(R.id.tv_text)
    TextView mTvText;
    @BindView(R.id.rl)
    RelativeLayout mRl;
    @BindView(R.id.tv_tkje)
    TextView mTvTkje;
    @BindView(R.id.tv_tk_num)
    TextView mTvTkNum;
    @BindView(R.id.rl3)
    RelativeLayout mRl3;
    @BindView(R.id.viewt)
    View mViewt;
    @BindView(R.id.rl_baoming)
    RelativeLayout mRlBaoming;
    @BindView(R.id.tv_tk_yy)
    TextView mTvTkYy;
    @BindView(R.id.tv_pay_num)
    TextView mTvPayNum;
    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.ll2)
    LinearLayout mLl2;
    @BindView(R.id.tv_jj)
    TextView mTvJj;
    @BindView(R.id.et_return)
    EditText mEtReturn;
    @BindView(R.id.bt_ok)
    Button mBtOk;
    @BindView(R.id.bt_nook)
    Button mBtNook;
    @BindView(R.id.rl_tk)
    LinearLayout mRlTk;
    @BindView(R.id.rl_return)
    RelativeLayout mRlreturn;
    private String orderid;
    private OrderDetailsBean.ResultBean result;
    private RlvRefundAdapter rlvRefundAdapter;
    private CountDownTimer countDownTimer;
    private int returnApplyId;
    private double returnAmount;

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
        return R.layout.activity_refundschedule;
    }

    @Override
    public void initView() {
        orderid = getIntent().getStringExtra("orderid");
        getWindow().setSoftInputMode(WindowManager.LayoutParams. SOFT_INPUT_ADJUST_PAN);
        mEtReturn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = s.length();
                if (length == 200) {
                    showToast("最多输入200字");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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
                    int status1 = applyDeatilsBean.getResult().getStatus();
                    if (status1 == 1) {
                        mTvOrder.setText("订单退款中");
                    }
                    ApplyDeatilsBean.ResultBean results = applyDeatilsBean.getResult();
                    returnAmount = results.getReturnAmount();
                    returnApplyId = results.getReturnApplyId();
                    mTvTkYy.setText(results.getReason());
                    String description = results.getDescription();
                    mTvPayNum.setText(description);
                    mTvTkNum.setText("￥"+results.getReturnAmount()+"");
                    List<String> picList = results.getPicList();
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(RefundscheduleActivity.this, 3);
                    mRec.setLayoutManager(gridLayoutManager);
                    rlvRefundAdapter = new RlvRefundAdapter(RefundscheduleActivity.this, picList);
                    mRec.setAdapter(rlvRefundAdapter);
                    rlvRefundAdapter.notifyDataSetChanged();
                    String createdTime = results.getCreatedTime();
                    String s4 = TimesUtils.addDateMinut(createdTime, 24);
                    String date = TimeUtils.getStringDate();
                    int status = results.getStatus();
                    if (status == 0) {
                        mRlTk.setVisibility(View.VISIBLE);
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        try
                        {
                            Date d1 = df.parse(s4);
                            Date d2 = df.parse(date);
                            long diff = d1.getTime() - d2.getTime();//这样得到的差值是毫秒级别
                            long days = diff / (1000 * 60 * 60 * 24);

                            long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
                            long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
                            mTvDestials.setText(hours + "小时" + minutes + "分钟自动确认");
                        }catch (Exception e)
                        {
                        }
                    } else if (status == 1) {
                        mTvDestials.setVisibility(View.GONE);
                        mRlTk.setVisibility(View.GONE);
                        mRlreturn.setVisibility(View.GONE);
                    } else if (status == 3) {
                        mRlTk.setVisibility(View.GONE);
                        mTvOrder.setText("订单退款中");
                    }

                }
                break;
            case ApiConfig.ORDER_DETAILS:
                OrderDetailsBean bean = (OrderDetailsBean) t[0];
                if (bean.getCode() == 200) {
                    result = bean.getResult();
                    mTvCoName.setText(result.getNickName()+"");
                    mTvCoDj.setText("V"+result.getCoachGrade());
                    Glide.with(RefundscheduleActivity.this).load(result.getUserIcon()).placeholder(R.mipmap.bg).into(mIvCoShow);
                    Glide.with(RefundscheduleActivity.this).load(result.getProductPic()).transform(new CenterCrop(),new GlideRoundTransform(RefundscheduleActivity.this,5)).placeholder(R.mipmap.bg).into(mIvShow);
                    mTvText.setText(result.getProductTitle()+"");
                    mTvPicse.setText("￥"+result.getPayAmount());
                }else {
                    showToast(bean.getCode()+":"+bean.getMessage());
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

    @OnClick({R.id.bt_ok, R.id.bt_nook})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_ok:
                MediaType type = MediaType.parse("application/json;charset=UTF-8");
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("status", 1);
                    jsonObject.put("returnApplyId", returnApplyId);
                    jsonObject.put("returnAmount", returnAmount);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String string = jsonObject.toString();
                RequestBody body = RequestBody.create(type, string);
                mPresenter.getData(ApiConfig.APPLKCOMIND,body);
                break;
            case R.id.bt_nook:
                String s = mEtReturn.getText().toString();
                if (!TextUtils.isEmpty(s)) {
                    MediaType types = MediaType.parse("application/json;charset=UTF-8");
                    JSONObject jsonObjects = new JSONObject();
                    try {
                        jsonObjects.put("status", 3);
                        jsonObjects.put("returnApplyId", returnApplyId);
                        jsonObjects.put("returnAmount", returnAmount);
                        jsonObjects.put("failureReason", s);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String strings = jsonObjects.toString();
                    RequestBody bodys = RequestBody.create(types, strings);
                    mPresenter.getData(ApiConfig.APPLKCOMIND,bodys);
                }else {
                    showToast("拒绝理由不能为空");
                }
                break;
        }
    }
}
