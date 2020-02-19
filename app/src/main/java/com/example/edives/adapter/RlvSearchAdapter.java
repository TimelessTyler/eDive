package com.example.edives.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.edives.R;
import com.example.edives.activity.SearchActivity;
import com.example.edives.bean.SearchDataBean;
import com.example.edives.design.FlowLayout;

import java.util.ArrayList;

public class RlvSearchAdapter extends RecyclerView.Adapter<RlvSearchAdapter.ViewHolder> {
    private final SearchActivity activity;
    private final ArrayList<SearchDataBean.DataBean> list;
    private setonclick time;
    private ArrayList<String> arrayList;
    private int psoti;

    public RlvSearchAdapter(SearchActivity activity, ArrayList<SearchDataBean.DataBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_search, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        for (int a = 0; a < list.size(); a++) {
            TextView inflate = (TextView) LayoutInflater.from(activity).inflate(R.layout.textive, null);
            inflate.setText(list.get(a).getName());
            viewHolder.fls.addView(inflate);
//            final int finalA = a;
//            viewHolder.fls.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    time.setonclick(finalA);
//                }
//            });
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final FlowLayout fls;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fls = itemView.findViewById(R.id.fl_flow);
        }
    }
    public interface setonclick{
        void setonclick(int pos);
    }
    public void setonclick(setonclick time){
        this.time = time;
    }
}
