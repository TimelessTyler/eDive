package com.example.edives.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.edives.R;
import com.example.edives.activity.RefundscheduleActivity;
import com.example.edives.design.GlideRoundTransform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvRefundAdapter extends RecyclerView.Adapter<RlvRefundAdapter.ViewHolder> {
    private final RefundscheduleActivity activity;
    private final List<String> list;

    public RlvRefundAdapter(RefundscheduleActivity activity, List<String> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_fund, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(activity).load(list.get(i)).transform(new CenterCrop(),new GlideRoundTransform(activity,5)).into(viewHolder.mIvTk);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_tk)
        ImageView mIvTk;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
