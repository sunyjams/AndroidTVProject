package com.sunyjams.common.utils;

import android.app.Activity;
import android.text.InputType;
import android.view.WindowManager;
import android.widget.EditText;

import java.lang.reflect.Method;

/**
 * @author James
 *         on 2017/1/3
 *         description 处理系统键盘相关内容
 */
public class SystemKeyBoardUtil {

    /**
     * 隐藏页面指定 EditText 控件系统键盘
     * @param activity page
     * @param editText EditText
     */
    public static void hideSystemKeyBoard(Activity activity, EditText editText){
        if (android.os.Build.VERSION.SDK_INT <= 10) {//4.0以下
            editText.setInputType(InputType.TYPE_NULL);
        } else {
            activity.getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            try {
                Class<EditText> cls = EditText.class;
                Method setShowSoftInputOnFocus;
                setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus",
                        boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(editText, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
