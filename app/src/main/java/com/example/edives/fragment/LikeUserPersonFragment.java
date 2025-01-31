package com.example.edives.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.edives.R;
import com.example.edives.activity.DynamicDetailsActivity;
import com.example.edives.adapter.RlvUserPersonDynamicDetailsAdapter;
import com.example.edives.bean.DelectMydynamicBean;
import com.example.edives.bean.LikeBean;
import com.example.edives.bean.MyDynamicBean;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpFragment;
import com.example.edives.model.HomeModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class LikeUserPersonFragment extends BaseMvpFragment<HomeModel> {


    private final int id;
    private final int userType;
    private final int favoriteType;
    @BindView(R.id.tv_more)
    TextView mTvMore;
    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.smrefresh)
    SmartRefreshLayout mSmrefresh;
    private ArrayList<MyDynamicBean.DataBean.ListBean> list;
    private RlvUserPersonDynamicDetailsAdapter adapter;

    private int num =1;
    private int size = 5;
    private boolean isLastPage;

    public LikeUserPersonFragment(int id, int userType, int favoriteType) {
        // Required empty public constructor
        this.id = id;
        this.userType = userType;
        this.favoriteType = favoriteType;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_like_user_person;
    }

    @Override
    public void initView() {
        list = new ArrayList<MyDynamicBean.DataBean.ListBean>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRec.setLayoutManager(linearLayoutManager);
        adapter = new RlvUserPersonDynamicDetailsAdapter(getActivity(), list);
        mRec.setAdapter(adapter);
        mSmrefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (isLastPage == true) {
                    refreshLayout.finishLoadMoreWithNoMoreData();
                }   else {
                    num++;
                    initData();
                    refreshLayout.finishLoadMore();
                }
            }
        });
        adapter.setonclick(new RlvUserPersonDynamicDetailsAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                int id = list.get(pos).getId();
                int userType = list.get(pos).getUserType();
                Intent intent = new Intent(getActivity(), DynamicDetailsActivity.class);
                intent.putExtra("pos",id);
                intent.putExtra("pl",0);
                intent.putExtra("userType",userType);
                startActivity(intent);
            }
        });
        adapter.setonclickzhuanfa(new RlvUserPersonDynamicDetailsAdapter.setonclickzhuanfa() {
            @Override
            public void setonclickzhuanfa(int pos) {
                int id = list.get(pos).getId();
                int userType = list.get(pos).getUserType();
                Intent intent = new Intent(getActivity(), DynamicDetailsActivity.class);
                intent.putExtra("pos",id);
                intent.putExtra("pl",1);
                intent.putExtra("userType",userType);
                startActivity(intent);
            }
        });
        adapter.setlikeonclick(new RlvUserPersonDynamicDetailsAdapter.setlikeonclick() {
            @Override
            public void setlikeonclick(int pos, View view) {
                int id = list.get(pos).getId();
                int userType = list.get(pos).getUserType();
                mPresenter.getData(ApiConfig.NEWSLIKE,id,userType);
            }
        });
        adapter.setnolikeonclick(new RlvUserPersonDynamicDetailsAdapter.setnolikeonclick() {
            @Override
            public void setnolikeonclick(int pos, View view) {
                int id = list.get(pos).getId();
                int userType = list.get(pos).getUserType();
                mPresenter.getData(ApiConfig.NOTLIKE,id,userType);
            }
        });
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.MYDYNAMICDETAILSS,String.valueOf(id),num,size,userType);
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
        switch (whichApi){
            case ApiConfig.MYDYNAMICDETAILSS:
                MyDynamicBean myDynamicBean = (MyDynamicBean) t[0];
                if (myDynamicBean.getCode() == 200) {
                    isLastPage = myDynamicBean.getData().isIsLastPage();
                    List<MyDynamicBean.DataBean.ListBean> data = myDynamicBean.getData().getList();
                    list.addAll(data);
                    adapter.notifyDataSetChanged();
                }else {
                    showToast(myDynamicBean.getMessage());
                }
                break;
            case ApiConfig.DELECTMYDYNAMIC:
                DelectMydynamicBean delectMydynamicBean = (DelectMydynamicBean) t[0];
                if (delectMydynamicBean.getCode() == 200) {
                    showToast(delectMydynamicBean.getMessage());
                    adapter.notifyDataSetChanged();
                }else {
                    showToast(delectMydynamicBean.getMessage());
                }
                break;
            case ApiConfig.NEWSLIKE:
                LikeBean likeBean = (LikeBean) t[0];
                if (likeBean.getCode() == 200) {
                    showToast(likeBean.getMessage());

                }
                break;
            case ApiConfig.NOTLIKE:
                LikeBean been = (LikeBean) t[0];
                if (been.getCode() == 200) {
                    showToast(been.getMessage());

//                    adapter.notifyDataSetChanged();
                }
                break;
        }
    }

    @OnClick(R.id.tv_more)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_more:

                break;
        }
    }

}
