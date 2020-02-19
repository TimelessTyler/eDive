package com.example.edives.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.edives.R;
import com.example.edives.adapter.RlvMytraineeAdapter;
import com.example.edives.bean.MytraineeBean;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.PersonModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class MytraineeActivity extends BaseMvpActivity<PersonModel> {

    @BindView(R.id.tv_student_num)
    TextView mTvStudentNum;
    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.sm)
    SmartRefreshLayout mSm;
    private ArrayList<MytraineeBean.ResultBean.ListBean> list;
    private RlvMytraineeAdapter adapter;
    private int num =1;
    private int size = 10;
    private boolean isLastPage;
    private int total;

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
        return R.layout.activity_mytrainee;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MytraineeActivity.this);
        mRec.setLayoutManager(linearLayoutManager);
        adapter = new RlvMytraineeAdapter(MytraineeActivity.this, list);
        mRec.setAdapter(adapter);
        mSm.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (isLastPage == true) {
                    refreshLayout.finishLoadMoreWithNoMoreData();
                }else {
                    num++;
                    initData();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                 refreshLayout.finishRefresh();
            }
        });
    }

    @Override
    public void initData() {
        MediaType type = MediaType.parse("application/json;charset=UTF-8");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("pageNum", num);
            jsonObject.put("pageSize", size);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String string = jsonObject.toString();
        RequestBody body = RequestBody.create(type, string);
        mPresenter.getData(ApiConfig.COACHINVITEUSER,body);
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
        switch (whichApi){
            case ApiConfig.COACHINVITEUSER:
                MytraineeBean mytraineeBean = (MytraineeBean) t[0];
                if (mytraineeBean.getCode() == 200) {
                    List<MytraineeBean.ResultBean.ListBean> beanList = mytraineeBean.getResult().getList();
                    isLastPage = mytraineeBean.getResult().isIsLastPage();
                    total = mytraineeBean.getResult().getTotal();
                    mTvStudentNum.setText("学员总人数："+total+"人");
                    list.addAll(beanList);
                    adapter.notifyDataSetChanged();
                }else {
                    showToast(mytraineeBean.getMessage());
                }
                break;
        }
    }
}
