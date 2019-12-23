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
import com.example.edive.bean.AlbumBean;
import com.example.edive.design.GlideRoundTransform;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvAlbumAdapter extends RecyclerView.Adapter<RlvAlbumAdapter.ViewHolder> {
    private final FragmentActivity activity;
    private final ArrayList<AlbumBean.DataBean.ListBean> list;
    private ArrayList<String> strList;
    private setonclick time;

    public RlvAlbumAdapter(FragmentActivity activity, ArrayList<AlbumBean.DataBean.ListBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_albumlist, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        String picture = list.get(i).getPicture();
        strList = new ArrayList<>();
        String[] split = picture.split(",");
        for (int j = 0; j < split.length; j++) {
            strList.add(split[j]);
        }
        viewHolder.mTvphoto.setText(list.get(i).getPictureNum()+"张");
        Glide.with(activity).load(strList.get(0)).transform(new CenterCrop(),new GlideRoundTransform(activity,6)).error(R.mipmap.bg).placeholder(R.mipmap.bg).into(viewHolder.mIvShow);
        viewHolder.mIvShow.setOnClickListener(new View.OnClickListener() {
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
        @BindView(R.id.tv_photo)
        TextView mTvphoto;
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
