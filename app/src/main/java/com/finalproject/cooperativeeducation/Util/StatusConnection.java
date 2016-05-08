package com.finalproject.cooperativeeducation.Util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by master on 6/5/2559.
 */
public class StatusConnection {

    public static boolean connection(Context context){
        if(Utils.isOnline(context))
            return true;
        else {
            Toast.makeText(context, "No internet connection", Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
