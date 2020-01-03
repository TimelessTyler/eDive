package com.example.edives.fragment.homefragment;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.edives.R;
import com.example.edives.adapter.RlvHotAdapter;
import com.example.edives.bean.HotBean;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpFragment;
import com.example.edives.model.HomeModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends BaseMvpFragment<HomeModel> {


    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.smrefres)
    SmartRefreshLayout mSmrefres;
    private ArrayList<HotBean.DataBean.ListBean> list;
    private RlvHotAdapter adapter;
    int num = 1;
    int size = 15;
    private int lastPage;
    private boolean isLastPage;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        adapter = new RlvHotAdapter(getActivity(), list);
        mRec.setLayoutManager(layoutManager);
        mRec.setAdapter(adapter);
        mSmrefres.setEnableRefresh(false);
        mSmrefres.setOnLoadMoreListener(new OnLoadMoreListener() {
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
        });
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.HOT_DATA, num, size);
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
        switch (whichApi) {
            case ApiConfig.HOT_DATA:
//                list.clear();
                HotBean bean = (HotBean) t[0];
                if (bean.getCode() == 200) {
                    HotBean.DataBean data1 = bean.getData();
                    lastPage = data1.getLastPage();
                    isLastPage = data1.isIsLastPage();
                    List<HotBean.DataBean.ListBean> data = bean.getData().getList();
                    list.addAll(data);
                    adapter.notifyDataSetChanged();
                }else {
                    showToast(bean.getMessage());
                }
                break;
        }
    }
}
