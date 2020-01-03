package com.example.edives.local_utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.example.edives.frame.BaseApplication;


public class VersionUtils {
    public static int getVersionCode(){
        PackageInfo info = null;
        try {
            info = BaseApplication.baseApplication.getPackageManager().getPackageInfo(BaseApplication.baseApplication.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException pE) {
            pE.printStackTrace();
        }
        return info.versionCode;
    }
}
