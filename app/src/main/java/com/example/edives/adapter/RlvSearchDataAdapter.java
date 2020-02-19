package com.example.edives.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.edives.R;
import com.example.edives.activity.SearchActivity;
import com.example.edives.bean.SearchBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvSearchDataAdapter extends RecyclerView.Adapter<RlvSearchDataAdapter.ViewHolder> {
    private final SearchActivity activity;
    private final ArrayList<SearchBean.DataBean.ListBean> list;
    private int type;
    private setonclick time;

    public RlvSearchDataAdapter(SearchActivity activity, ArrayList<SearchBean.DataBean.ListBean> list, int type) {

        this.activity = activity;
        this.list = list;
        this.type = type;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_search_data, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        if (type == 1) {
            viewHolder.mTvName.setText(list.get(i).getDynamicContent());
            viewHolder.mLl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (time != null) {
                        time.setonclick(i);
                    }
                }
            });
        } else if (type == 2) {
//            viewHolder.mTvName.setText(list.get(i).gettitle());
            viewHolder.mLl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (time != null) {
                        time.setonclick(i);
                    }
                }
            });
        } else if (type == 3) {
            viewHolder.mTvName.setText(list.get(i).getTopicName());
            viewHolder.mLl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (time != null) {
                        time.setonclick(i);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.ll)
        LinearLayout mLl;
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
