package com.example.edives.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.edives.R;
import com.example.edives.adapter.RlvMyDynamicDetailsAdapter;
import com.example.edives.bean.DelectMydynamicBean;
import com.example.edives.bean.LikeBean;
import com.example.edives.bean.MyDynamicBean;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.HomeModel;
import com.example.edives.utils.NormalConfig;
import com.example.edives.utils.SharedPrefrenceUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MyDynamicDetailsPersonActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.smrefresh)
    SmartRefreshLayout mSmrefresh;
    private ArrayList<MyDynamicBean.DataBean.ListBean> list;
    private RlvMyDynamicDetailsAdapter adapter;
    private int num = 1;
    private int size = 10;

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
        return R.layout.activity_my_dynamic_details_person;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyDynamicDetailsPersonActivity.this);
        mRec.setLayoutManager(linearLayoutManager);
        adapter = new RlvMyDynamicDetailsAdapter(MyDynamicDetailsPersonActivity.this, list);
        mRec.setAdapter(adapter);
        adapter.setonclickListent(new RlvMyDynamicDetailsAdapter.setonclickListent() {
            @Override
            public void setonclickListent(int pos) {
                int userId = list.get(pos).getUserId();
                Intent intent = new Intent(MyDynamicDetailsPersonActivity.this, UserPersonDestialsActivity.class);
                intent.putExtra("id",userId);
                startActivity(intent);
            }
        });
        adapter.setonclick(new RlvMyDynamicDetailsAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                int id = list.get(pos).getId();
                Intent intent = new Intent(MyDynamicDetailsPersonActivity.this, DynamicDetailsActivity.class);
                intent.putExtra("pos",id);
                intent.putExtra("pl",0);
                startActivity(intent);
            }
        });
        adapter.setonclickzhuanfa(new RlvMyDynamicDetailsAdapter.setonclickzhuanfa() {
            @Override
            public void setonclickzhuanfa(int pos) {
                int id = list.get(pos).getId();
                Intent intent = new Intent(MyDynamicDetailsPersonActivity.this, DynamicDetailsActivity.class);
                intent.putExtra("pos",id);
                intent.putExtra("pl",1);
                startActivity(intent);
            }
        });
        adapter.setfollowonclick(new RlvMyDynamicDetailsAdapter.setfollowonclick() {
            @Override
            public void setfollowonclick(int pos) {
                int id = list.get(pos).getId();
                list.remove(pos);
                mPresenter.getData(ApiConfig.DELECTMYDYNAMIC,id);
            }
        });
        adapter.setlikeonclick(new RlvMyDynamicDetailsAdapter.setlikeonclick() {
            @Override
            public void setlikeonclick(int pos, View view) {
                mPresenter.getData(ApiConfig.NEWSLIKE,pos);
            }
        });
        adapter.setnolikeonclick(new RlvMyDynamicDetailsAdapter.setnolikeonclick() {
            @Override
            public void setnolikeonclick(int pos, View view) {
                mPresenter.getData(ApiConfig.NOTLIKE,pos);
            }
        });
    }

    @Override
    public void initData() {
        String userid = SharedPrefrenceUtils.getString(MyDynamicDetailsPersonActivity.this, NormalConfig.USER_PHOTO, "");
        mPresenter.getData(ApiConfig.MYDYNAMICDETAILS,userid,num,size);
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
            case ApiConfig.MYDYNAMICDETAILS:
                MyDynamicBean myDynamicBean = (MyDynamicBean) t[0];
                if (myDynamicBean.getCode() == 200) {
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
}
