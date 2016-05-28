package com.finalproject.cooperativeeducation.Util;

/**
 * Created by master on 6/5/2559.
 */
public class BaseConfig {

    public static String BaseUrlProduction = "http://projectoath.esy.es/ProjectOath/myproject/";
    public static String BaseUrlLocal = "http://172.20.10.3/myproject/";

    public static String prefixUrl(){
        if(Constant.isProduction)
            return BaseUrlProduction;
        else
            return BaseUrlLocal;
    }
}
