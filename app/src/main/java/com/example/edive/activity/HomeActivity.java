package com.example.edive.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.edive.R;
import com.example.edive.fragment.ClubFragment;
import com.example.edive.fragment.HomeFragment;
import com.example.edive.fragment.PersonalFragment;
import com.example.edive.fragment.ScheduleFragment;
import com.example.edive.fragment.ShoppingFragment;
import com.example.edive.frame.BaseActivity;
import com.example.edive.utils.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.fl)
    FrameLayout mFl;
    @BindView(R.id.rb_home)
    RadioButton mRbHome;
    @BindView(R.id.rb_club)
    RadioButton mRbClub;
    @BindView(R.id.rb_schedule)
    RadioButton mRbSchedule;
    @BindView(R.id.rb_shopping)
    RadioButton mRbShopping;
    @BindView(R.id.rb_personal)
    RadioButton mRbPersonal;
    @BindView(R.id.rg)
    RadioGroup mRg;
    private ArrayList<Fragment> fs;
    private FragmentManager fragmentManager;
    private int mpostion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        initview();
    }

    private void initview() {
        fs = new ArrayList<>();
        fs.add(new HomeFragment());
        fs.add(new ClubFragment());
        fs.add(new ScheduleFragment());
        fs.add(new ShoppingFragment());
        fs.add(new PersonalFragment());
        switchfragment(0);
    }


    @OnClick({R.id.rb_home, R.id.rb_club, R.id.rb_schedule, R.id.rb_shopping, R.id.rb_personal})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rb_home:
                switchfragment(0);
                break;
            case R.id.rb_club:
                switchfragment(1);
                break;
            case R.id.rb_schedule:
                switchfragment(2);
                break;
            case R.id.rb_shopping:
                switchfragment(3);
                break;
            case R.id.rb_personal:
                switchfragment(4);
                break;
        }
    }


    private void switchfragment(int i) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = fs.get(i);
        if (!fragment.isAdded()) {
            transaction.add(R.id.fl, fragment);
        }
        transaction.hide(fs.get(mpostion));
        transaction.show(fragment);
        transaction.commit();
        mpostion = i;
    }
    protected void setStatusBar() {
        //这里做了两件事情，1.使状态栏透明并使contentView填充到状态栏 2.预留出状态栏的位置，防止界面上的控件离顶部靠的太近。这样就可以实现开头说的第二种情况的沉浸式状态栏了
        StatusBarUtil.setTranslucentStatus(this);
    }
}
