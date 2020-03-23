package com.example.edives.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.edives.R;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.HomeModel;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.XXPermissions;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.app.TakePhotoImpl;
import org.devio.takephoto.compress.CompressConfig;
import org.devio.takephoto.model.CropOptions;
import org.devio.takephoto.model.TResult;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopSettingActivity extends BaseMvpActivity<HomeModel>implements TakePhoto.TakeResultListener{

    @BindView(R.id.iv_tishi)
    ImageView mIvTishi;
    @BindView(R.id.iv_photomore)
    ImageView mIvPhotomore;
    @BindView(R.id.iv_photosa)
    ImageView mIvPhotos;
    @BindView(R.id.rl_iv_photo)
    RelativeLayout mRlIvPhoto;
    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.tv_shop_name)
    TextView mTvShopName;
    @BindView(R.id.rl_name)
    RelativeLayout mRlName;
    @BindView(R.id.iv_s)
    ImageView mIvS;
    @BindView(R.id.tv_notice)
    TextView mTvNotice;
    @BindView(R.id.rl_notice)
    RelativeLayout mRlNotice;
    @BindView(R.id.iv_o)
    ImageView mIvO;
    @BindView(R.id.tv_shop_phone)
    TextView mTvShopPhone;
    @BindView(R.id.rl_phone)
    RelativeLayout mRlPhone;
    @BindView(R.id.iv_a)
    ImageView mIvA;
    @BindView(R.id.tv_autotext)
    TextView mTvAutotext;
    @BindView(R.id.rl_auto)
    RelativeLayout mRlAuto;
    private PopupWindow popupWindow;
    private TakePhotoImpl mTakephoto;


    @Override
    public int getLayoutId() {
        return R.layout.activity_shop_setting;
    }

    @Override
    public void initView() {
        mTakephoto = new TakePhotoImpl(ShopSettingActivity.this, this);
        getPermission();
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

    @OnClick({R.id.iv_tishi, R.id.rl_iv_photo, R.id.rl_name, R.id.rl_notice, R.id.tv_shop_phone, R.id.rl_auto})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
                //店铺等级
            case R.id.iv_tishi:
                break;
                //店铺头像
            case R.id.rl_iv_photo:
                initPops();
                break;
                //店铺名字
            case R.id.rl_name:
                break;
                //店铺公告
            case R.id.rl_notice:
                break;
                //店铺电话
            case R.id.tv_shop_phone:
                break;
                //自动回复
            case R.id.rl_auto:
                break;
        }
    }

    private void initPops() {
        View inflate1 = LayoutInflater.from(this).inflate(R.layout.layout_popo_person_photo, null);
        TextView tv_photo = inflate1.findViewById(R.id.tv_photo);
        TextView tv_camer = inflate1.findViewById(R.id.tv_camer);
        TextView tv_colse = inflate1.findViewById(R.id.tv_colse);
        popupWindow = new PopupWindow(inflate1, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(R.style.PopupAnimation);
        popupWindow.showAtLocation(inflate1, Gravity.BOTTOM, 0, 0);
        //进去popupWindow时背景
        final WindowManager.LayoutParams lp = ShopSettingActivity.this.getWindow().getAttributes();
        lp.alpha = 0.7f;//代表透明程度，范围为0 - 1.0f
        ShopSettingActivity.this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        ShopSettingActivity.this.getWindow().setAttributes(lp);
        /**
         * 退出popupWindow时取消暗背景
         */
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                lp.alpha = 1.0f;
                ShopSettingActivity.this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                ShopSettingActivity.this.getWindow().setAttributes(lp);
            }
        });
        tv_camer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initCamer();
            }
        });
        tv_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPhoto();
            }
        });
        tv_colse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
    private void initCamer() {
        //压缩图片
        mTakephoto.onEnableCompress(new CompressConfig.Builder().setMaxSize(50 * 1024).setMaxPixel(1080).create(), true);
        //从相册获取并裁剪
        mTakephoto.onPickFromCaptureWithCrop(getUri(), getOption());
        popupWindow.dismiss();
    }

    private void initPhoto() {
        mTakephoto.onEnableCompress(new CompressConfig.Builder().setMaxSize(50 * 1024).setMaxPixel(1080).create(), true);
        mTakephoto.onPickFromGalleryWithCrop(getUri(), getOption());
        popupWindow.dismiss();
    }
    private CropOptions getOption() {
        return new CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(false).create();
    }
    private Uri getUri() {
        File file = new File(Environment.getExternalStorageDirectory(), "/eDive/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Uri imageUri = Uri.fromFile(file);
        return imageUri;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mTakephoto.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void getPermission() {
        XXPermissions.with(this)
                .constantRequest() //可设置被拒绝后继续申请，直到用户授权或者永久拒绝
                //.permission(Permission.SYSTEM_ALERT_WINDOW, Permission.REQUEST_INSTALL_PACKAGES) //支持请求 6.0 悬浮窗权限 8.0 请求安装权限
                .permission(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE) //不指定权限则自动获取清单中的危险权限
                .request(new OnPermission() {

                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {

                    }

                    @Override
                    public void noPermission(List<String> denied, boolean quick) {
                        if (denied.size() != 0) showToast("拒绝权限影响您正常使用");
                    }
                });
        //XXPermissions.gotoPermissionSettings(this);//跳转到权限设置页面
    }

    @Override
    public void takeSuccess(TResult result) {
        String path = result.getImage().getCompressPath() != null ? result.getImage().getCompressPath() : result.getImage().getOriginalPath();
        Glide.with(ShopSettingActivity.this).load(path).into(mIvPhotos);
    }

    @Override
    public void takeFail(TResult result, String msg) {

    }

    @Override
    public void takeCancel() {

    }
}
