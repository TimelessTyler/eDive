package com.example.edive.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.edive.R;
import com.example.edive.bean.NewsDynamicDeatilsBean;
import com.example.edive.design.RoundOrCircleImage;
import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvTopicNewDynamicAdapter extends RecyclerView.Adapter<RlvTopicNewDynamicAdapter.ViewHolder> {
    private final FragmentActivity activity;
    private final ArrayList<NewsDynamicDeatilsBean.DataBean.ListBean> list;
    private int integer;
    private setonclick time;
    private setlikeonclick likes;
    private setfollowonclick follow;
    private setnotfollowonclick follows;
    private ArrayList<String> strList;
    private RlvTopicChinalAdapter chinalAdapter;
    private setnolikeonclick like;
    private setonclicks timess;
    private setonclickListent onclick;

    public RlvTopicNewDynamicAdapter(FragmentActivity activity, ArrayList<NewsDynamicDeatilsBean.DataBean.ListBean> list, Integer integer) {

        this.activity = activity;
        this.list = list;
        this.integer = integer;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //                                                           item_newdynamicdeatils
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_newdynamicdeatils, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Glide.with(activity).load(list.get(i).getDynamicHeadPortrait()).error(R.mipmap.morentouxiang).into(viewHolder.mIvPhoto);
//        Glide.with(activity).load(list.get(i).get)
//        Glide.with(activity).load(list.get(i).getDynamicPicture()).placeholder(R.mipmap.morentouxiang).transform(new CenterCrop(), new GlideRoundTransform(activity, 4)).into(viewHolder.mIvShow);
        strList = new ArrayList<>();
        GridLayoutManager manager;
        String dynamicPicture = list.get(i).getDynamicPicture();
//        if (TextUtils.isEmpty(dynamicPicture)) {
            String[] split = dynamicPicture.split(",");
            for (int j = 0; j < split.length; j++) {
                strList.add(split[j]);
            }
//        }
        int userId = list.get(i).getUserId();
        if (strList.size() > 2) {
            manager = new GridLayoutManager(activity, 3);
        }else {
            manager = new GridLayoutManager(activity, 2);
        }
        viewHolder.mRec.setLayoutManager(manager);
        chinalAdapter = new RlvTopicChinalAdapter(activity, strList);
        viewHolder.mRec.setAdapter(chinalAdapter);
        chinalAdapter.setonclicksss(new RlvTopicChinalAdapter.setonclicksss() {
            @Override
            public void setonclicksss(int pos) {

            }
        });
        viewHolder.mTvText.setText(list.get(i).getDynamicContent());
//        viewHolder.mTvText.setText(list.get(i).getDynamicContent());
        viewHolder.mTvName.setText(list.get(i).getDynamicAuthor());
        viewHolder.mTvTime.setText(list.get(i).getCreateTime());
        viewHolder.mTvDznum.setText(list.get(i).getDynamicPraise()+"赞");
        String dynamicAddress = list.get(i).getDynamicAddress();
        if (!TextUtils.isEmpty(dynamicAddress)) {
            viewHolder.mTvWz.setText(dynamicAddress);
        }else {
            viewHolder.mTvWz.setVisibility(View.GONE);
        }

        if (list.get(i).getIdentification() == 0) {
            viewHolder.mTvData.setVisibility(View.VISIBLE);
            viewHolder.mTvDatas.setVisibility(View.GONE);
            if (integer == userId) {
                viewHolder.mTvDatas.setVisibility(View.GONE);
                viewHolder.mTvData.setVisibility(View.GONE);
            }
        } else if (list.get(i).getIdentification() == 1) {
            viewHolder.mTvData.setVisibility(View.GONE);
            viewHolder.mTvDatas.setVisibility(View.VISIBLE);
        }
        if (list.get(i).getIdentificationPraise() == 0) {
            viewHolder.mBtLike.setVisibility(View.GONE);
            viewHolder.mBtNoLike.setVisibility(View.VISIBLE);
        } else if (list.get(i).getIdentificationPraise() == 1) {
            viewHolder.mBtLike.setVisibility(View.VISIBLE);
            viewHolder.mBtNoLike.setVisibility(View.GONE);
        }
        viewHolder.mBtNoLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = list.get(i).getId();
                viewHolder.mBtNoLike.setVisibility(View.GONE);
                viewHolder.mBtLike.setVisibility(View.VISIBLE);
                likes.setlikeonclick(i,v);
                viewHolder.mTvDznum.setText(list.get(i).getDynamicPraise()+1+"赞");
            }
        });
        viewHolder.mBtLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = list.get(i).getId();
                viewHolder.mBtLike.setVisibility(View.GONE);
                viewHolder.mBtNoLike.setVisibility(View.VISIBLE);
                int dynamicPraise = list.get(i).getDynamicPraise();
                like.setnolikeonclick(i,v);
                viewHolder.mBtNoLike.setVisibility(View.VISIBLE);
                viewHolder.mBtLike.setVisibility(View.GONE);
                viewHolder.mTvDznum.setText(dynamicPraise+"赞");
            }
        });

        viewHolder.mTvData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.mTvDatas.setVisibility(View.VISIBLE);
                viewHolder.mTvData.setVisibility(View.GONE);
                int userId = list.get(i).getUserId();
                follow.setfollowonclick(userId,i);
            }
        });
        viewHolder.mTvDatas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.mTvData.setVisibility(View.VISIBLE);
                viewHolder.mTvDatas.setVisibility(View.GONE);
                int userId = list.get(i).getUserId();
                follows.setnotfollowonclick(userId,i);
            }
        });
        viewHolder.mRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timess != null) {
                    timess.setonclicks(i);
                }
            }
        });
        viewHolder.mBtZhuanfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time != null) {
                    time.setonclick(i);
                }
            }
        });
        viewHolder.mIvPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onclick != null) {
                    onclick.setonclickListent(i);
                }
            }
        });
