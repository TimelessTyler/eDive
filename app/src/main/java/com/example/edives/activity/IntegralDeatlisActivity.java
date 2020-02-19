package com.example.edives.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.edives.R;
import com.example.edives.adapter.RlvIntegralDeatlisAdapter;
import com.example.edives.bean.AllSpeNumBean;
import com.example.edives.bean.IntegralAllBean;
import com.example.edives.bean.IntegralDeatlisBean;
import com.example.edives.bean.IntegralGiftsBean;
import com.example.edives.bean.IntegralGiftsBeans;
import com.example.edives.design.GlideRoundTransform;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.HomeModel;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntegralDeatlisActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.rec)
    RecyclerView mRec;
    private int id;
    private ArrayList<IntegralDeatlisBean.DataBean> list;
    private RlvIntegralDeatlisAdapter adapter;
    private ArrayList<String> strList;
    private int num = 1;
    private ArrayList<String> arrayList;
    private TextView tv;
    private List<IntegralGiftsBean.DataBean> data;
    private ImageView iv_show;
    private TextView tv_text;
    private TextView tv_num;
    private TextView tv_integral;
    private String name;
    private String integral;
    private String picture;
    private Button bt_ok;
    private int giftId;
    private int kucun;
    private String size;
    private PopupWindow popupWindow;
    private String beanssData;
    private int kucunid;
    private TextView inflate;
    private boolean chek;
    private int numBeanData;

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
        return R.layout.activity_integral_deatlis;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void initView() {
        id = getIntent().getExtras().getInt("id");
        strList = new ArrayList<>();
        list = new ArrayList<>();
        arrayList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(IntegralDeatlisActivity.this);
        mRec.setLayoutManager(linearLayoutManager);
        adapter = new RlvIntegralDeatlisAdapter(IntegralDeatlisActivity.this, list);
        mRec.setAdapter(adapter);
        adapter.setonclick(new RlvIntegralDeatlisAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                int id = list.get(pos).getId();
                initPopu(id);
            }
        });
        mBanner.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, -20, view.getWidth(), view.getHeight(), 60);
            }
        });

        mBanner.setClipToOutline(true);
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initPopu(final int id) {
        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        int widthPixels = outMetrics.widthPixels;
        int heightPixels = outMetrics.heightPixels;
        View inflate1 = LayoutInflater.from(IntegralDeatlisActivity.this).inflate(R.layout.layout_popo_integral, null);
        iv_show = inflate1.findViewById(R.id.iv_show);
        ImageView iv_jia = inflate1.findViewById(R.id.iv_jia);
        ImageView iv_jian = inflate1.findViewById(R.id.iv_jian);
        tv_text = inflate1.findViewById(R.id.tv_text);
        tv_num = inflate1.findViewById(R.id.tv_num);

        tv_integral = inflate1.findViewById(R.id.tv_integral);
        final TextView tv_num_num = inflate1.findViewById(R.id.tv_num_num);
        final TagFlowLayout flowLayout = inflate1.findViewById(R.id.id_flow);
        bt_ok = inflate1.findViewById(R.id.bt_ok);


        popupWindow = new PopupWindow(inflate1, LinearLayout.LayoutParams.MATCH_PARENT, heightPixels/2+100);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(R.style.PopupAnimation);


//         设置背景颜色变暗
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = 0.6f;
        this.getWindow().setAttributes(lp);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = IntegralDeatlisActivity.this.getWindow().getAttributes();
                lp.alpha = 1f;
                IntegralDeatlisActivity.this.getWindow().setAttributes(lp);
            }
        });
        tv_num.setText("库存"+numBeanData);
        tv_text.setText(name);
        tv_integral.setText(integral+"积分");
        Glide.with(IntegralDeatlisActivity.this).load(strList.get(0)).transform(new CenterCrop(),new GlideRoundTransform(IntegralDeatlisActivity.this,8)).into(iv_show);
        flowLayout.setAdapter(new TagAdapter<String>(arrayList) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                inflate = (TextView) LayoutInflater.from(IntegralDeatlisActivity.this).inflate(R.layout.textive, null);
                inflate.setText(s);
                inflate.setBackgroundResource(R.drawable.selector_playsearch);
                return inflate;
            }
        });
        final TagAdapter adapter = flowLayout.getAdapter();

        flowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, final int position, FlowLayout parent) {
                giftId = data.get(position).getGiftId();
                kucunid = data.get(position).getId();
                size = arrayList.get(position);
                mPresenter.getData(ApiConfig.INTERRAL_DUIHUAN, giftId, size);
                Set<Integer> selectedList = flowLayout.getSelectedList();
                int i = selectedList.size();
                if (i == 0) {
                    size = "";
                }
                return true;
            }
        });
        tv_num_num.setText(num+"");
        iv_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num == 10) {
                    showToast("最多可兑换10个");
                }else {
                    num++;
                    tv_num_num.setText(num+"");
                }
            }
        });
        iv_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num == 1) {
                    showToast("最小兑换数量为1");
                    tv_num_num.setText(1+"");
                }else {
                    num--;
                    tv_num_num.setText(num+"");
                }
            }
        });
        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid = mApplication.userid;
                int i = num * Integer.valueOf(integral);

                if (i>Integer.valueOf(beanssData)){
                    showToast("您当前积分不足");


                }else {
                    if (num > kucun) {
                        showToast("库存数量不足");
                    }
                    if (!TextUtils.isEmpty(beanssData)) {
                        if (Integer.valueOf(integral) > Integer.valueOf(beanssData)) {
                            showToast("您当前积分不足");
                        } else {
                            if (!TextUtils.isEmpty(size)) {
                                Intent intent = new Intent(IntegralDeatlisActivity.this, ConfirmationOrderActivity.class);
                                intent.putExtra("id",id);
                                intent.putExtra("gifid",kucunid);
                                intent.putExtra("kucun",kucun);
                                intent.putExtra("size",size);
                                intent.putExtra("num",num);
                                intent.putExtra("jifen",integral);
                                startActivity(intent);
                                popupWindow.dismiss();
                                finish();
                            }else {
                                showToast("请选择规格");
                            }

                        }
                    }else {
                        showToast("您当前暂无积分");
                    }
                }



            }
        });
        popupWindow.showAtLocation(inflate1, Gravity.BOTTOM,0,0);
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.INTEGRALDEATLIS_DATA,id);
        mPresenter.getData(ApiConfig.INTEGRAlS_FITS,id);
        mPresenter.getData(ApiConfig.INTEGRAL_ALL,Integer.parseInt(mApplication.userid));
        mPresenter.getData(ApiConfig.ALLSPENUM,id);
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
            case ApiConfig.INTEGRAL_ALL:
                IntegralAllBean beanss = (IntegralAllBean) t[0];
                if (beanss.getCode() == 200) {
                    beanssData = beanss.getData();
                }else {
                    showToast(beanss.getMessage());
                }

                break;

            case ApiConfig.INTERRAL_DUIHUAN:
                IntegralGiftsBeans integralGiftsBeans = (IntegralGiftsBeans) t[0];
                if (integralGiftsBeans.getCode() == 200) {
                    tv_num.setText("库存"+integralGiftsBeans.getData());
                    kucun = integralGiftsBeans.getData();
                }else {
                    showToast(integralGiftsBeans.getMessage());
                }
                break;
            case ApiConfig.INTEGRAlS_FITS:
                IntegralGiftsBean integralGiftsBean = (IntegralGiftsBean) t[0];
                if (integralGiftsBean.getCode() == 200) {
                    data = integralGiftsBean.getData();
                    for (int i = 0; i < data.size(); i++) {
                        arrayList.add(data.get(i).getSize());
                    }
                }else {
                    showToast(integralGiftsBean.getMessage());
                }
                break;
            case ApiConfig.INTEGRALDEATLIS_DATA:
                IntegralDeatlisBean bean = (IntegralDeatlisBean) t[0];
                List<IntegralDeatlisBean.DataBean> data = bean.getData();
                list.addAll(data);
                name = data.get(0).getName();
                integral = data.get(0).getIntegral();
                picture = data.get(0).getPicture();
                String picture = list.get(0).getPicture();
                String[] split = picture.split(",");
                for (int i = 0; i < split.length; i++) {
                    strList.add(split[i]);
                }
                mBanner.setImages(strList);
                mBanner.setImageLoader(new MyLoader());
                mBanner.start();
                adapter.notifyDataSetChanged();
                break;
            case ApiConfig.ALLSPENUM:
                AllSpeNumBean allSpeNumBean = (AllSpeNumBean) t[0];
                if (allSpeNumBean.getCode() == 200) {
                    numBeanData = allSpeNumBean.getData();

                }else {
                    showToast(allSpeNumBean.getMessage());
                }
                break;
        }
    }

    @OnClick(R.id.iv_back)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }
    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).transform(new CenterCrop(),new GlideRoundTransform(IntegralDeatlisActivity.this,40)).into(imageView);
        }
    }
}
