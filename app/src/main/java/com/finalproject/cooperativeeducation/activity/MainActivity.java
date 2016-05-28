package com.finalproject.cooperativeeducation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by master on 20/3/2559.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbar;
    private ImageView img1, img2, img3, img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initView();

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
    }

    private void initView() {
        img1 = (ImageView) findViewById(R.id.imageView1);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);
        img4 = (ImageView) findViewById(R.id.imageView4);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.imageView1){

        }else if(v.getId() == R.id.imageView2){

        }else if(v.getId() == R.id.imageView3){

        }else if(v.getId() == R.id.imageView4){
            goToFaq();
        }
    }

    private void goToFaq(){
        startActivity(new Intent(MainActivity.this, FaqActivity.class));
    }
}