//        viewHolder.mBtPingl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (time != null) {
//                    time.setonclick(i);
//                }
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rl)
        RelativeLayout mRl;
        @BindView(R.id.iv_photo)
        RoundOrCircleImage mIvPhoto;
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.tv_data)
        TextView mTvData;
        @BindView(R.id.tv_datas)
        TextView mTvDatas;
        @BindView(R.id.tv_text)
        TextView mTvText;
        @BindView(R.id.rec)
        RecyclerView mRec;
        @BindView(R.id.tv_wz)
        TextView mTvWz;
        @BindView(R.id.tv_dznum)
        TextView mTvDznum;
        @BindView(R.id.bt_zhuanfa)
        ImageView mBtZhuanfa;
        @BindView(R.id.bt_pingl)
        ShineButton mBtPingl;
        @BindView(R.id.bt_like)
        ImageView mBtLike;
        @BindView(R.id.bt_nolike)
        ImageView mBtNoLike;

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
    public interface setonclicks{
        void setonclicks(int pos);
    }
    public void setonclicks(setonclicks timess){

        this.timess = timess;
    }
    public interface setnolikeonclick{
        void setnolikeonclick(int pos, View view);
    }
    public void setnolikeonclick(setnolikeonclick like){

        this.like = like;
    }
    public interface setlikeonclick{
        void setlikeonclick(int pos, View view);
    }
    public void setlikeonclick(setlikeonclick likes){

        this.likes = likes;
    }
    public interface setfollowonclick{
        void setfollowonclick(int targetid, int pos);
    }
    public void setfollowonclick(setfollowonclick follow){

        this.follow = follow;
    }
    public interface setnotfollowonclick{
        void setnotfollowonclick(int targetid, int pos);
    }
    public void setnotfollowonclick(setnotfollowonclick follows){

        this.follows = follows;
    }
    public interface setonclickListent{
        void setonclickListent(int pos);
    }
    public void setonclickListent(setonclickListent onclick){

        this.onclick = onclick;
    }
}
