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
import com.example.edives.adapter.RlvFollowListAdapter;
import com.example.edives.bean.FollowBean;
import com.example.edives.bean.FollowListBean;
import com.example.edives.bean.NotFollowBean;
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
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class AttentionActivity extends BaseMvpActivity<PersonModel> {

    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.sm)
    SmartRefreshLayout mSm;
    private ArrayList<FollowListBean.ResultBean.ListBean> list;
    private RlvFollowListAdapter adapter;
    private RequestBody bodys;
    private int num = 1;
    private int size = 5;
    private int favoriteType = 1;
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
        return R.layout.activity_attention;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AttentionActivity.this);
        mRec.setLayoutManager(linearLayoutManager);
        adapter = new RlvFollowListAdapter(AttentionActivity.this, list);
        mRec.setAdapter(adapter);
        adapter.setonclick(new RlvFollowListAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                int userId = list.get(pos).getTargetId();
                int favoriteTypes = list.get(pos).getFavoriteType();
                Intent intent = new Intent(AttentionActivity.this, UserPersonDestialsActivity.class);
                intent.putExtra("id",userId);
                intent.putExtra("userType",favoriteTypes);
                startActivity(intent);
            }
        });
        adapter.seonclckListener(new RlvFollowListAdapter.seonclckListener() {
            @Override
            public void seonclckListener(int pos) {
                int favoriteType = list.get(pos).getFavoriteType();
                int targetId = list.get(pos).getTargetId();
                MediaType type = MediaType.parse("application/json;charset=UTF-8");
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("favoriteType", favoriteType);
                    jsonObject.put("status", 1);
                    jsonObject.put("targetId", targetId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String string = jsonObject.toString();
                RequestBody body = RequestBody.create(type, string);
                mPresenter.getData(ApiConfig.FOLLOWUSERS,body);
            }
        });
        mSm.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (total < 5) {
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
                adapter.notifyDataSetChanged();
                refreshLayout.finishRefresh();
            }
        });
        adapter.setDelItemListener(new RlvFollowListAdapter.setDelItemListener() {
            @Override
            public void setDelItemListener(int pos) {
                int favoriteType = list.get(pos).getFavoriteType();
                MediaType types = MediaType.parse("application/json;charset=UTF-8");
                JSONObject jsonObjects = new JSONObject();
                try {
                    jsonObjects.put("favoriteType", favoriteType);
                    jsonObjects.put("status", 2);
                    jsonObjects.put("targetId", list.get(pos).getTargetId());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String str = jsonObjects.toString();
                bodys = RequestBody.create(types, str);
//                list.remove(pos);
//                adapter.notifyDataSetChanged();
                mPresenter.getData(ApiConfig.NOTFOLLOW, bodys);
            }
        });
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.FOLLOWLIST, num, size, favoriteType);
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
        switch (whichApi) {
            case ApiConfig.FOLLOWLIST:
                FollowListBean followListBean = (FollowListBean) t[0];
                if (followListBean.getCode() == 200) {
                    total = followListBean.getResult().getTotal();
                    List<FollowListBean.ResultBean.ListBean> bean = followListBean.getResult().getList();
                    list.addAll(bean);
                    adapter.notifyDataSetChanged();
                }else {
                    showToast(followListBean.getMessage());
                }
                break;
            case ApiConfig.NOTFOLLOW:
                NotFollowBean notFollowBean = (NotFollowBean) t[0];
                if (notFollowBean.getCode() == 200) {
                    showToast("取消关注");
                }
                break;
            case ApiConfig.FOLLOWUSERS:
                FollowBean followBean = (FollowBean) t[0];
                if (followBean.getCode() == 200) {
                    showToast("关注成功");

                } else if (followBean.getCode() == 500) {
                    showToast(followBean.getMessage());
                }
                break;
        }
    }
}
