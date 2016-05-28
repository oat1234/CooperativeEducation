package com.finalproject.cooperativeeducation.manager.service;

import com.finalproject.cooperativeeducation.manager.dao.MessageResponseDao;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by master on 6/5/2559.
 */
public interface RegisterService {

    @POST("register.php")
    @FormUrlEncoded
    Call<MessageResponseDao> register(@Field("email") String email,
                               @Field("password") String password);
}
