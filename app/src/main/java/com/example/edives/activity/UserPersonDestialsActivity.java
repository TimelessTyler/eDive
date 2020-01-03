package com.example.edives.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.edives.R;
import com.example.edives.bean.FollowBean;
import com.example.edives.bean.NotFollowBean;
import com.example.edives.bean.UserDatilasBean;
import com.example.edives.design.RoundImage;
import com.example.edives.fragment.AlbumFragment;
import com.example.edives.fragment.LikeUserPersonFragment;
import com.example.edives.fragment.PersonalProfileFragment;
import com.example.edives.fragment.ProductFragment;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.PersonModel;
import com.example.edives.utils.StatusBarUtil;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class UserPersonDestialsActivity extends BaseMvpActivity<PersonModel> {

    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.iv_close)
    ImageView mIvClose;
    @BindView(R.id.iv_show)
    RoundImage mIvShow;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_data)
    TextView mTvData;
    @BindView(R.id.tv_datas)
    TextView mTvDatas;
    @BindView(R.id.rl)
    RelativeLayout mRl;
    @BindView(R.id.iv_user_content)
    RadioButton mIvUserContent;
    @BindView(R.id.iv_photo_list)
    RadioButton mIvPhotoList;
    @BindView(R.id.iv_three)
    RadioButton mIvThree;
    @BindView(R.id.iv_four)
    RadioButton mIvFour;
    @BindView(R.id.ll)
    LinearLayout mLl;
    @BindView(R.id.fl)
    FrameLayout mFl;

    private ArrayList<Fragment> fs;
    private FragmentManager manager;
    private int mpostion;
    private int id;
    private ArrayList<String> strList;
    private ArrayList<Integer> arrayList;
    private int userType;
    private int favoriteType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_user_person_destials;
    }

    @Override
    public void initView() {
        id = getIntent().getExtras().getInt("id");
        userType = getIntent().getExtras().getInt("userType");
        favoriteType = getIntent().getExtras().getInt("favoriteType");
        manager = getSupportFragmentManager();
        strList = new ArrayList<>();
        fs = new ArrayList<>();
        fs.add(new PersonalProfileFragment(id,userType,favoriteType));
        fs.add(new AlbumFragment(id,userType));
        fs.add(new ProductFragment(id));
        fs.add(new LikeUserPersonFragment(id,userType,favoriteType));
        switchfragment(0);
    }
    private void switchfragment(int i) {
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = fs.get(i);
//        if (!fragment.isAdded()) {
//            transaction.add(R.id.fl,fragment);
//        }
//        transaction.hide(fs.get(mpostion));
        transaction.replace(R.id.fl,fragment);
        transaction.commit();
        mpostion = i;
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.USERDATALIS,id,userType);
    }

    @Override
    public PersonModel getModel() {
        return new PersonModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        showToast(e
                .getMessage());
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi){
            case ApiConfig.USERDATALIS:
                UserDatilasBean userDatilasBean = (UserDatilasBean) t[0];
                if (userDatilasBean.getCode() == 200) {
                    UserDatilasBean.DataBean data = userDatilasBean.getData();
                    mTvName.setText(data.getNickname());
                    Glide.with(UserPersonDestialsActivity.this).load(data.getIcon()).error(R.mipmap.morentouxiang).placeholder(R.mipmap.morentouxiang).into(mIvShow);
                    String pics = data.getPics();
                    final int userid = data.getId();
                    String s = mApplication.userid.toString();
                    Integer integer = Integer.valueOf(s);
                    int identification = data.getIdentification();
                    if (identification == 0) {
                        mTvData.setVisibility(View.VISIBLE);
                        mTvDatas.setVisibility(View.GONE);
                        if (integer == userid) {
                            mTvDatas.setVisibility(View.GONE);
                            mTvData.setVisibility(View.GONE);
                        }
                    }else {
                        mTvDatas.setVisibility(View.VISIBLE);
                        mTvData.setVisibility(View.GONE);
                    }
                    mTvData.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mTvDatas.setVisibility(View.VISIBLE);
                            mTvData.setVisibility(View.GONE);
                            MediaType type = MediaType.parse("application/json;charset=UTF-8");
                            JSONObject jsonObject = new JSONObject();
                            try {
                                jsonObject.put("favoriteType", 1);
                                jsonObject.put("status", 1);
                                jsonObject.put("targetId", userid);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            String string = jsonObject.toString();
                            RequestBody body = RequestBody.create(type, string);
                            mPresenter.getData(ApiConfig.FOLLOWUSER,body);
                        }
                    });
                    mTvDatas.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mTvData.setVisibility(View.VISIBLE);
                            mTvDatas.setVisibility(View.GONE);
                            MediaType type = MediaType.parse("application/json;charset=UTF-8");
                            JSONObject jsonObject = new JSONObject();
                            try {
                                jsonObject.put("favoriteType", 1);
                                jsonObject.put("status", 2);
                                jsonObject.put("targetId", userid);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            String string = jsonObject.toString();
                            RequestBody body = RequestBody.create(type, string);
                            mPresenter.getData(ApiConfig.NOTFOLLOWS,body);
                        }
                    });
                    if (!TextUtils.isEmpty(pics)) {
                        String[] split = pics.split(",");
                        for (int j = 0; j < split.length; j++) {
                            strList.add(split[j]);
                        }
                        mBanner.setImages(strList);
                    }else {
                        arrayList = new ArrayList<>();
                        arrayList.add(R.mipmap.bg);
                        mBanner.setImages(arrayList);
                    }

                    mBanner.setImageLoader(new MyLoader());
                    mBanner.start();
                }else {
                    showToast(userDatilasBean.getMessage());
                }
                break;
            case ApiConfig.FOLLOWUSER:
                FollowBean followBean = (FollowBean) t[0];
                if (followBean.getCode() == 200) {
                    showToast("关注成功");

                } else if (followBean.getCode() == 500) {
                    showToast(followBean.getMessage());
                }
                break;
            case ApiConfig.NOTFOLLOWS:
                NotFollowBean notFollowBean = (NotFollowBean) t[0];
                if (notFollowBean.getCode() == 200) {
                    showToast("取消关注");
                }
                break;
        }
    }

    @OnClick({R.id.iv_close, R.id.iv_user_content, R.id.iv_photo_list, R.id.iv_three, R.id.iv_four})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_close:
                break;
            case R.id.iv_user_content:
                switchfragment(0);
                break;
            case R.id.iv_photo_list:
                switchfragment(1);
                break;
            case R.id.iv_three:
                switchfragment(2);
                break;
            case R.id.iv_four:
                switchfragment(3);
                break;
        }
    }
    protected void setStatusBar() {
        //这里做了两件事情，1.使状态栏透明并使contentView填充到状态栏 2.预留出状态栏的位置，防止界面上的控件离顶部靠的太近。这样就可以实现开头说的第二种情况的沉浸式状态栏了
        StatusBarUtil.setTranslucentStatus(this);
    }
    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).transform(new CenterCrop()).placeholder(R.mipmap.bg).into(imageView);
        }
    }
}
