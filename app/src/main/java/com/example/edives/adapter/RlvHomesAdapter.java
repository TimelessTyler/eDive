package com.example.edives.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.edives.R;
import com.example.edives.bean.BannerInfo;
import com.example.edives.design.GlideRoundTransform;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class RlvHomesAdapter extends RecyclerView.Adapter<RlvHomesAdapter.ViewHolder>{


    private final FragmentActivity activity;
    private final ArrayList<BannerInfo.DataBean> list;

    public RlvHomesAdapter(FragmentActivity activity, ArrayList<BannerInfo.DataBean> list) {

        this.activity = activity;
        this.list = list;
    }


    @NonNull
    @Override
    public RlvHomesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View inflate = LayoutInflater.from(activity).inflate(R.layout.item_ban, null);
            return new ViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull RlvHomesAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bann.setIndicatorGravity(BannerConfig.CIRCLE_INDICATOR);
            viewHolder.bann.setImages(list).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    BannerInfo.DataBean bean = (BannerInfo.DataBean) path;
                    Glide.with(context).load(bean.getPic()).transform(new CenterCrop(),new GlideRoundTransform(activity,8)).into(imageView);
                }
            }).start();
            viewHolder.bann.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {

                }
            });
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private final Banner bann;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bann = itemView.findViewById(R.id.bann);
        }
    }
}
