
package com.rcb.financialservice.net.netretrofit;

import android.text.TextUtils;


import com.rcb.financialservice.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    private static Retrofit sRetrofit;
    private static ApiService sApiService;

//    private static final String API_HOST_DEBUG = "http://172.16.2.12:8848/"; // 测试地址
//    private static final String API_HOST_RELEASE = "http://172.16.2.12:8848/"; // 正式地址

    private static void init() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                    .newBuilder()
                    .header("Content-Type", "application/json")
                    .build();
                return chain.proceed(request);
            }
        });
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }
        OkHttpClient okHttpClient = builder.connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build();
        okHttpClient.dispatcher().setMaxRequestsPerHost(10);
        okHttpClient.dispatcher().setMaxRequests(64);
        sRetrofit = new Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build();
    }

    private static String getBaseUrl() {

//        String cacheServerAddress = XMLManager.Companion.getInstance(App.Companion.getInstance()).getServerUrl();
//        String cacheServerPort = XMLManager.Companion.getInstance(App.Companion.getInstance()).getServerPort();
//        if (cacheServerAddress.startsWith("https") || cacheServerAddress.startsWith("http")) {
//            return cacheServerAddress + "/";
//        }
//        return "http://" + cacheServerAddress + "/";
        String cacheServerAddress = "";
        String cacheServerPort = "";

        if (cacheServerAddress.startsWith("https") || cacheServerAddress.startsWith("http")) {
            if (TextUtils.isEmpty(cacheServerPort)) {
                return cacheServerAddress + "/";
            }
            return cacheServerAddress + ":" + cacheServerPort + "/";
        }

        if (TextUtils.isEmpty(cacheServerPort)) {
            return "http://" + cacheServerAddress + "/";
        }
        return "http://" + cacheServerAddress + ":" + cacheServerPort + "/";
    }

    public static ApiService getApiService() {
        if (sApiService == null) {
            synchronized (ApiClient.class) {
                if (sApiService == null) {
                    init();
                    sApiService = sRetrofit.create(ApiService.class);
                }
            }
        }
        return sApiService;
    }

    public static void resetApiService() {
        sApiService = null;
        sRetrofit = null;
    }

}
