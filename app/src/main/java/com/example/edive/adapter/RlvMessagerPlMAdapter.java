package com.example.edive.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.edive.R;
import com.example.edive.activity.DynamicDetailsActivity;
import com.example.edive.bean.AllCommentBean;
import com.example.edive.design.RoundOrCircleImage;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvMessagerPlMAdapter extends RecyclerView.Adapter<RlvMessagerPlMAdapter.Viewholder> {
    private final DynamicDetailsActivity activity;
    private final ArrayList<AllCommentBean.DataBean.ListBean> list;

    public RlvMessagerPlMAdapter(DynamicDetailsActivity activity, ArrayList<AllCommentBean.DataBean.ListBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_dynamicdetails_button, null);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
        Glide.with(activity).load(list.get(i).getCommentHeadPortrait()).placeholder(R.mipmap.morentouxiang).into(viewholder.mIvphoto);
        viewholder.mTvPlName.setText(list.get(i).getCommentName());
        viewholder.mTvPlText.setText(list.get(i).getContent());
        viewholder.mTvTime.setText(list.get(i).getCreateTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_photo)
        RoundOrCircleImage mIvphoto;
        @BindView(R.id.tv_pl_name)
        TextView mTvPlName;
        @BindView(R.id.tv_pl_text)
        TextView mTvPlText;
        @BindView(R.id.tv_time)
        TextView mTvTime;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
