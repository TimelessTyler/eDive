package com.example.edives.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.edives.R;
import com.example.edives.activity.LocationActivity;
import com.example.edives.bean.LocationInfo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvLocationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LocationActivity activity;
    private final ArrayList<LocationInfo> list;
    private int pos;
    private setonclick time;
    private setonclickListent onclick;

    public RlvLocationAdapter(LocationActivity activity, ArrayList<LocationInfo> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        }else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1) {
            View inflate = LayoutInflater.from(activity).inflate(R.layout.item_location, null);
            return new ViewHolder1(inflate);
        }else {
            View inflate = LayoutInflater.from(activity).inflate(R.layout.item_location_data, null);
            return new ViewHolder2(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int viewType = getItemViewType(i);
        if (viewType == 1) {
            ViewHolder1 viewHolder1 = (ViewHolder1) viewHolder;
            viewHolder1.mTvLocation.setTextColor(activity.getResources().getColor(R.color.blue));

        }else {
            pos = i-1;
            ViewHolder2 viewHolder2 = (ViewHolder2) viewHolder;
            viewHolder2.mTvLocationName.setText(list.get(pos).getAddress());
//            viewHolder2.mTvLocationName.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (onclick != null) {
//                        onclick.setonclickListent(pos,list.get(pos).getAddress());
//                    }
//                }
//            });
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time != null) {
                    time.setonclick(i-1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_location)
        TextView mTvLocation;
        @BindView(R.id.ll)
        LinearLayout mLl;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_location_name)
        TextView mTvLocationName;
        @BindView(R.id.Lll)
        LinearLayout mLll;
        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface setonclick{
        void setonclick(int pos);
    }
    public void setonclcik(setonclick time){
        this.time = time;
    }

    public interface setonclickListent{
        void setonclickListent(int pos, String msg);
    }
    public void setonclickListent(setonclickListent onclick){

        this.onclick = onclick;
    }

}
