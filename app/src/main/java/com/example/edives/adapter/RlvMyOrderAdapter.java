package com.example.edives.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.edives.R;
import com.example.edives.bean.OrderBean;
import com.example.edives.design.GlideRoundTransform;
import com.example.edives.design.RoundImage;
import com.example.edives.design.RoundOrCircleImage;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvMyOrderAdapter extends RecyclerView.Adapter<RlvMyOrderAdapter.ViewHolder> {
    private final FragmentActivity activity;
    private final ArrayList<OrderBean.ResultBean.ListBean> list;
    private setonclick time;
    private setontextclick times;
    private setonpinjiaclick pingja;

    public RlvMyOrderAdapter(FragmentActivity activity, ArrayList<OrderBean.ResultBean.ListBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_order, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        int status = list.get(i).getStatus();
        int productType = list.get(i).getProductType();
//        if (productType == 3&&status==3) {
//            viewHolder.mRltuikuan.setVisibility(View.GONE);
//        }
        viewHolder.mTvOrderNum.setText("订单编号："+list.get(i).getOrderSn());
        viewHolder.mTvCoDj.setText("V"+list.get(i).getCoachGrade()+"");
        Glide.with(activity).load(list.get(i).getUserIcon()).placeholder(R.mipmap.bg).into(viewHolder.mIvCoShow);
        Glide.with(activity).load(list.get(i).getProductPic()).transform(new CenterCrop(),new GlideRoundTransform(activity,5)).placeholder(R.mipmap.bg).into(viewHolder.mIvShow);
        viewHolder.mTvCoName.setText(list.get(i).getNickname()+"");
        viewHolder.mTvPicse.setText("￥"+list.get(i).getPayAmount()+"");
        viewHolder.mTvText.setText(list.get(i).getProductTitle());
        if (status == 0) {
            viewHolder.mTvState.setTextColor(activity.getResources().getColor(R.color.read));
            viewHolder.mTvState.setText("待付款");
//            viewHolder.mTvApplyTk.setText("付款");
        } else if (status == 1) {
            viewHolder.mTvState.setTextColor(activity.getResources().getColor(R.color.color_dfk));
            viewHolder.mTvState.setText("已付款");
//            viewHolder.mTvApplyTk.setText("申请退款");
        } else if (status == 2) {
            viewHolder.mTvState.setTextColor(activity.getResources().getColor(R.color.color_jxz));
            viewHolder.mTvState.setText("进行中");
//            viewHolder.mTvApplyTk.setText("确认完成");
//            viewHolder.mTvApplyTk.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (times != null) {
//                        times.setontextclick(i);
//                    }
//                }
//            });
        } else if (status == 3) {
            viewHolder.mTvState.setTextColor(activity.getResources().getColor(R.color.blue));
            viewHolder.mTvState.setText("已完成");
//            viewHolder.mTvApplyTk.setText("评价");
//            viewHolder.mTvApplyTk.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (pingja != null) {
//                        pingja.setontextclick(i);
//                    }
//                }
//            });
        } else if (status == 4) {
            viewHolder.mTvState.setTextColor(activity.getResources().getColor(R.color.color_dfk));
            viewHolder.mTvState.setText("已关闭");
        } else if (status == 5) {
            if (list.get(i).getReturnStatus() == 0) {
                viewHolder.mTvState.setTextColor(activity.getResources().getColor(R.color.color_dfk));
                viewHolder.mTvState.setText("待处理");
            } else if (list.get(i).getReturnStatus() == 1) {
                viewHolder.mTvState.setTextColor(activity.getResources().getColor(R.color.color_dfk));
                viewHolder.mTvState.setText("退款中");
            } else if (list.get(i).getReturnStatus() == 2) {
                viewHolder.mTvState.setTextColor(activity.getResources().getColor(R.color.colorPrimary));
                viewHolder.mTvState.setText("已完成");
            } else if (list.get(i).getReturnStatus() == 3) {
                viewHolder.mTvState.setTextColor(activity.getResources().getColor(R.color.read));
                viewHolder.mTvState.setText("已拒绝");
            }


//            viewHolder.mRltuikuan.setVisibility(View.GONE);
        } else if (status == 6) {
            viewHolder.mTvState.setTextColor(activity.getResources().getColor(R.color.color_tk));
            viewHolder.mTvState.setText("退款中");
//            viewHolder.mRltuikuan.setVisibility(View.GONE);
        }
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
//        @BindView(R.id.tv_apply_tk)
//        TextView mTvApplyTk;
        @BindView(R.id.iv_show)
        ImageView mIvShow;
        @BindView(R.id.iv_co_show)
        RoundImage mIvCoShow;
        @BindView(R.id.tv_co_name)
        TextView mTvCoName;
        @BindView(R.id.tv_co_dj)
        TextView mTvCoDj;
        @BindView(R.id.tv_state)
        TextView mTvState;
        @BindView(R.id.tv_picse)
        TextView mTvPicse;
        @BindView(R.id.tv_text)
        TextView mTvText;
        @BindView(R.id.rl)
        RelativeLayout mRl;
        @BindView(R.id.tv_order_num)
        TextView mTvOrderNum;
        @BindView(R.id.rl_item)
        RelativeLayout item;
//        @BindView(R.id.rl_tuikuan)
//        RelativeLayout mRltuikuan;
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
    public interface setontextclick{
        void setontextclick(int pos);
    }
    public void setontextclick(setontextclick times){

        this.times = times;
    }
    public interface setonpinjiaclick{
        void setontextclick(int pos);
    }
    public void setonpinjiaclick(setonpinjiaclick pingja){

        this.pingja = pingja;
    }
}
