package com.example.edive.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.edive.R;
import com.example.edive.bean.NewDynamicBean;
import com.example.edive.design.GlideRoundTransform;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvNewDynamicAdapter extends RecyclerView.Adapter<RlvNewDynamicAdapter.ViewHolder> {


    private final FragmentActivity activity;
    private ArrayList<NewDynamicBean.DataBean.ListBean> list;
    private setonclick time;
    private ArrayList<String> strList;
    private String string;

    public RlvNewDynamicAdapter(FragmentActivity activity, ArrayList<NewDynamicBean.DataBean.ListBean> list) {

        this.activity = activity;
        this.list = list;
    }

    public void setData(ArrayList<NewDynamicBean.DataBean.ListBean> data) {
        list = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_newdynamic, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        strList = new ArrayList<>();
        String dynamicPicture = list.get(i).getDynamicPicture();
        if (!TextUtils.isEmpty(dynamicPicture)) {
            String[] split = dynamicPicture.split(",");
            for (int j = 0; j < split.length; j++) {
                strList.add(split[j]);
            }
            string = strList.get(0);
        }
        Glide.with(activity).load(string).transform(new CenterCrop(),new GlideRoundTransform(activity,3)).placeholder(R.mipmap.bg).into(viewHolder.mIvNoe);
        viewHolder.mIvNoe.setOnClickListener(new View.OnClickListener() {
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
        @BindView(R.id.iv_noe)
        ImageView mIvNoe;
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
    public void refresh(List<NewDynamicBean.DataBean.ListBean> addList) {
        //增加数据
        int position = list.size();
        list.addAll(position, addList);
        notifyDataSetChanged();
    }

}
