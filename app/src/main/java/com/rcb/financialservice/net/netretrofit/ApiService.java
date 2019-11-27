package com.rcb.financialservice.net.netretrofit;


import com.rcb.financialservice.net.netretrofit.body.FindFaceBody;
import com.rcb.financialservice.net.netretrofit.entity.BaseEntity;
import com.rcb.financialservice.net.netretrofit.entity.FindFaceEntity;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {


//    /**
//     * 部门列表获取
//     *
//     * @return
//     */
//    @GET("facepass/{id}/pads/departments")
//    Observable<BaseEntity<DepartmentBean>> getDepartments(@Path("id") String id);


    @POST("rec-service/rec/recognize")
    Observable<BaseEntity<FindFaceEntity>> findFace(@Body FindFaceBody body);

    /**
     * 设备id
     *
     * @return
     */
    @GET("facepass/0/pads/{id}")
    Observable<BaseEntity<String>> getDeviceId(@Path("id") String id);
//    /**
//     * 设备名称
//     *
//     * @return
//     */
//    @GET("/facepass/{id}/pads/info")
//    Observable<BaseEntity<ServiceConfigEntity>> getDeviceNameById(@Path("id") String id);
//



}
