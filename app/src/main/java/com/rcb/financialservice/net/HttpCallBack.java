package com.rcb.financialservice.net;

import com.google.gson.Gson;
import decoration.scsowing.com.decoration.utils.LogUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public class HttpCallBack implements Callback {
    protected OkHttpRequest mOkhttpRequest;

    public HttpCallBack() {
    }

    public HttpCallBack(OkHttpRequest request) {
        this.mOkhttpRequest = request;
    }

    private final String TAG = "OKHTTP " + this.getClass().getSimpleName();

    public void setRequest(OkHttpRequest okHttpRequest) {
        this.mOkhttpRequest = okHttpRequest;
    }

    @Override
    public void onFailure(Call call, IOException e) {
        String errorMsg = call.request().url().toString();
        errorMsg += " request  faild: " + e.getMessage();
        if (null != mOkhttpRequest) {
            Map<String, String> params = mOkhttpRequest.getmParams();
            Gson gson = new Gson();
            if (null != params) {
                errorMsg += " \n with params :" + gson.toJson(params);
            }
        }
        LogUtils.INSTANCE.e(TAG, errorMsg);
        HttpManager.getmInstance().cancleCallByKey(mOkhttpRequest.getmRequestFlag());
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        Gson gson = new Gson();
        String responseBodyStr = response.body().string();
        LogUtils.INSTANCE.e(TAG, call.request().url()
                + " \n method: " + call.request().method()
                + " \n params: " + (call.request().method().equals("POST") ? gson.toJson(mOkhttpRequest.getmParams()) : "")
                + " \n response code: " + response.code()
                + " \n response body: " + (null == mOkhttpRequest.getmDownloadListener() ? responseBodyStr : ""));
        HttpManager.getmInstance().cancleCallByKey(mOkhttpRequest.getmRequestFlag());
        onResponse(call, response, (null != mOkhttpRequest.getmClassType()) ?
                gson.fromJson(responseBodyStr, mOkhttpRequest.getmClassType()) :
                null);

    }

    public <T> void onResponse(Call call, Response response, T t) {
    }
}
