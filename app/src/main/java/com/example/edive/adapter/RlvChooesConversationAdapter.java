package com.example.edive.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.edive.R;
import com.example.edive.activity.ChooesConversationActivity;
import com.example.edive.bean.ConversationBean;
import com.example.edive.design.GlideRoundTransform;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvChooesConversationAdapter extends RecyclerView.Adapter<RlvChooesConversationAdapter.ViewHolder> {
    private final ChooesConversationActivity activity;
    private final ArrayList<ConversationBean.DataBean.ListBean> list;
    private setonclick time;

    public RlvChooesConversationAdapter(ChooesConversationActivity activity, ArrayList<ConversationBean.DataBean.ListBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_conversation, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(activity).load(list.get(i).getTopicPicture()).transform(new CenterCrop(),new GlideRoundTransform(activity,6)).placeholder(R.mipmap.bg).into(viewHolder.mIvShow);
        viewHolder.mTvTopName.setText(list.get(i).getTopicName());
        viewHolder.mTvNum.setText(list.get(i).getTopicNum()+"动态");
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
        @BindView(R.id.iv_show)
        ImageView mIvShow;
        @BindView(R.id.tv_top_name)
        TextView mTvTopName;
        @BindView(R.id.tv_num)
        TextView mTvNum;
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
}
