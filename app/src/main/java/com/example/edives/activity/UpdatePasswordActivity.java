package com.example.edives.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.edives.MainActivity;
import com.example.edives.R;
import com.example.edives.bean.UpdataPasswordBean;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.local_utils.SharedPrefrenceUtils;
import com.example.edives.model.HomeModel;
import com.example.edives.utils.NormalConfig;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class UpdatePasswordActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.update_ed_former_password)
    EditText mUpdateEdFormerPassword;
    @BindView(R.id.update_ed_new_pass)
    EditText mUpdateEdNewPass;
    @BindView(R.id.update_ed_ok_new_pass)
    EditText mUpdateEdOkNewPass;
    @BindView(R.id.update_ok_btn)
    Button mUpdateOkBtn;

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
        return R.layout.activity_update_password;
    }

    @Override
    public void initView() {

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
        switch (whichApi){
            case ApiConfig.UPDATAPASSWORD:
                UpdataPasswordBean bean = (UpdataPasswordBean) t[0];
                if (bean.getCode() == 200) {
                    showToast(bean.getMessage());
                    SharedPrefrenceUtils.saveString(UpdatePasswordActivity.this, NormalConfig.PHONE,"");
                    SharedPrefrenceUtils.saveString(UpdatePasswordActivity.this, NormalConfig.USER_PHOTO,"");
                    SharedPrefrenceUtils.saveString(UpdatePasswordActivity.this, NormalConfig.ICON,"");
                    SharedPrefrenceUtils.saveString(UpdatePasswordActivity.this, NormalConfig.NICKNAME,"");
                    SharedPrefrenceUtils.saveString(UpdatePasswordActivity.this, NormalConfig.TOKEN,"");
                    SharedPrefrenceUtils.saveString(UpdatePasswordActivity.this, NormalConfig.PERSONALIZED,"");
                    mApplication.icon = "";
                    mApplication.nickname = "";
                    mApplication.Personalizedsignature = "";
                    mApplication.Phone = "";
                    mApplication.Token = "";
                    mApplication.userid = "";
                    startActivity(new Intent(UpdatePasswordActivity.this, MainActivity.class));
                    finish();
                }else {
                    showToast(bean.getCode()+":"+bean.getMessage());
                }
                break;
        }
    }

    @OnClick(R.id.update_ok_btn)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.update_ok_btn:
                String password = mUpdateEdFormerPassword.getText().toString();
                String newpassword = mUpdateEdNewPass.getText().toString();
                String okpassword = mUpdateEdOkNewPass.getText().toString();
                if (newpassword.equals(okpassword)) {
                    String phone = SharedPrefrenceUtils.getString(UpdatePasswordActivity.this, NormalConfig.PHONE, "");
                    MediaType type = MediaType.parse("application/json;charset=UTF-8");
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("telephone", phone);
                        jsonObject.put("oldPassword", password);
                        jsonObject.put("confirmPassword", newpassword);
                        jsonObject.put("newPassword", okpassword);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String string = jsonObject.toString();
                    RequestBody bodys = RequestBody.create(type, string);
                    mPresenter.getData(ApiConfig.UPDATAPASSWORD,bodys);
                }else {
                    showToast("密码不一致");
                }
                break;
        }
    }
}
