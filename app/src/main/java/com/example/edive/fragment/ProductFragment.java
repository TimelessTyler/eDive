package com.example.edive.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.edive.R;
import com.example.edive.adapter.RlvShoppingTripAdapter;
import com.example.edive.bean.DivingBean;
import com.example.edive.frame.ApiConfig;
import com.example.edive.frame.BaseMvpFragment;
import com.example.edive.model.HomeModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class ProductFragment extends BaseMvpFragment<HomeModel> {


    @BindView(R.id.tv_more)
    TextView mTvMore;
    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.smrefresh)
    SmartRefreshLayout mSmrefresh;
    private int id;
    private int num = 1;
    private int size = 10;
    private ArrayList<DivingBean.ResultBean.ListBean> list;
    private RlvShoppingTripAdapter adapters;


    public ProductFragment(int id) {
        // Required empty public constructor
        this.id = id;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_product;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        LinearLayoutManager linearLayoutManagers = new LinearLayoutManager(getActivity());
        mRec.setLayoutManager(linearLayoutManagers);
        adapters = new RlvShoppingTripAdapter(getActivity(), list);
        mRec.setAdapter(adapters);
    }

    @Override
    public void initData() {
        MediaType types = MediaType.parse("application/json;charset=UTF-8");
        JSONObject jsonObjects = new JSONObject();
        try {
            jsonObjects.put("pageNum", num);
            jsonObjects.put("pageSize", size);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String strings = jsonObjects.toString();
        RequestBody bodys = RequestBody.create(types, strings);
        mPresenter.getData(ApiConfig.SHOPPING_DIVING, bodys);
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
            case ApiConfig.SHOPPING_DIVING:
                DivingBean ha = (DivingBean) t[0];
                List<DivingBean.ResultBean.ListBean> hahben = ha.getResult().getList();
                list.addAll(hahben);
                adapters.notifyDataSetChanged();
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
