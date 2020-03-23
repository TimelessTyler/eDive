package com.example.edives.frame;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.example.edives.signature.GenerateTestUserSig;
import com.tencent.imsdk.TIMSdkConfig;
import com.tencent.qcloud.tim.uikit.TUIKit;
import com.tencent.qcloud.tim.uikit.config.CustomFaceConfig;
import com.tencent.qcloud.tim.uikit.config.GeneralConfig;
import com.tencent.qcloud.tim.uikit.config.TUIKitConfigs;


public class BaseApplication extends MultiDexApplication {
    public static BaseApplication baseApplication;
    public String Token = "";
    public String userid = "" ;
    public String nickname = "";
    public String icon = "";
    public String Phone = "";
    public String Personalizedsignature = "";
    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication  = this;
        // 配置 Config，请按需配置
        TUIKitConfigs configs = TUIKit.getConfigs();
        configs.setSdkConfig(new TIMSdkConfig(GenerateTestUserSig.SDKAPPID));
        configs.setCustomFaceConfig(new CustomFaceConfig());
        configs.setGeneralConfig(new GeneralConfig());

        TUIKit.init(this, GenerateTestUserSig.SDKAPPID, configs);
    }
    public static Context getAppContext(){
        return baseApplication.getApplicationContext();
    }

    public static BaseApplication getInstance() {
        return baseApplication;
    }
}
