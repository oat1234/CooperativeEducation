package com.finalproject.cooperativeeducation.manager.model;

import org.parceler.Parcel;

/**
 * Created by master on 28/5/2559.
 */
@Parcel
public class GetRegisterModel {

    private int id;
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
