package com.copasso.lifeAccounting.utils;

import android.content.Context;
import android.widget.Toast;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Class desc: 单例土司
 */
public class ToastUtils {

    public static Toast mToast;

    /**
     * 显示吐司
     * @param context
     * @param message
     */
    public static void show(final Context context, final String message){
        if (mToast == null){
            mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        }else{
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    /**
     * 显示吐司
     * @param context
     * @param messageResId
     */
    public static void show(final Context context, final int messageResId){
        if (mToast == null){
            mToast = Toast.makeText(context, messageResId, Toast.LENGTH_SHORT);
        }else{
            mToast.setText(messageResId);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    /**
     * 显示弹窗提示信息
     *
     */
    public static void  reminder(final Context context,final String message){
        new MaterialDialog.Builder(context)
                .title("提示")
                .titleGravity(GravityEnum.CENTER)
                .content(message)
                .positiveText("确定")
                .negativeText("取消")
                .show();
    }
}
