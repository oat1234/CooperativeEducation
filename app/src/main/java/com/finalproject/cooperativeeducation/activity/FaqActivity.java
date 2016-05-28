package com.finalproject.cooperativeeducation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.finalproject.cooperativeeducation.Model.FaqModel;
import com.finalproject.cooperativeeducation.View.Adapter.FaqAdapter;
import com.finalproject.cooperativeeducation.View.FaqResultDialog;
import com.finalproject.cooperativeeducation.View.Recycler.RecyclerItemClickListener;
import com.finalproject.cooperativeeducation.View.Recycler.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by master on 10/4/2559.
 */
public class FaqActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    private FaqAdapter adapter;
    private List<FaqModel> listQuestion = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_for_user);
        init();
    }

    private void init() {
        initView();
        initSetData();
    }

    private void initSetData() {
        toolbar.setTitle("FAQ");
        toolbar.showOverflowMenu();
        setSupportActionBar(toolbar);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getApplicationContext()));

        for(int i=0; i<10; i++){
            FaqModel faqModel = new FaqModel();
            faqModel.setQuestion("quest "+ (i+1));
            faqModel.setAnswer("answer "+ (i+1));
            listQuestion.add(faqModel);
        }

        adapter = new FaqAdapter(listQuestion);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                FaqResultDialog dialog = new FaqResultDialog(FaqActivity.this, R.style.FaqDialog);
                dialog.setQuestion(listQuestion.get(position).getQuestion());
                dialog.setAnwser(listQuestion.get(position).getAnswer());
                dialog.displayData();
                dialog.show();
            }
        }));
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
    }
}
