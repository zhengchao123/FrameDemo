package com.rcb.financialservice.ui.event;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.rcb.financialservice.ui.activity.EmptyActivity;
import decoration.scsowing.com.decoration.utils.LogUtils;

public class EventHandler {

    private final String TAG = this.getClass().getSimpleName();
    long preTime;
    Context mContext;
    private boolean defaultAction = true;

    public EventHandler(Context context) {
        this.mContext = context;
    }
    public EventHandler(Context context,boolean defaultAction) {
        this.mContext = context;
        this.defaultAction = defaultAction;
    }


    /**
     * defaultaction  jump to emptyactivity when click response
     * @param defaultAction boolean
     */
    public void defaultAction(boolean defaultAction){
        this.defaultAction = defaultAction;
    }
    public void onClickView(View view) {
        long subtime = System.currentTimeMillis() - preTime;
        preTime = System.currentTimeMillis();
        LogUtils.INSTANCE.i(TAG, " subtime " + subtime);
        if (subtime <= 1000) {
            LogUtils.INSTANCE.e(TAG, "this force click in 1s ");
            return;
        }
        defaultAction(defaultAction);
        if(defaultAction){
            mContext.startActivity( new Intent(mContext,EmptyActivity.class));
        }
    }
    public void onDestory(){
        mContext = null;
    }
}
