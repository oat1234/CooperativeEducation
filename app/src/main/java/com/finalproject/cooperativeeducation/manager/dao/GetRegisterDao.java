package com.finalproject.cooperativeeducation.manager.dao;

import com.finalproject.cooperativeeducation.manager.model.GetRegisterModel;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by master on 28/5/2559.
 */
@Parcel
public class GetRegisterDao {

    @SerializedName("data")
    private List<GetRegisterModel> data;

    public GetRegisterDao(){

    }

    public List<GetRegisterModel> getData() {
        return data;
    }

    public void setData(List<GetRegisterModel> data) {
        this.data = data;
    }
}
