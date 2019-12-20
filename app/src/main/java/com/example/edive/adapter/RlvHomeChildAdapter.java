package com.example.edive.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.edive.R;
import com.example.edive.bean.TopicBean;
import com.example.edive.design.GlideRoundTransform;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvHomeChildAdapter extends RecyclerView.Adapter<RlvHomeChildAdapter.ViewHolder> {
    private final FragmentActivity activity;
    private final ArrayList<TopicBean.DataBean> list;
    private setonclick click;

    public RlvHomeChildAdapter(FragmentActivity activity, ArrayList<TopicBean.DataBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_home_child, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.mTvConversationName.setText("#"+list.get(i).getTopicName());
        Glide.with(activity).load(list.get(i).getTopicPicture()).transform(new CenterCrop(),new GlideRoundTransform(activity,4)).placeholder(R.mipmap.bg).into(viewHolder.mIvConversationPhoto);
        viewHolder.mIvConversationPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click != null) {
                    click.setonclick(v,list.get(i).getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_conversation_photo)
        ImageView mIvConversationPhoto;
        @BindView(R.id.tv_conversation_name)
        TextView mTvConversationName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public interface setonclick{
        void setonclick(View view, int pos);
    }
    public void setonclick(setonclick click){

        this.click = click;
    }
}
