package com.example.edives.utils;

import android.widget.Toast;

import com.example.edives.frame.BaseApplication;


public class ToastUtil {//吐司的工具类
    public static void showShort(String msg){
        //避免内存泄漏的一个方法,用到上下文的地方,能用application的就application
        Toast.makeText(BaseApplication.getAppContext(),msg,Toast.LENGTH_SHORT).show();
    }
    public static void showLong(String msg){
        //避免内存泄漏的一个方法,用到上下文的地方,能用application的就application
        Toast.makeText(BaseApplication.getAppContext(),msg,Toast.LENGTH_LONG).show();
    }
    public static void showShort(int keyCode) {
        //避免内存泄漏的一个方法,用到上下文的地方,能用application的就application
        Toast.makeText(BaseApplication.getAppContext(),keyCode+"",Toast.LENGTH_LONG).show();
}
}
