package com.example.edives.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.edives.R;
import com.example.edives.activity.MytraineeActivity;
import com.example.edives.bean.MytraineeBean;
import com.example.edives.design.RoundImage;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvMytraineeAdapter extends RecyclerView.Adapter<RlvMytraineeAdapter.ViewHolder> {
    private final MytraineeActivity activity;
    private final ArrayList<MytraineeBean.ResultBean.ListBean> list;

    public RlvMytraineeAdapter(MytraineeActivity activity, ArrayList<MytraineeBean.ResultBean.ListBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_mytrainee, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.mTvName.setText(list.get(i).getUserNickName());
        viewHolder.mTvTime.setText(list.get(i).getCreateTime());
        Glide.with(activity).load(list.get(i).getUserIcon()).placeholder(R.mipmap.morentouxiang).error(R.mipmap.morentouxiang).into(viewHolder.mIvShow);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_show)
        RoundImage mIvShow;
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.tv_jrfl)
        TextView mTvJrfl;
        @BindView(R.id.tv_now_pic)
        TextView mTvNowPic;
        @BindView(R.id.tv_all_pic)
        TextView mTvAllPic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
