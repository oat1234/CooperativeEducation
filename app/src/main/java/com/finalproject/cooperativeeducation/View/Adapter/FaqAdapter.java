package com.finalproject.cooperativeeducation.View.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.finalproject.cooperativeeducation.Model.FaqModel;
import com.finalproject.cooperativeeducation.View.FaqViewHolder;

import java.util.ArrayList;

/**
 * Created by master on 10/4/2559.
 */
public class FaqAdapter extends RecyclerView.Adapter<FaqViewHolder> {

    private ArrayList<FaqModel> items;

    public FaqAdapter(ArrayList<FaqModel> items){
        this.items = items;
    }

    @Override
    public FaqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(FaqViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(items != null)
            return items.size();
        return 0;
    }
}
