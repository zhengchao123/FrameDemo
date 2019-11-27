package com.rcb.financialservice.application;

import android.app.Application;
import android.content.Context;

import com.rcb.financialservice.crash.CrashHandler;

import decoration.scsowing.com.decoration.ui.event.OwnCrashHandler;


public class RcbApplication extends Application {

    public Context mContext;

    public static com.rcb.financialservice.application.RcbApplication mInstance;

    public static com.rcb.financialservice.application.RcbApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        this.mContext = this.getApplicationContext();
        initHandler();
        //两种crashhandler  下面这种能够写入文件
       // CrashHandler crashHandler =new CrashHandler();
        //crashHandler.init(this.getBaseContext());
    }

    private void initHandler() {
        OwnCrashHandler handler = OwnCrashHandler.Companion.getInstance();
        Thread.setDefaultUncaughtExceptionHandler(handler);
        handler.init(mContext);
    }

}
