package com.example.edive.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.edive.R;
import com.example.edive.design.GlideRoundTransform;

import java.util.List;


public class QuestionFeedbackAdapter extends RecyclerView.Adapter<QuestionFeedbackAdapter.ViewHolder> {
    private Context mContext;
    private List<String> mData;
    private setonclick time;

    public QuestionFeedbackAdapter(Context pContext, List<String> pData) {
        mContext = pContext;
        mData = pData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.question_feed_back_adapter_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (position != mData.size()) {
            holder.iv_close.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(mData.get(position))
                    .transform(new GlideRoundTransform(mContext, 15)).into(holder.mImage);
            holder.iv_close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (time != null) {
                        time.setonclick(position);
                    }
                }
            });
        } else {
            holder.iv_close.setVisibility(View.GONE);
            Glide.with(mContext).load(ContextCompat.getDrawable(mContext, R.mipmap.tianjiazhaopian)).apply
                    (new RequestOptions().transform(new GlideRoundTransform(mContext, 15))).into(holder.mImage);
            holder.mImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) mOnItemClickListener.onItemClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() + 1 : 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImage;
        ImageView iv_close;

        public ViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.photo);
            iv_close = itemView.findViewById(R.id.iv_close);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int pos);
    }

    public OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener pOnItemClickListener) {
        this.mOnItemClickListener = pOnItemClickListener;
    }
    public interface setonclick{
        void setonclick(int pos);
    }
    public void setonclick(setonclick time){

        this.time = time;
    }
}
