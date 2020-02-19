package com.example.edives.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.edives.R;
import com.example.edives.bean.SearchDivingBean;
import com.example.edives.design.GlideRoundTransform;
import com.example.edives.design.RoundImage;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvShoppingTripsAdapter extends RecyclerView.Adapter<RlvShoppingTripsAdapter.ViewHolder> {
    private Context activity;
    private final ArrayList<SearchDivingBean.DataBean.ListBean> list;
    private setonclick time;
    private ArrayList<String> StrList;
    private String string;

    public RlvShoppingTripsAdapter(Context activity, ArrayList<SearchDivingBean.DataBean.ListBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_shopping_tops, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        StrList = new ArrayList<>();
        String coachIcon = list.get(i).getImage();
        if (!TextUtils.isEmpty(coachIcon)) {
            String[] split = coachIcon.split(",");
            for (int j = 0; j < split.length; j++) {
                StrList.add(split[j]);
            }
            string = StrList.get(0);
        }
        Glide.with(activity).load(string).into(viewHolder.mIvShow);
        Glide.with(activity).load(list.get(i).getCoachIcon()).transform(new CenterCrop(),new GlideRoundTransform(activity,5)).error(R.mipmap.morentouxiang).into(viewHolder.mIvCoShow);
        viewHolder.mTvCoName.setText(list.get(i).getCoachName());
        viewHolder.mTvCoNum.setText("￥"+list.get(i).getPrice());
        viewHolder.mTvText.setText(list.get(i).getTitle());
        viewHolder.item.setOnClickListener(new View.OnClickListener() {
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
        @BindView(R.id.tv_text)
        TextView mTvText;
        @BindView(R.id.iv_co_show)
        RoundImage mIvCoShow;
        @BindView(R.id.tv_co_name)
        TextView mTvCoName;
        @BindView(R.id.tv_co_dj)
        TextView mTvCoDj;
        @BindView(R.id.tv_co_num)
        TextView mTvCoNum;
        @BindView(R.id.ll)
        LinearLayout item;
        public ViewHolder(@NonNull View itemView) {
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
}
