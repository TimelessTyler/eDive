package com.example.edives.activity;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.edives.R;
import com.example.edives.adapter.VpMyorderAdapter;
import com.example.edives.fragment.orderfragment.AllFragment;
import com.example.edives.fragment.orderfragment.FinishedFragment;
import com.example.edives.fragment.orderfragment.IntegralOutFragment;
import com.example.edives.fragment.orderfragment.PendingPaymentFragment;
import com.example.edives.fragment.orderfragment.TobeShippedFragment;
import com.example.edives.frame.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyOrder extends BaseActivity {

    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    private ArrayList<Fragment> fs;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.app_setting));
        }
        setContentView(R.layout.activity_my_order);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        fs = new ArrayList<>();
        fs.add(new IntegralOutFragment());//待付款
        fs.add(new AllFragment());//待完成
        fs.add(new PendingPaymentFragment());//待评价
        fs.add(new TobeShippedFragment());//已完成
        fs.add(new FinishedFragment());//已关闭
        mTab.addTab(mTab.newTab().setText("待付款"));
        mTab.addTab(mTab.newTab().setText("待完成"));
        mTab.addTab(mTab.newTab().setText("待评价"));
        mTab.addTab(mTab.newTab().setText("已完成"));
        mTab.addTab(mTab.newTab().setText("已关闭"));
        VpMyorderAdapter vpMyorderAdapter = new VpMyorderAdapter(getSupportFragmentManager(), fs);
        mVp.setAdapter(vpMyorderAdapter);
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
        mTab.setTabIndicatorFullWidth(false);
        mTab.setSelectedTabIndicatorHeight(0);
    }
}
