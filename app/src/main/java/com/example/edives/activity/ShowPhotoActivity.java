package com.example.edives.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.edives.R;
import com.example.edives.adapter.VpPagerAdapter;
import com.example.edives.design.GlideRoundTransform;
import com.example.edives.frame.BaseActivity;
import com.github.chrisbanes.photoview.PhotoView;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowPhotoActivity extends BaseActivity {

    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    private ArrayList<String> list;
    private ArrayList<View> views;
    private VpPagerAdapter vpPagerAdapter;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.app_setting));
        }
        setContentView(R.layout.activity_show_photo);
        ButterKnife.bind(this);
        pos = getIntent().getExtras().getInt("pos");
        list = (ArrayList<String>) getIntent().getSerializableExtra("list");
        initView();

    }

    private void initView() {
        mViewpager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view == o;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int positions) {
                View adView = LayoutInflater.from(ShowPhotoActivity.this).inflate(R.layout.item_imageview, null);
                PhotoView icon = (PhotoView) adView.findViewById(R.id.photo);
                Glide.with(ShowPhotoActivity.this)
                        .load(list.get(positions))
                        .into(icon);
                container.addView(adView);
                icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                return adView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });

        mViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        mViewpager.setCurrentItem(pos, true);
    }
    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).transform(new CenterCrop(), new GlideRoundTransform(ShowPhotoActivity.this, 8)).into(imageView);
        }
    }
}
