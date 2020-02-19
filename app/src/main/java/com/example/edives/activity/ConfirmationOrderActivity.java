package com.example.edives.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.edives.R;
import com.example.edives.bean.AddressListBean;
import com.example.edives.bean.ChuansBean;
import com.example.edives.bean.IntegralAllBean;
import com.example.edives.bean.IntegralDeatlisBean;
import com.example.edives.bean.MoAddress;
import com.example.edives.design.CommonTitle;
import com.example.edives.design.GlideRoundTransform;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.HomeModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ConfirmationOrderActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.title)
    CommonTitle mTitle;
    @BindView(R.id.bt_addaress)
    Button mBtaddaress;
    @BindView(R.id.rl_addaress_no)
    RelativeLayout mRlAddaressNo;
    @BindView(R.id.cardno)
    CardView mCardno;
    @BindView(R.id.iv_weizhi)
    ImageView mIvWeizhi;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.iv_more)
    ImageView mIvMore;
    @BindView(R.id.tv_loacte)
    TextView mlocate;
    @BindView(R.id.rl_addaress)
    RelativeLayout mRlAddaress;
    @BindView(R.id.card1)
    CardView mCard1;
    @BindView(R.id.iv_show)
    ImageView mIvShow;
    @BindView(R.id.tv_text)
    TextView mTvText;
    @BindView(R.id.tv_num_guige)
    TextView mTvNumGuige;
    @BindView(R.id.tv_integral_kucun)
    TextView mTvIntegralKucun;
    @BindView(R.id.rl2)
    RelativeLayout mRl2;
    @BindView(R.id.tv_s)
    TextView mTvS;
    @BindView(R.id.tv_integralsss)
    TextView mTvIntegralsss;
    @BindView(R.id.iv_jia)
    ImageView mIvJia;
    @BindView(R.id.tv_num_nums)
    TextView mTvNumNum;
    @BindView(R.id.iv_jian)
    ImageView mIvJian;
    @BindView(R.id.rl3)
    RelativeLayout mRl3;
    @BindView(R.id.card2)
    CardView mCard2;
    @BindView(R.id.bt_ok)
    Button mBtOk;
    private int id;
    private int gifid;
    private ArrayList<String> arrayList;
    private int kucun;
    private String size;
    private int num;
    private String jifen;
    private int addaressid;
    private int anInt;
    private int i1;
    private String beanssData;
    private int wc;

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
        return R.layout.activity_confirmation_order;
    }

    @Override
    public void initView() {
        arrayList = new ArrayList<>();
        id = getIntent().getExtras().getInt("id");
        gifid = getIntent().getExtras().getInt("gifid");
        kucun = getIntent().getExtras().getInt("kucun");
        size = getIntent().getStringExtra("size");
        num = getIntent().getExtras().getInt("num");
        jifen = getIntent().getStringExtra("jifen");
        mTvNumGuige.setText("规格：" + size);
        mTvIntegralKucun.setText("库存" + kucun);
        mTvNumNum.setText(num + "");
        final int i = Integer.parseInt(jifen);
        i1 = i * num;
        mTvIntegralsss.setText(i1 + "");
        mIvJia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = num + 1;
                mTvNumNum.setText(num + "");
                int parseInt = Integer.parseInt(jifen);
                i1 = parseInt * num;
                mTvIntegralsss.setText(i1 + "");
            }
        });
        mIvJian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = num - 1;
                mTvNumNum.setText(num + "");
                int jife = Integer.parseInt(jifen);
                i1 = jife * num;
                mTvIntegralsss.setText(i1 + "");
            }
        });
        mBtaddaress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfirmationOrderActivity.this, AddAddressActivity.class));
            }
        });
        mRlAddaress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmationOrderActivity.this, ChooesAddaressActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            addaressid = data.getExtras().getInt("id");
            wc = data.getExtras().getInt("wc");
            String name = data.getStringExtra("name");
            String phone = data.getStringExtra("phone");
            String cityName = data.getStringExtra("cityName");
            String districtName = data.getStringExtra("districtName");
            String detailAddress = data.getStringExtra("detailAddress");
            mTvName.setText(name);
            mTvPhone.setText(phone);
            mlocate.setText(cityName + districtName + detailAddress);
        }
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.MORENDIZHI);
        mPresenter.getData(ApiConfig.INTEGRALDEATLIS_DATA, id);
        mPresenter.getData(ApiConfig.INTEGRAL_ALL,Integer.parseInt(mApplication.userid));
    }

    @Override
    public HomeModel getModel() {
        return new HomeModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        showToast(e.getMessage());
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.INTEGRAL_ALL:
                IntegralAllBean beanss = (IntegralAllBean) t[0];
                if (beanss.getCode() == 200) {
                    beanssData = beanss.getData();
                }else {
                    showToast(beanss.getMessage());
                }

                break;
            case ApiConfig.MORENDIZHI:
                MoAddress moAddress = (MoAddress) t[0];
                if (moAddress.getCode() == 200) {
                    addaressid = moAddress.getResult().getId();
                    mCard1.setVisibility(View.VISIBLE);
                    mCardno.setVisibility(View.GONE);
                    MoAddress.ResultBean result = moAddress.getResult();
                    mTvName.setText(result.getReceiverName());
                    mTvPhone.setText(result.getReceiverMobileNo());
                    mlocate.setText(result.getCityName() + result.getProvinceName() + result.getDistrictName() + result.getDetailAddress());
                } else {
                    mCard1.setVisibility(View.GONE);
                    mCardno.setVisibility(View.VISIBLE);
                    mBtaddaress.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(ConfirmationOrderActivity.this, AddAddressActivity.class));
                        }
                    });
