package com.finalproject.cooperativeeducation.manager.dao;

import com.google.gson.annotations.SerializedName;

/**
 * Created by master on 6/5/2559.
 */
public class MessageResponseDao {

    @SerializedName("num")
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
