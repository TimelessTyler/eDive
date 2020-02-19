package com.example.edives.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.edives.R;
import com.example.edives.adapter.VpAuditAdapter;
import com.example.edives.fragment.AuditfailedFragment;
import com.example.edives.fragment.AuditpassFragment;
import com.example.edives.fragment.TobeauditedFragment;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.HomeModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyauditActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.fl)
    ViewPager mVp;
    private ArrayList<Fragment> fs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.app_setting));
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_myaudit;
    }

    @Override
    public void initView() {
        fs = new ArrayList<>();
        fs.add(new TobeauditedFragment());
        fs.add(new AuditpassFragment());
        fs.add(new AuditfailedFragment());
        mTab.addTab(mTab.newTab().setText("待审核"));
        mTab.addTab(mTab.newTab().setText("审核通过"));
        mTab.addTab(mTab.newTab().setText("审核未通过"));
        VpAuditAdapter vpAuditAdapter = new VpAuditAdapter(getSupportFragmentManager(), fs);
        mVp.setAdapter(vpAuditAdapter);
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
    }

    @Override
    public void initData() {

    }

    @Override
    public HomeModel getModel() {
        return new HomeModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }
}