//                    showToast(moAddress.getMessage());
                }
                break;
            case ApiConfig.INTEGRALDEATLIS_DATA:
                IntegralDeatlisBean bean = (IntegralDeatlisBean) t[0];
                List<IntegralDeatlisBean.DataBean> data = bean.getData();
                mTvText.setText(data.get(0).getName());
                String picture = data.get(0).getPicture();
                String[] split = picture.split(",");
                for (int i = 0; i < split.length; i++) {
                    arrayList.add(split[i]);
                }
                Glide.with(ConfirmationOrderActivity.this).load(arrayList.get(0)).transform(new CenterCrop(), new GlideRoundTransform(ConfirmationOrderActivity.this, 6)).into(mIvShow);
                break;
            case ApiConfig.CHUANGJIANJIFENGHAOLI:
                ChuansBean chuanBean = (ChuansBean) t[0];
                if (chuanBean.getCode() == 200) {
                    showToast(chuanBean.getMessage());
                    finish();
                }else {
                    showToast(chuanBean.getMessage());
                }
                break;
            case ApiConfig.ADDRESSLIST:
                AddressListBean addressListBean = (AddressListBean) t[0];
                if (addressListBean.getCode() == 200) {
                    List<AddressListBean.ResultBean.ListBean> result = addressListBean.getResult().getList();
                    if (result.size() == 0) {
                        mCard1.setVisibility(View.GONE);
                        mCardno.setVisibility(View.VISIBLE);
                    }
                }
                break;
        }
    }

    @OnClick(R.id.bt_ok)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_ok:
                if (Integer.valueOf(beanssData) < i1) {
                    showToast("您当前积分不足");
                }else {
                    MediaType type = MediaType.parse("application/json;charset=UTF-8");
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("productId", id);
                        jsonObject.put("productSkuId", gifid);
                        jsonObject.put("isUserIntegration", 1);
                        jsonObject.put("quantity", num);
                        jsonObject.put("shippingId", addaressid);
                        jsonObject.put("useIntegration", i1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String string = jsonObject.toString();
                    RequestBody bodys = RequestBody.create(type, string);
                    if (addaressid == 0) {
                        showToast("选择地址");
                    }else {
                        mPresenter.getData(ApiConfig.CHUANGJIANJIFENGHAOLI, bodys);
                    }
                }
                break;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (addaressid == 0) {
            mPresenter.getData(ApiConfig.MORENDIZHI);
        }
        MediaType type = MediaType.parse("application/json;charset=UTF-8");
        org.json.JSONObject jsonObject = new org.json.JSONObject();
        try {
            jsonObject.put("adminId", Integer.parseInt(mApplication.userid));
            jsonObject.put("pageNum", 1);
            jsonObject.put("pageSize", 10);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        String strings = jsonObject.toString();
        RequestBody body = RequestBody.create(type, strings);
        mPresenter.getData(ApiConfig.ADDRESSLIST, body);
    }
}
