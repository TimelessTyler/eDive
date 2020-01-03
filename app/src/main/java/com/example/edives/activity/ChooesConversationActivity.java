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
import com.example.edives.adapter.RlvChooesConversationAdapter;
import com.example.edives.bean.ConversationBean;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.HomeModel;
import com.example.edives.utils.SharedPrefrenceUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ChooesConversationActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.smrefresh)
    SmartRefreshLayout mSmrefresh;
    private ArrayList<ConversationBean.DataBean.ListBean> list;
    private RlvChooesConversationAdapter adapter;
    int num = 1 ;
    int size = 10 ;
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
        return R.layout.activity_chooes_conversation;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChooesConversationActivity.this);
        mRec.setLayoutManager(linearLayoutManager);
        adapter = new RlvChooesConversationAdapter(ChooesConversationActivity.this, list);
        mRec.setAdapter(adapter);
        mSmrefresh.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
//                list.clear();

                refreshLayout.finishLoadMore();
                if (isLastPage == true) {
                    refreshLayout.finishLoadMoreWithNoMoreData();
                }else {
                    num++;
                    initData();
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                num = 1;
                list.clear();
                initData();
                adapter.notifyDataSetChanged();
                refreshLayout.finishRefresh();

            }
        });
        adapter.setonclick(new RlvChooesConversationAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                String topicName = list.get(pos).getTopicName();
                int id = list.get(pos).getId();
                Intent intent = new Intent();
                intent.putExtra("topicname",list.get(pos).getTopicName());
                intent.putExtra("topicid",id);
                SharedPrefrenceUtils.saveString(ChooesConversationActivity.this,"topicid",String.valueOf(id));
                setResult(200,intent);
                finish();
            }
        });
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.CONVERSATION_DATA,num,size);
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
            case ApiConfig.CONVERSATION_DATA:
                ConversationBean bean = (ConversationBean) t[0];
                List<ConversationBean.DataBean.ListBean> beans = bean.getData().getList();
                isLastPage = bean.getData().isIsLastPage();
                list.addAll(beans);
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
