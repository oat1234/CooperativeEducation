package com.finalproject.cooperativeeducation.manager.service;

import com.finalproject.cooperativeeducation.manager.dao.MessageResponseDao;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by master on 6/5/2559.
 */
public interface LoginService {

    @POST("login.php")
    @FormUrlEncoded
    Call<MessageResponseDao> login(@Field("strEmail") String email, @Field("strPass") String pass);
}
