package com.example.edives.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.edives.R;
import com.example.edives.bean.FollowListBean;
import com.example.edives.design.RoundImage;
import com.example.edives.design.RoundOrCircleImage;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvFollowListAdapter extends RecyclerView.Adapter<RlvFollowListAdapter.ViewHolder> {

    private final Context activity;
    private final ArrayList<FollowListBean.ResultBean.ListBean> list;
    private setDelItemListener time;
    private seonclckListener times;
    private setonclick user;

    public RlvFollowListAdapter(Context activity, ArrayList<FollowListBean.ResultBean.ListBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_follow_list, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
            Glide.with(activity).load(list.get(i).getIcon()).placeholder(R.mipmap.bg).into(viewHolder.mIvShow);
            viewHolder.mTvName.setText(list.get(i).getNickname());
        if (list.get(i).getStatus() == 1) {
            viewHolder.mTvData.setVisibility(View.GONE);
            viewHolder.mTvDatas.setVisibility(View.VISIBLE);
        }
            viewHolder.mTvDatas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    time.setDelItemListener(i);
                    viewHolder.mTvData.setVisibility(View.VISIBLE);
                    viewHolder.mTvDatas.setVisibility(View.GONE);
                }
            });
            viewHolder.mTvData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (times != null) {
                        times.seonclckListener(i);
                        viewHolder.mTvDatas.setVisibility(View.VISIBLE);
                        viewHolder.mTvData.setVisibility(View.GONE);
                    }
                }
            });
            viewHolder.mIvShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (user != null) {
                        user.setonclick(i);
                    }
                }
            });

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
        @BindView(R.id.tv_datas)
        TextView mTvDatas;
        @BindView(R.id.tv_data)
        TextView mTvData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface setDelItemListener{
        void setDelItemListener(int pos);
    }
    public void setDelItemListener(setDelItemListener time){

        this.time = time;
    }
    public interface seonclckListener{
        void seonclckListener(int pos);
    }
    public void seonclckListener(seonclckListener times){

        this.times = times;
    }
    public interface setonclick{
        void setonclick(int pos);
    }
    public void setonclick(setonclick user){

        this.user = user;
    }
}
