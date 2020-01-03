package com.example.edives.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

<<<<<<< HEAD:app/src/main/java/com/example/edives/activity/DivingTourActivity.java
import com.example.edives.R;
=======
import com.bigkoo.pickerview.TimePickerView;
import com.example.edive.R;
import com.example.edive.frame.BaseMvpActivity;
import com.example.edive.model.HomeModel;
>>>>>>> ea77401b6ba423d42f46dbccc2e52ed701c9af46:app/src/main/java/com/example/edive/activity/DivingTourActivity.java

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class DivingTourActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.rl_Choose_Address)
    RelativeLayout mChooseAddress;
    @BindView(R.id.et_Diving_title)
    EditText mDivingTitle;
    @BindView(R.id.et_Diving_price)
    EditText mDivingPrice;
    @BindView(R.id.et_Diving_time)
    EditText mDivingTime;
    @BindView(R.id.rb_Time_limitYes)
    RadioButton mTimeLimitYes;
    @BindView(R.id.rb_Time_limitNo)
    RadioButton mTimeLimitNo;
    @BindView(R.id.tv_StartTime)
    TextView mStartTime;
    @BindView(R.id.tv_EndTime)
    TextView mEndTime;
    @BindView(R.id.rl_MostPeople)
    RelativeLayout mMostPeople;
    @BindView(R.id.rec_photo)
    RecyclerView mRecPhoto;
    @BindView(R.id.et_Cost_includes)
    EditText mCostIncludes;
    @BindView(R.id.et_Nocost_contain)
    EditText mNocostContain;
    @BindView(R.id.et_ApplicationNotes)
    EditText mApplicationNotes;
    @BindView(R.id.et_Diving_location_introduction)
    EditText mLocationIntroduction;

    private ArrayList<String> list;

    private TimePickerView pvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.findpassword_bg));//设置颜色
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_diving_tour;
    }

    @Override
    public void initView() {

        list = new ArrayList<>();
    }

    @Override
    public void initData() {

        initTime();
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();


    }

    @Override
    public HomeModel getModel() {
        return null;
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }
    @OnClick({R.id.rl_Choose_Address,R.id.et_Diving_title,R.id.et_Diving_price,R.id.et_Diving_time,R.id.rb_Time_limitYes,R.id.rb_Time_limitNo,
    R.id.rl_MostPeople,R.id.rec_photo,R.id.et_Cost_includes,R.id.et_Nocost_contain,R.id.et_ApplicationNotes,R.id.et_Diving_location_introduction})
    public void OnClick(View v){
        switch (v.getId()){
            default:
                break;
            case R.id.rl_Choose_Address:

                break;
            case R.id.et_Diving_title:

                break;
            case R.id.et_Diving_price:

                break;
            case R.id.et_Diving_time:

                break;
            case R.id.rb_Time_limitYes:

                break;
            case R.id.rb_Time_limitNo:

                break;
            case R.id.rl_MostPeople:

                break;
            case R.id.rec_photo:

                break;
            case R.id.et_Cost_includes:

                break;
            case R.id.et_Nocost_contain:

                break;
            case R.id.et_ApplicationNotes:

                break;
            case R.id.et_Diving_location_introduction:


                break;
        }
    }



    private void initTime() {

        mStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvTime.show(mStartTime);
            }
        });
        mEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvTime.show(mEndTime);
            }
        });
        pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                TextView view = (TextView)v;
                view.setText(getTimes(date));
            }
        })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(new boolean[]{true, true, true, true, true, false})
                .setLabel("年", "月", "日", "时", "分", "")
                .isCenterLabel(true)
                .setDividerColor(Color.DKGRAY)
                .setContentSize(21)
                .setDecorView(null)
                .build();
    }

    private String getTimes(Date date) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }
}
