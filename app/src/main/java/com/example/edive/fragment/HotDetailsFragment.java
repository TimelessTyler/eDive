package com.example.edive.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.example.edive.R;
import com.example.edive.activity.DynamicDetailsActivity;
import com.example.edive.activity.UserPersonDestialsActivity;
import com.example.edive.adapter.RlvHotDeatilsAdapter;
import com.example.edive.bean.FollowBean;
import com.example.edive.bean.HotDetalisBean;
import com.example.edive.bean.LikeBean;
import com.example.edive.bean.NotFollowBean;
import com.example.edive.frame.ApiConfig;
import com.example.edive.frame.BaseMvpFragment;
import com.example.edive.model.HomeModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class HotDetailsFragment extends BaseMvpFragment<HomeModel> {


    private int pos;
    private String userid;
    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.smrefresh)
    SmartRefreshLayout mSmrefresh;

    private ArrayList<HotDetalisBean.DataBean.ListBean> list;
    private RlvHotDeatilsAdapter adapter;
    private int num = 1;
    private int size = 10;
    private boolean like = false;
    private int lastPage;
    private boolean isLastPage;

    @SuppressLint("ValidFragment")
    public HotDetailsFragment(int pos, String userid) {

        this.pos = pos;
        this.userid = userid;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_hot_details;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRec.setLayoutManager(linearLayoutManager);
        Integer integer = Integer.valueOf(userid);
        adapter = new RlvHotDeatilsAdapter(getActivity(), list,integer);
        mRec.setAdapter(adapter);
        adapter.setonclickListent(new RlvHotDeatilsAdapter.setonclickListent() {
            @Override
            public void setonclickListent(int pos) {
                int userId = list.get(pos).getUserId();
                int userType = list.get(pos).getUserType();
                Intent intent = new Intent(getActivity(), UserPersonDestialsActivity.class);
                intent.putExtra("id",userId);
                intent.putExtra("userType",userType);
                startActivity(intent);
            }
        });
        adapter.setonclicks(new RlvHotDeatilsAdapter.setonclicks() {
            @Override
            public void setonclicks(int pos) {
                Intent intent = new Intent(getActivity(), DynamicDetailsActivity.class);
                int id = list.get(pos).getId();
                int userType = list.get(pos).getUserType();
                intent.putExtra("pos",id);
                intent.putExtra("pl",1);
                intent.putExtra("userType",userType);
                startActivity(intent);
            }
        });
        mSmrefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                list.clear();
                num = 1;
                initData();
                refreshLayout.finishRefresh();
            }
        });
        mSmrefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
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
        adapter.setonclick(new RlvHotDeatilsAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                Intent intent = new Intent(getActivity(), DynamicDetailsActivity.class);
                int id = list.get(pos).getId();
                int userType = list.get(pos).getUserType();
                intent.putExtra("pos",id);
                intent.putExtra("userType",userType);
                startActivity(intent);
            }
        });
        adapter.setfollowonclick(new RlvHotDeatilsAdapter.setfollowonclick() {
            @Override
            public void setfollowonclick(int targetid, int pos) {
                int userId = list.get(pos).getUserId();
                int userType = list.get(pos).getUserType();
                MediaType type = MediaType.parse("application/json;charset=UTF-8");
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("favoriteType", userType);
                    jsonObject.put("status", 1);
                    jsonObject.put("targetId", userId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String string = jsonObject.toString();
                RequestBody body = RequestBody.create(type, string);
                mPresenter.getData(ApiConfig.FOLLOWUSER,body);
            }
        });
        adapter.setlikeonclick(new RlvHotDeatilsAdapter.setlikeonclick() {
            @Override
            public void setlikeonclick(int pos, View view) {
                int id = list.get(pos).getId();
                int userType = list.get(pos).getUserType();
                mPresenter.getData(ApiConfig.NEWSLIKE,id,userType);
            }
        });
        adapter.setnolikeonclick(new RlvHotDeatilsAdapter.setnolikeonclick() {
            @Override
            public void setnolikeonclick(int pos, View view) {
                int id = list.get(pos).getId();
                int userType = list.get(pos).getUserType();
                mPresenter.getData(ApiConfig.NOTLIKE,id,userType);
            }
        });
        adapter.setnotfollowonclick(new RlvHotDeatilsAdapter.setnotfollowonclick() {
            @Override
            public void setnotfollowonclick(int targetid, int pos) {
                int userId = list.get(pos).getUserId();
                int userType = list.get(pos).getUserType();
                MediaType type = MediaType.parse("application/json;charset=UTF-8");
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("favoriteType", userType);
                    jsonObject.put("status", 2);
                    jsonObject.put("targetId", userId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String string = jsonObject.toString();
                RequestBody body = RequestBody.create(type, string);
                mPresenter.getData(ApiConfig.NOTFOLLOWS,body);
            }
        });
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.HOTDETALIS_DATA, num, size, pos);
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
            case ApiConfig.HOTDETALIS_DATA:
                HotDetalisBean bean = (HotDetalisBean) t[0];
                HotDetalisBean.DataBean data1 = bean.getData();
                lastPage = data1.getLastPage();
                isLastPage = data1.isIsLastPage();
                List<HotDetalisBean.DataBean.ListBean> data = bean.getData().getList();
                list.addAll(data);
                adapter.notifyDataSetChanged();
                break;
            case ApiConfig.NEWSLIKE:
                LikeBean likeBean = (LikeBean) t[0];
                if (likeBean.getCode() == 200) {
                    showToast("点赞成功");
                }
                break;
            case ApiConfig.NOTLIKE:
                LikeBean been = (LikeBean) t[0];
                if (been.getCode() == 200) {
                    showToast("取消点赞");
                }
                break;
            case ApiConfig.FOLLOWUSER:
                FollowBean followBean = (FollowBean) t[0];
                if (followBean.getCode() == 200) {
                    showToast(followBean.getMessage());

                } else if (followBean.getCode() == 500) {
                    showToast(followBean.getMessage());
                }
                break;
            case ApiConfig.NOTFOLLOWS:
                NotFollowBean notFollowBean = (NotFollowBean) t[0];
                if (notFollowBean.getCode() == 200) {
                    showToast("取消关注");
                }
                break;
        }
    }

}
