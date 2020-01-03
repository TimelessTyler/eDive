package com.example.edives.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.edives.R;
import com.example.edives.fragment.ClubFragment;
import com.example.edives.fragment.HomeFragment;
import com.example.edives.fragment.PersonalFragment;
import com.example.edives.fragment.ScheduleFragment;
import com.example.edives.fragment.ShoppingFragment;
import com.example.edives.frame.BaseActivity;
import com.example.edives.utils.StatusBarUtil;

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
    @BindView(R.id.home_fb_iv)
    ImageView mHomeFbIv;
    private ArrayList<Fragment> fs;
    private FragmentManager fragmentManager;
    private int mpostion;
    private PopupWindow popupWindow;

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


    @OnClick({R.id.rb_home, R.id.rb_club, R.id.rb_schedule, R.id.rb_shopping, R.id.rb_personal, R.id.home_fb_iv})
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
            case R.id.rb_shopping:
                switchfragment(2);
                break;
            case R.id.rb_personal:
                switchfragment(4);
                break;
            case R.id.home_fb_iv:
                initpopo();
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
    private void initpopo() {
        View inflate1 = LayoutInflater.from(this).inflate(R.layout.layout_popo, null);
        ImageView iv_back = inflate1.findViewById(R.id.iv_back);
        TextView tv_photo = inflate1.findViewById(R.id.tv_photo);
        TextView tv_video = inflate1.findViewById(R.id.tv_video);
        TextView tv_ficate = inflate1.findViewById(R.id.tv_ficate);
        TextView tv_divingcreater = inflate1.findViewById(R.id.tv_divingcreater);
        popupWindow = new PopupWindow(inflate1, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        //手动设置 PopupWindow 响应返回键并关闭的问题
//        popupWindow.setFocusable(true);
//        popupWindow.setFocusableInTouchMode(true);  //为了保险起见加上这句
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // www.linuxidc.com响应返回键必须的语句

        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(R.style.PopupAnimation);
        popupWindow.showAtLocation(inflate1, Gravity.CENTER, 0, 0);
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = 0.7f;
        this.getWindow().setAttributes(lp);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = HomeActivity.this.getWindow().getAttributes();
                lp.alpha = 1f;
                HomeActivity.this.getWindow().setAttributes(lp);
            }
        });
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        tv_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PublishDynamicActivity.class);
//                intent.putExtra("name","选择位置");
//                intent.putExtra("topicname","话题");
                startActivity(intent);
                popupWindow.dismiss();
            }
        });
        tv_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,PublishVideoActivity.class));
                popupWindow.dismiss();
            }
        });
        tv_ficate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //学证
                startActivity(new Intent(HomeActivity.this,AcademicEvidenceActivity.class));
                popupWindow.dismiss();
            }
        });
        tv_divingcreater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //潜水游
                startActivity(new Intent(HomeActivity.this,DivingTourActivity.class));
                popupWindow.dismiss();
            }
        });
    }
}
