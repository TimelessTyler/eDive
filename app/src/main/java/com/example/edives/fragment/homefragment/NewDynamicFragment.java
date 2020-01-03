package com.example.edives.fragment.homefragment;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.edives.R;
import com.example.edives.activity.DynamicDetailsActivity;
import com.example.edives.adapter.RlvNewDynamicAdapter;
import com.example.edives.bean.NewDynamicBean;
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
public class NewDynamicFragment extends BaseMvpFragment<HomeModel> {


    @BindView(R.id.new_list)
    RecyclerView mNewList;
    @BindView(R.id.smrefresh)
    SmartRefreshLayout mSmrefresh;
    private ArrayList<NewDynamicBean.DataBean.ListBean> list = new ArrayList();
    private RlvNewDynamicAdapter adapter;
    int pagenum = 1;
    int pagesize = 15;
    private int lastPage;
    private boolean isLastPage;

    public NewDynamicFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_new_dynamic;
    }

    @Override
    public void initView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        mNewList.setLayoutManager(gridLayoutManager);
        adapter = new RlvNewDynamicAdapter(getActivity(), list);
        mNewList.setAdapter(adapter);
        mSmrefresh.setEnableRefresh(false);
        mSmrefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

                if (isLastPage == true) {
                    refreshLayout.finishLoadMoreWithNoMoreData();
                }else {
                    pagenum++;
                    initData();
                    refreshLayout.finishLoadMore();
                }
            }
        });
        adapter.setonclick(new RlvNewDynamicAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                Intent intent = new Intent(getActivity(), DynamicDetailsActivity.class);
                int id = list.get(pos).getId();
                int userType = list.get(pos).getUserType();
                intent.putExtra("pos", id);
                intent.putExtra("userType", userType);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.NEWDYNAMIC_DATA, pagenum, pagesize);
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
            case ApiConfig.NEWDYNAMIC_DATA:
//                list.clear();
                NewDynamicBean bean = (NewDynamicBean) t[0];
                NewDynamicBean.DataBean data = bean.getData();
                lastPage = data.getLastPage();
                isLastPage = data.isIsLastPage();
                List<NewDynamicBean.DataBean.ListBean> results = bean.getData().getList();
                list.addAll(results);
                adapter.setData(list);
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
