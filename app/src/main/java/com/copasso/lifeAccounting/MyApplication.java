package com.copasso.lifeAccounting;

import android.app.Application;
import android.content.Context;

import com.copasso.lifeAccounting.model.bean.remote.MyUser;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class MyApplication extends Application {

    public static MyApplication application;
    private static Context context;
    private static MyUser currentUser;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        context = getApplicationContext();
        //初始化Bmob后端云
        // 使用时请将第二个参数Application ID替换成你在Bmob服务器端创建的Application ID
        Bmob.initialize(this, "4d281559fbf9c96c9ea52729953b6ee1");
        currentUser = BmobUser.getCurrentUser(MyUser.class);
    }

    /**
     * 获取上下文
     *
     * @return
     */
    public static Context getContext() {
        return context;
    }

    /**
     * 获取用户id
     * @return
     */
    public static String getCurrentUserId() {

        currentUser = BmobUser.getCurrentUser(MyUser.class);
        if (currentUser == null)
            return null;
        return BmobUser.getCurrentUser(MyUser.class).getObjectId();
    }
}