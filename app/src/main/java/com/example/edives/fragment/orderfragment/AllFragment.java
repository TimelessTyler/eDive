package com.example.edives.fragment.orderfragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edives.R;
import com.example.edives.activity.OrderDetailsActivity;
import com.example.edives.adapter.RlvMyOrderAdapter;
import com.example.edives.bean.OrderBean;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpFragment;
import com.example.edives.model.ShoppingModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllFragment extends BaseMvpFragment<ShoppingModel> {


    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.sm)
    SmartRefreshLayout mSm;
    private ArrayList<OrderBean.ResultBean.ListBean> list;
    private RlvMyOrderAdapter adapter;
    private int status = 1;
    private int num = 1;
    private int size = 10;
    private int lastPage;
    private boolean isLastPage;

    public AllFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_all;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRec.setLayoutManager(linearLayoutManager);
        adapter = new RlvMyOrderAdapter(getActivity(), list);
        mRec.setAdapter(adapter);
        mSm.setDisableContentWhenRefresh(true);
        adapter.setonclick(new RlvMyOrderAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                int statuss = list.get(pos).getStatus();
                String orderSn = list.get(pos).getOrderSn();
                Intent intent = new Intent(getActivity(), OrderDetailsActivity.class);
                intent.putExtra("order",orderSn);
                intent.putExtra("status",statuss);
                startActivity(intent);
            }
        });
        mSm.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
//                list.clear();

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
                num = 1;
                initData();
                refreshLayout.finishRefresh();
            }
        });
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.ORDER_FRAGMENT,status,num,size);
    }

    @Override
    public ShoppingModel getModel() {
        return new ShoppingModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        showToast(e.getMessage()+"-------"+e.getLocalizedMessage());
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi){
            case ApiConfig.ORDER_FRAGMENT:
//                list.clear();
                OrderBean bean = (OrderBean) t[0];
                OrderBean.ResultBean result = bean.getResult();
                lastPage = result.getLastPage();
                isLastPage = result.isIsLastPage();
                List<OrderBean.ResultBean.ListBean> rsts = bean.getResult().getList();
                list.addAll(rsts);
                adapter.notifyDataSetChanged();
                break;
        }
    }

}
