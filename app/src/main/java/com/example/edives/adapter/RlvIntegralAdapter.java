package com.example.edives.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.edives.R;
import com.example.edives.bean.IntegralBean;
import com.example.edives.design.GlideRoundTransform;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvIntegralAdapter extends RecyclerView.Adapter<RlvIntegralAdapter.ViewHolder> {
    private Context activity;
    private ArrayList<IntegralBean.DataBean.ListBean> list;
    private setonclick time;
    private ArrayList<String> strList;
    private String pic;

    public RlvIntegralAdapter(Context activity, ArrayList<IntegralBean.DataBean.ListBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_integral, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.mTvTitle.setText(list.get(i).getName());
        viewHolder.mTvIntegral.setText(list.get(i).getIntegral()+"积分");
        strList = new ArrayList<>();
        String dynamicPicture = list.get(i).getPicture();
        if (!TextUtils.isEmpty(dynamicPicture)) {
            String[] split = dynamicPicture.split(",");
            for (int j = 0; j < split.length; j++) {
                strList.add(split[j]);
            }
            pic = strList.get(0);
        }
        Glide.with(activity).load(pic).transform(new CenterCrop(), new GlideRoundTransform(activity, 4)).placeholder(R.mipmap.bg).into(viewHolder.mIvPhoto);
        viewHolder.mBtGotorh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.setonclick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_photo)
        ImageView mIvPhoto;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_integral)
        TextView mTvIntegral;
        @BindView(R.id.bt_gotorh)
        TextView mBtGotorh;

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
