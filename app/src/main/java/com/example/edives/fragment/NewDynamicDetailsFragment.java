package com.example.edives.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.edives.R;
import com.example.edives.activity.DynamicDetailsActivity;
import com.example.edives.activity.UserPersonDestialsActivity;
import com.example.edives.adapter.RlvTopicNewDynamicAdapter;
import com.example.edives.bean.FollowBean;
import com.example.edives.bean.LikeBean;
import com.example.edives.bean.NewsDynamicDeatilsBean;
import com.example.edives.bean.NotFollowBean;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseApplication;
import com.example.edives.frame.BaseMvpFragment;
import com.example.edives.model.HomeModel;
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
public class NewDynamicDetailsFragment extends BaseMvpFragment<HomeModel> {


    private int pos;
    private String userid;
    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.smre)
    SmartRefreshLayout mSmre;

    private ArrayList<NewsDynamicDeatilsBean.DataBean.ListBean> list;
    private RlvTopicNewDynamicAdapter adapter;
    private int num = 1;
    private int size = 10;
    private boolean like = false;
    private int lastPage;
    private boolean isLastPage;

    public NewDynamicDetailsFragment(int pos, String userid) {
        // Required empty public constructor
        this.pos = pos;
        this.userid = userid;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_new_dynamic_details;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRec.setLayoutManager(linearLayoutManager);
        BaseApplication baseApplication = new BaseApplication();
        Integer integer = Integer.valueOf(userid);
        adapter = new RlvTopicNewDynamicAdapter(getActivity(), list,integer);
        mRec.setAdapter(adapter);
        adapter.setonclickListent(new RlvTopicNewDynamicAdapter.setonclickListent() {
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
        adapter.setonclicks(new RlvTopicNewDynamicAdapter.setonclicks() {
            @Override
            public void setonclicks(int pos) {
                int id = list.get(pos).getId();
                int userType = list.get(pos).getUserType();
                Intent intent = new Intent(getActivity(), DynamicDetailsActivity.class);
                intent.putExtra("pos",id);
                intent.putExtra("pl",0);
                intent.putExtra("userType",userType);
                startActivity(intent);
            }
        });
        adapter.setonclick(new RlvTopicNewDynamicAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                int id = list.get(pos).getId();
                int userType = list.get(pos).getUserType();
                Intent intent = new Intent(getActivity(), DynamicDetailsActivity.class);
                intent.putExtra("pos",id);
                intent.putExtra("pl",1);
                intent.putExtra("userType",userType);
                startActivity(intent);
            }
        });
        mSmre.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                list.clear();
                num = 1;
                initData();
                adapter.notifyDataSetChanged();
                refreshLayout.finishRefresh();
            }
        });
        mSmre.setOnLoadMoreListener(new OnLoadMoreListener() {
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
//        adapter.setonclick(new RlvTopicNewDynamicAdapter.setonclick() {
//            @Override
//            public void setonclick(int pos) {
//                Intent intent = new Intent(getActivity(), DynamicDetailsActivity.class);
//                int id = list.get(pos).getId();
//                intent.putExtra("pos",id);
//                intent.putExtra("jp","close");
//                startActivity(intent);
//            }
//        });
        adapter.setlikeonclick(new RlvTopicNewDynamicAdapter.setlikeonclick() {
            @Override
            public void setlikeonclick(int pos,View view) {
                int id = list.get(pos).getId();
                int userType = list.get(pos).getUserType();
                mPresenter.getData(ApiConfig.NEWSLIKE,id,userType);
            }
        });
        adapter.setnolikeonclick(new RlvTopicNewDynamicAdapter.setnolikeonclick() {
            @Override
            public void setnolikeonclick(int pos, View view) {
                int id = list.get(pos).getId();
                int userType = list.get(pos).getUserType();
                mPresenter.getData(ApiConfig.NOTLIKE,id,userType);
            }
        });
        adapter.setfollowonclick(new RlvTopicNewDynamicAdapter.setfollowonclick() {
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

        adapter.setnotfollowonclick(new RlvTopicNewDynamicAdapter.setnotfollowonclick() {
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
//            adapter.setonclick(new RlvTopicNewDynamicAdapter.setonclick() {
//                @Override
//                public void setonclick(int pos) {
//                    int id = list.get(pos).getId();
//                    Intent intent = new Intent(getActivity(), DynamicDetailsActivity.class);
//                    intent.putExtra("pos",id);
//                    intent.putExtra("jp","open");
//                    startActivity(intent);
//                }
//            });
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.NEWSDYNAMICDEATILS_DATA, pos,num,size);
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
            case ApiConfig.NEWSDYNAMICDEATILS_DATA:
                NewsDynamicDeatilsBean bean = (NewsDynamicDeatilsBean) t[0];
                NewsDynamicDeatilsBean.DataBean data = bean.getData();
                lastPage = data.getLastPage();
                isLastPage = data.isIsLastPage();
                List<NewsDynamicDeatilsBean.DataBean.ListBean> results = bean.getData().getList();
                list.addAll(results);
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
//                    adapter.notifyDataSetChanged();
//                    mPresenter.getData(ApiConfig.NEWSDYNAMICDEATILS_DATA, pos,num,size);
                }
                break;
            case ApiConfig.FOLLOWUSER:
                FollowBean followBean = (FollowBean) t[0];
                if (followBean.getCode() == 200) {
                    showToast("关注成功");
                    list.clear();
                    mPresenter.getData(ApiConfig.NEWSDYNAMICDEATILS_DATA, pos,num,size);
                } else if (followBean.getCode() == 500) {
                    showToast(followBean.getMessage());
                }
                break;
            case ApiConfig.NOTFOLLOWS:
                NotFollowBean notFollowBean = (NotFollowBean) t[0];
                if (notFollowBean.getCode() == 200) {
                    showToast("取消关注");
                    list.clear();
                    mPresenter.getData(ApiConfig.NEWSDYNAMICDEATILS_DATA, pos,num,size);
                }
                break;
        }
    }
}
