package com.finalproject.cooperativeeducation.View.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finalproject.cooperativeeducation.Model.FaqModel;
import com.finalproject.cooperativeeducation.View.FaqViewHolder;
import com.finalproject.cooperativeeducation.activity.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by master on 10/4/2559.
 */
public class FaqAdapter extends RecyclerView.Adapter<FaqViewHolder> {

    private List<FaqModel> items;

    public FaqAdapter(List<FaqModel> items){
        this.items = items;
    }

    @Override
    public FaqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_items_faq, parent, false);
        return new FaqViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FaqViewHolder holder, int position) {
        holder.txtFaq.setText(items.get(position).getQuestion());
    }

    @Override
    public int getItemCount() {
        if(items != null)
            return items.size();
        return 0;
    }
}
