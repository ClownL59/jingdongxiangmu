package com.bwei.jingd.net;


import com.bwei.jingd.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginApiService {

    @FormUrlEncoded
    @POST("user/login")
    Observable<UserBean> login(@Field("mobile") String mobile,
                               @Field("password") String password);
}
