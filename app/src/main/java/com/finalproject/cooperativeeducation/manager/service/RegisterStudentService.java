package com.finalproject.cooperativeeducation.manager.service;

import com.finalproject.cooperativeeducation.manager.dao.MessageResponseDao;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by master on 5/6/2559.
 */
public interface RegisterStudentService {

    @POST("register_student.php")
    @FormUrlEncoded
    Call<MessageResponseDao> register(@Field("userId") int userId,
                                      @Field("name") String name ,@Field("surname") String surname ,
                                      @Field("phone") String phone ,@Field("studentNo") String studentNo ,
                                      @Field("position") String position ,@Field("detail") String detail ,
                                      @Field("enterprise") String enterprise ,@Field("address") String address);
}
