package com.example.edives.frame;

import android.content.Context;
import android.support.multidex.MultiDexApplication;


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
    }
    public static Context getAppContext(){
        return baseApplication.getApplicationContext();
    }

    public static BaseApplication getInstance() {
        return baseApplication;
    }
}
