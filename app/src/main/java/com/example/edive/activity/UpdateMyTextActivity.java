package com.example.edive.activity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.edive.R;
import com.example.edive.bean.UpdateCoachMessageBean;
import com.example.edive.design.CommonTitle;
import com.example.edive.frame.ApiConfig;
import com.example.edive.frame.BaseMvpActivity;
import com.example.edive.model.PersonModel;
import com.example.edive.utils.NormalConfig;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class UpdateMyTextActivity extends BaseMvpActivity<PersonModel> {

    @BindView(R.id.title)
    CommonTitle mTitle;
    @BindView(R.id.et_text)
    EditText mEtText;
    @BindView(R.id.bt_ok)
    Button mBtOk;

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
        return R.layout.activity_update_my_text;
    }

    @Override
    public void initView() {
        String text = getIntent().getStringExtra("text");
        mEtText.setText(text);
        mEtText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String s1 = s.toString();
                int length = s1.length();
                if (length > 300) {
                    showToast("不能超过三百字");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public PersonModel getModel() {
        return new PersonModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi){
            case ApiConfig.XIUGAIGERENXX:
                UpdateCoachMessageBean updateCoachMessageBean = (UpdateCoachMessageBean) t[0];
                if (updateCoachMessageBean.getCode() == 200) {
                    showToast(updateCoachMessageBean.getMessage());
                    finish();
                }else {
                    showToast(updateCoachMessageBean.getMessage());
                }
                break;
        }
    }

    @OnClick(R.id.bt_ok)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_ok:
                MediaType types = MediaType.parse("application/json;charset=UTF-8");
                JSONObject jsonObjects = new JSONObject();
                try {
                    jsonObjects.put("personalProfile", mEtText.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String str = jsonObjects.toString();
                RequestBody body = RequestBody.create(types, str);
                mPresenter.getData(ApiConfig.XIUGAIGERENXX, body);
                break;
        }
    }
}
