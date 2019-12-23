package com.example.edive.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edive.R;
import com.example.edive.activity.ShowPhotoActivity;
import com.example.edive.adapter.RlvAlbumAdapter;
import com.example.edive.bean.AlbumBean;
import com.example.edive.frame.ApiConfig;
import com.example.edive.frame.BaseMvpFragment;
import com.example.edive.model.PersonModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class AlbumFragment extends BaseMvpFragment<PersonModel> {


    private final int id;
    private final int userType;
    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.smrefresh)
    SmartRefreshLayout mSmrefresh;
    private ArrayList<AlbumBean.DataBean.ListBean> list;
    private RlvAlbumAdapter adapter;
    private int num = 1;
    private int size =10;
    private List<AlbumBean.DataBean.ListBean> listBeanList;
    private ArrayList<String> strList;

    public AlbumFragment(int id, int userType) {
        // Required empty public constructor
        this.id = id;
        this.userType = userType;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_album;
    }

    @Override
    public void initView() {
        strList = new ArrayList<>();
        list = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRec.setLayoutManager(gridLayoutManager);
        adapter = new RlvAlbumAdapter(getActivity(), list);
        mRec.setAdapter(adapter);
        adapter.setonclick(new RlvAlbumAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                String picture = list.get(pos).getPicture();
                String[] split = picture.split(",");
                for (int j = 0; j < split.length; j++) {
                    strList.add(split[j]);
                }
                Intent intent = new Intent(getActivity(), ShowPhotoActivity.class);
                intent.putExtra("pos",0);
                intent.putExtra("list",strList);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.LABUMUSERPERSONAL,id,num,size,userType);
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
        switch (whichApi){
            case ApiConfig.LABUMUSERPERSONAL:
                AlbumBean albumBean = (AlbumBean) t[0];
                if (albumBean.getCode() == 200) {
                    listBeanList = albumBean.getData().getList();
                    list.addAll(listBeanList);
                    adapter.notifyDataSetChanged();
                }else {
                    showToast(albumBean.getMessage());
                }
                break;
        }
    }

}
