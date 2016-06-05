package com.finalproject.cooperativeeducation.manager.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by master on 28/5/2559.
 */
@Parcel
public class GetRegisterModel {

    @SerializedName("id")
    private int id;
    @SerializedName("email")
    private String email;

    public GetRegisterModel(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
