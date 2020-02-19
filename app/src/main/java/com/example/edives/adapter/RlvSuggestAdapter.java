package com.example.edives.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.edives.R;
import com.example.edives.activity.SuggestionsActivity;
import com.example.edives.bean.SuggestBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvSuggestAdapter extends RecyclerView.Adapter<RlvSuggestAdapter.ViewHolder> {
    private final SuggestionsActivity activity;
    private final ArrayList<SuggestBean.DataBean> list;
    private int indext = -1;
    private setonclick time;

    public RlvSuggestAdapter(SuggestionsActivity activity, ArrayList<SuggestBean.DataBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_suggest,null);
        final ViewHolder holder =  new ViewHolder(inflate);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time != null) {
                    indext = holder.getAdapterPosition();
                    holder.mIvXuanzhong.setVisibility(View.VISIBLE);
                    time.setonclick(indext);
                    notifyDataSetChanged();
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.mTvName.setText(list.get(i).getQuestionName());
//        viewHolder.itemView.setSelected(indext == i);

//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                if (time != null) {
//
//                        time.setonclick(i);
//
//                }
//            }
//        });
        if (indext == i) {
            viewHolder.mIvXuanzhong.setVisibility(View.VISIBLE);
        }else {
            viewHolder.mIvXuanzhong.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.iv_xuanzhong)
        ImageView mIvXuanzhong;
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
