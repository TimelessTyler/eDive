package com.example.edive.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class CloseSearchUtils {

    /**
     * 隐藏软键盘
     *
     * @param view    :一般为EditText
     */
    public static void hideKeyboard(View view) {
        InputMethodManager manager = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
