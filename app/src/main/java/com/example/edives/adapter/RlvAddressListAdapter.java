package com.example.edives.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.edives.R;
import com.example.edives.bean.AddressListBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvAddressListAdapter extends RecyclerView.Adapter<RlvAddressListAdapter.ViewHolder> {
    private final Context activity;
    private final ArrayList<AddressListBean.ResultBean.ListBean> list;
    private setonclick time;
    private setonDelect delects;
    private setonclickmoren moren;
    private setonbjclick bjs;

    public RlvAddressListAdapter(Context activity, ArrayList<AddressListBean.ResultBean.ListBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_address, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        if (list.get(i).getDefaultAddress() == 0) {
            viewHolder.mIvAddshow.setVisibility(View.GONE);
            viewHolder.mIvNomoren.setVisibility(View.VISIBLE);
        }else {
            viewHolder.mIvAddshow.setVisibility(View.VISIBLE);
            viewHolder.mIvNomoren.setVisibility(View.GONE);
        }
        viewHolder.mTvName.setText(list.get(i).getReceiverName());
        viewHolder.mTvPhone.setText(list.get(i).getReceiverMobileNo());
        viewHolder.mTvAddress.setText(list.get(i).getDetailAddress());
        //编辑
        viewHolder.mTvBj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bjs != null) {
                    bjs.setonbjclick(i);
                }
            }
        });
        //删除
        viewHolder.mTvDelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (delects != null) {
                    delects.setonDelect(i);

                }
            }
        });
        viewHolder.mIvNomoren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moren != null) {
                    moren.setonclickmoren(i);
                }
            }
        });
        viewHolder.mRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time != null) {
                    time.setonclick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.tv_phone)
        TextView mTvPhone;
        @BindView(R.id.tv_address)
        TextView mTvAddress;
        @BindView(R.id.view)
        View mView;
        @BindView(R.id.iv_moren)
        ImageView mIvAddshow;
        @BindView(R.id.iv_nomoren)
        ImageView mIvNomoren;
        @BindView(R.id.tv_delect)
        TextView mTvDelect;
        @BindView(R.id.tv_bj)
        TextView mTvBj;
        @BindView(R.id.rl)
        RelativeLayout mRl;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public interface setonclick{
        void setonclick(int pos);
    }
    public void setonclick(setonclick time){

        this.time = time;
    }
    public interface setonDelect{
        void setonDelect(int pos);
    }
    public void setonDelect(setonDelect delects){

        this.delects = delects;
    }
    public interface setonclickmoren{
        void setonclickmoren(int pos);
    }
    public void setonclickmoren(setonclickmoren moren){

        this.moren = moren;
    }
    public interface setonbjclick{
        void setonbjclick(int pos);
    }
    public void setonbjclick(setonbjclick bjs){

        this.bjs = bjs;
    }
}
