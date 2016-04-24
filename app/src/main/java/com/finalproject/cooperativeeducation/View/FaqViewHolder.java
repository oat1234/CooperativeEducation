package com.finalproject.cooperativeeducation.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.finalproject.cooperativeeducation.activity.R;

/**
 * Created by master on 10/4/2559.
 */
public class FaqViewHolder extends RecyclerView.ViewHolder {

    public TextView txtFaq;

    public FaqViewHolder(View itemView) {
        super(itemView);
        txtFaq = (TextView) itemView.findViewById(R.id.txt_faq);
    }
}
