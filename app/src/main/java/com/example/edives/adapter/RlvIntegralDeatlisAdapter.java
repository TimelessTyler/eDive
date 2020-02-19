package com.example.edives.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.edives.R;
import com.example.edives.activity.IntegralDeatlisActivity;
import com.example.edives.bean.IntegralDeatlisBean;
import com.example.edives.design.GlideRoundTransform;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvIntegralDeatlisAdapter extends RecyclerView.Adapter<RlvIntegralDeatlisAdapter.ViewHolder> {
    private final IntegralDeatlisActivity activity;
    private final ArrayList<IntegralDeatlisBean.DataBean> list;
    private setonclick time;

    public RlvIntegralDeatlisAdapter(IntegralDeatlisActivity activity, ArrayList<IntegralDeatlisBean.DataBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_intgral_detalsi, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.mTvIntegral.setText(list.get(i).getIntegral()+"积分");
        viewHolder.mTvName.setText(list.get(i).getName());
        viewHolder.mTvShoptext.setText("商品介绍");
        Glide.with(activity).load(list.get(i).getIntroduce()).transform(new GlideRoundTransform(activity, 4)).placeholder(R.mipmap.bg).into(viewHolder.mIvShow);
        viewHolder.mBtok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(activity, ExchangeIntegralDeatilsActivity.class);
//                intent.putParcelableArrayListExtra("in",list);
//                activity.startActivity(intent);
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

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.tv_Integral)
        TextView mTvIntegral;
        @BindView(R.id.tv_shoptext)
        TextView mTvShoptext;
        @BindView(R.id.iv_show)
        ImageView mIvShow;
        @BindView(R.id.bt_ok)
        Button mBtok;
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
