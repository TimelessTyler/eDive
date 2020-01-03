package com.example.edives.fragment;


import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.edives.R;
import com.example.edives.bean.UserDatilasBean;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpFragment;
import com.example.edives.model.PersonModel;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class PersonalProfileFragment extends BaseMvpFragment<PersonModel> {


    private final int id;
    private final int userType;
    private final int favoriteType;
    @BindView(R.id.tv_text)
    TextView mTvText;

    public PersonalProfileFragment(int id, int userType, int favoriteType) {
        // Required empty public constructor
        this.id = id;
        this.userType = userType;
        this.favoriteType = favoriteType;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal_profile;
    }

    @Override
    public void initView() {

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
        showToast(e.getMessage());
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi){
            case ApiConfig.USERDATALIS:
                UserDatilasBean userDatilasBean = (UserDatilasBean) t[0];
                if (userDatilasBean.getCode() == 200) {
                    UserDatilasBean.DataBean data = userDatilasBean.getData();
                    String personalizedSignature = data.getPersonalizedSignature();
                    if (!TextUtils.isEmpty(personalizedSignature)) {
                        mTvText.setText(personalizedSignature);
                    }else {
                        mTvText.setText("当前用户暂无个人简介");

                    }
                }else {
                    showToast(userDatilasBean.getMessage());
                }
                break;
        }
    }

}
