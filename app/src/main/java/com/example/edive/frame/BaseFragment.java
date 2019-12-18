package com.example.edive.frame;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.edive.R;
import com.example.edive.design.LoadingDialogWithContent;
import com.example.edive.utils.NormalConfig;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import static com.scwang.smartrefresh.layout.util.DensityUtil.px2dp;

public class BaseFragment extends Fragment {
    public LinearLayoutManager mManager;
    private LoadingDialogWithContent mDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDialog = new LoadingDialogWithContent(getActivity(), getString(R.string.loading));
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    public void showToast(String content) {
        Toast.makeText(getContext().getApplicationContext(), content, Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(String content) {
        Toast.makeText(getContext().getApplicationContext(), content, Toast.LENGTH_LONG).show();
    }
    public void showLoadingDialog() {
         if (!mDialog.isShowing()) mDialog.show();
    }

    public void hideLoadingDialog() {
        if (mDialog.isShowing()) mDialog.dismiss();
    }

    public void initRecycleView(RecyclerView recyclerView, RefreshLayout refreshLayout) {
        mManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mManager);
        if (refreshLayout != null) {
            refreshLayout.setHeaderHeight(px2dp(120));
            refreshLayout.setFooterHeight(px2dp(100));
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    refresh();
                }
            });
            refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    loadMore();
                }
            });
        }
    }

    public void refresh() {
    }

    public void loadMore() {
    }
    public void showLog(String content) {
        Log.e(NormalConfig.log1, content);
    }

    public void showLog(boolean content) {
        Log.e(NormalConfig.log1, "" + content);
    }
}
