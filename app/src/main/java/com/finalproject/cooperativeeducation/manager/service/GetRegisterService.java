package com.finalproject.cooperativeeducation.manager.service;

import com.finalproject.cooperativeeducation.manager.dao.GetRegisterDao;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by master on 28/5/2559.
 */
public interface GetRegisterService {

    @POST("getRegisterByUser.php")
    @FormUrlEncoded
    Call<GetRegisterDao> getRegister(@Field("strEmail") String email);
}
