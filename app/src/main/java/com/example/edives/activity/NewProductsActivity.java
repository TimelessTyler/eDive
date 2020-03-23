package com.example.edives.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.edives.R;
import com.example.edives.design.CommonTitle;
import com.example.edives.fragment.GroupFragment;
import com.example.edives.fragment.OrdinaryFragment;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.HomeModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewProductsActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.title)
    CommonTitle mTitle;
    @BindView(R.id.rb_scuba)
    RadioButton mRbScuba;
    @BindView(R.id.rb_free)
    RadioButton mRbFree;
    @BindView(R.id.rg)
    RadioGroup mRg;
    @BindView(R.id.fl)
    FrameLayout mFl;
    @BindView(R.id.bt_ok)
    Button mBtOk;
    private ArrayList<Fragment> fs;
    private FragmentManager fragmentManager;
    private int mpostion;

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
        return R.layout.activity_new_products;
    }

    @Override
    public void initView() {
        fragmentManager = getSupportFragmentManager();
        fs = new ArrayList<>();
        fs.add(new OrdinaryFragment());
        fs.add(new GroupFragment());
        switchfragment(0);
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

    @OnClick({R.id.rb_scuba, R.id.rb_free, R.id.bt_ok})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
                //普通产品
            case R.id.rb_scuba:
switchfragment(0);
                break;
                //组团产品
            case R.id.rb_free:
switchfragment(1);
                break;
                //确认发布
            case R.id.bt_ok:
                break;
        }
    }
}
