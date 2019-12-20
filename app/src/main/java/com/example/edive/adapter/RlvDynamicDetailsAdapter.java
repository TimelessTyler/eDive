package com.example.edive.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.edive.R;
import com.example.edive.activity.DynamicDetailsActivity;
import com.example.edive.bean.AllCommentBean;
import com.example.edive.bean.DynamicDetailsBean;
import com.example.edive.design.RoundOrCircleImage;
import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvDynamicDetailsAdapter extends RecyclerView.Adapter<RlvDynamicDetailsAdapter.ViewHolder> {
    private final DynamicDetailsActivity activity;
    private final ArrayList<DynamicDetailsBean.DataBean> list;
    private ArrayList<AllCommentBean.DataBean.ListBean> commentList;
    private int integer;
    private int postion;
    private setfollowonclick follow;
    private setlikeonclick likes;
    private setnotfollowonclick follows;
    private ArrayList<String> strList;
    private RlvTopicChinalAdapter chinalAdapter;
    private setnolikeonclick like;
    private setonzhuanfa zhuanfa;
    private setonclickListent onclick;

    public RlvDynamicDetailsAdapter(DynamicDetailsActivity activity, ArrayList<DynamicDetailsBean.DataBean> list, ArrayList<AllCommentBean.DataBean.ListBean> commentList, Integer integer) {

        this.activity = activity;
        this.list = list;
        this.commentList = commentList;
        this.integer = integer;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_dynamicdetails_top, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final RlvDynamicDetailsAdapter.ViewHolder viewHolder1, final int i) {
        Glide.with(activity).load(list.get(i).getDynamicHeadPortrait()).error(R.mipmap.morentouxiang).into(viewHolder1.mIvPhoto);
        strList = new ArrayList<>();
        GridLayoutManager manager;
        String dynamicPicture = list.get(i).getDynamicPicture();
        if (!TextUtils.isEmpty(dynamicPicture)) {
            String[] split = dynamicPicture.split(",");
            for (int j = 0; j < split.length; j++) {
                strList.add(split[j]);
            }

        }
        if (strList.size() > 2) {
            manager = new GridLayoutManager(activity, 3);
        }else {
            manager = new GridLayoutManager(activity, 2);
        }
        viewHolder1.mRec.setLayoutManager(manager);
        chinalAdapter = new RlvTopicChinalAdapter(activity, strList);
        viewHolder1.mRec.setAdapter(chinalAdapter);
        chinalAdapter.setonclicksss(new RlvTopicChinalAdapter.setonclicksss() {
            @Override
            public void setonclicksss(int pos) {

            }
        });
        viewHolder1.mTvText.setText(list.get(i).getDynamicContent());
        viewHolder1.mTvName.setText(list.get(i).getDynamicAuthor());
        viewHolder1.mTvTime.setText(list.get(i).getCreateTime());
        viewHolder1.mTvDznum.setText(list.get(i).getDynamicPraise()+"赞");
        String dynamicAddress = list.get(i).getDynamicAddress();
        if (!TextUtils.isEmpty(dynamicAddress)) {
            viewHolder1.mTvWz.setText(dynamicAddress);
        }else {
            viewHolder1.mTvWz.setVisibility(View.GONE);
        }
        int userId = list.get(i).getUserId();
        if (list.get(i).getIdentification() == 0) {
            viewHolder1.mTvData.setVisibility(View.VISIBLE);
            viewHolder1.mTvDatas.setVisibility(View.GONE);
            if (integer == userId) {
                viewHolder1.mTvDatas.setVisibility(View.GONE);
                viewHolder1.mTvData.setVisibility(View.GONE);
            }
        } else if (list.get(i).getIdentification() == 1) {
            viewHolder1.mTvData.setVisibility(View.GONE);
            viewHolder1.mTvDatas.setVisibility(View.VISIBLE);
        }
        if (list.get(i).getIdentificationPraise() == 0) {
            viewHolder1.mBtLike.setVisibility(View.GONE);
            viewHolder1.mBtNoLike.setVisibility(View.VISIBLE);
        } else if (list.get(i).getIdentificationPraise() == 1) {
            viewHolder1.mBtLike.setVisibility(View.VISIBLE);
            viewHolder1.mBtNoLike.setVisibility(View.GONE);
        }
        viewHolder1.mBtLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likes.setlikeonclick(i,v);
                viewHolder1.mTvDznum.setText(list.get(i).getDynamicPraise()+1+"赞");
            }
        });
        viewHolder1.mTvData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder1.mTvDatas.setVisibility(View.VISIBLE);
                viewHolder1.mTvData.setVisibility(View.GONE);
                int userId = list.get(i).getUserId();
                follow.setfollowonclick(userId,i);
            }
        });
        viewHolder1.mTvDatas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder1.mTvData.setVisibility(View.VISIBLE);
                viewHolder1.mTvDatas.setVisibility(View.GONE);
                int userId = list.get(i).getUserId();
                follows.setnotfollowonclick(userId,i);
            }
        });
        viewHolder1.mBtNoLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = list.get(i).getId();
                viewHolder1.mBtNoLike.setVisibility(View.GONE);
                viewHolder1.mBtLike.setVisibility(View.VISIBLE);
                likes.setlikeonclick(id,v);
                viewHolder1.mTvDznum.setText(list.get(i).getDynamicPraise()+1+"赞");
            }
        });
        viewHolder1.mBtLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = list.get(i).getId();
                viewHolder1.mBtLike.setVisibility(View.GONE);
                viewHolder1.mBtNoLike.setVisibility(View.VISIBLE);
                int dynamicPraise = list.get(i).getDynamicPraise();
                viewHolder1.mTvDznum.setText(dynamicPraise+"赞");
                like.setnolikeonclick(id,v);
//                viewHolder.mBtNoLike.setVisibility(View.VISIBLE);/
//                viewHolder.mBtLike.setVisibility(View.GONE);
            }
        });
        viewHolder1.mBtZhuanfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuanfa.setonzhuanfa(i);
            }
        });
        viewHolder1.mIvPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onclick != null) {
                    onclick.setonclickListent(i);
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
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
        @BindView(R.id.hint)
        View mHint;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
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
    public interface setonzhuanfa{
        void setonzhuanfa(int pos);
    }
    public void setonzhuanfa(setonzhuanfa zhuanfa){

        this.zhuanfa = zhuanfa;
    }
    public interface setonclickListent{
        void setonclickListent(int pos);
    }
    public void setonclickListent(setonclickListent onclick){

        this.onclick = onclick;
    }
}
