package com.example.edives.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.example.edives.R;
import com.example.edives.adapter.RlvIntegralAdapter;
import com.example.edives.bean.IntegralBean;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.HomeModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntegralActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.sm)
    SmartRefreshLayout mSm;
    private ArrayList<IntegralBean.DataBean.ListBean> list;
    private RlvIntegralAdapter adapter;
    int num = 1;
    int size = 10;
    private boolean isLastPage;

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
        return R.layout.activity_integral;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        adapter = new RlvIntegralAdapter(this, list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(IntegralActivity.this);
        mRec.setLayoutManager(linearLayoutManager);
        mRec.setAdapter(adapter);
        adapter.setonclick(new RlvIntegralAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                int id = list.get(pos).getId();
                Intent intent = new Intent(IntegralActivity.this, IntegralDeatlisActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
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
                list.clear();
                num= 1;
                initData();
                refreshLayout.finishRefresh();
            }
        });
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.INTEGRAL_DATA,num,size);
    }

    @Override
    public HomeModel getModel() {
        return new HomeModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        showToast(e
                .getMessage());
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi){
            case ApiConfig.INTEGRAL_DATA:
                IntegralBean bean = (IntegralBean) t[0];
                if (bean.getCode() == 200) {
                    isLastPage = bean.getData().isIsLastPage();
                    List<IntegralBean.DataBean.ListBean> results = bean.getData().getList();
                    list.addAll(results);
                    adapter.notifyDataSetChanged();
                }else {
                    showToast(bean.getMessage());
                }
                break;
        }
    }
}
