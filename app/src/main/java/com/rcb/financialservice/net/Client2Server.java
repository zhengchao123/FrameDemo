package com.rcb.financialservice.net;

import com.rcb.financialservice.application.RcbApplication;
import com.rcb.financialservice.net.download.DownLoadCallBack;
import com.rcb.financialservice.net.download.DownloadListener;
import okhttp3.Callback;
import okhttp3.OkHttpClient;

import java.lang.reflect.Type;
import java.util.Map;

public class Client2Server {

    public static void doGetAsyn(Map<String, String> params) throws Exception {
        doGetAsyn(params, null);
    }

    public static void doGetAsyn(Map<String, String> params, Callback callback) throws Exception {
        doGetAsyn(params, callback, null);
    }

    public static void doGetAsyn(Map<String, String> params, Callback callback, Type type) throws Exception {
        OkHttpRequest okHttpRequest = new OkHttpRequest.Builder()
                .type(OkHttpRequest.TYPE_GET)
                .params(params)
                .callBack(callback)
                .classType(type)
                .build();
        OkHttpClient okHttpClient = HttpClientManager.getInstance(RcbApplication.getInstance().mContext).getOkHttpInstance();
        HttpManager.getmInstance().asynchronousHttp(okHttpRequest, okHttpClient);
    }


    public static void doPostAsyn(Map<String, String> params) throws Exception {
        doPostAsyn(params, null);
    }

    public static void doPostAsyn(Map<String, String> params, Callback callback) throws Exception {
        doPostAsyn(params, callback, null);
    }

    public static void doPostAsyn(Map<String, String> params, Callback callback, Type type) throws Exception {
        OkHttpRequest okHttpRequest = new OkHttpRequest.Builder()
                .type(OkHttpRequest.TYPE_POST)
                .params(params)
                .callBack(callback)
                .classType(type)
                .build();
        OkHttpClient okHttpClient = HttpClientManager.getInstance(RcbApplication.getInstance().mContext).getOkHttpInstance();
        HttpManager.getmInstance().asynchronousHttp(okHttpRequest, okHttpClient);
    }

    public static <T extends DownLoadCallBack> void download(Map<String, String> params, T callback) throws Exception {
        download(params, callback, null);
    }

    public static <T extends DownLoadCallBack> void download(Map<String, String> params, T callback, DownloadListener listener) throws Exception {
        OkHttpRequest okHttpRequest = new OkHttpRequest.Builder()
                .params(params)
                .callBack(callback)
                .url(Constants.INSTANCE.getDownloaadUrl())
                .build();
        OkHttpClient okHttpClient = HttpClientManager.getInstance(RcbApplication.getInstance().mContext).getDownLoadOkHttpInstance(listener);
        HttpManager.getmInstance().asynchronousHttp(okHttpRequest, okHttpClient);
    }

}
