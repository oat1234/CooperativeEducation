package com.finalproject.cooperativeeducation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finalproject.cooperativeeducation.activity.R;

/**
 * Created by master on 20/3/2559.
 */
public class FragmentCompany extends Fragment {

    public FragmentCompany(){

    }

    public static FragmentCompany newInstance(){
        FragmentCompany fragment = new FragmentCompany();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_company_fragment, container, false);
        return view;
    }
}
