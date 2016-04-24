package com.finalproject.cooperativeeducation.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.finalproject.cooperativeeducation.fragment.FragmentCompany;
import com.finalproject.cooperativeeducation.fragment.FragmentStudent;
import com.finalproject.cooperativeeducation.fragment.FragmentTeacher;

/**
 * Created by master on 19/3/2559.
 */
public class RegisterActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        init();
        initFirst();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.menu_company:
                mTitle = "Company";
                fragment = FragmentCompany.newInstance();
                break;
            case R.id.menu_student:
                mTitle = "Student";
                fragment = FragmentStudent.newInstance();
                break;
            case R.id.menu_teacher:
                mTitle = "Teacher";
                fragment = FragmentTeacher.newInstance();
                break;
        }

        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction =
                    fragmentManager.beginTransaction().replace(R.id.content, fragment);
            transaction.commit();
            setTitle(mTitle);
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void init(){
        toolbar.setTitle(mTitle);
        toolbar.showOverflowMenu();
        setSupportActionBar(toolbar);
    }

    private void initFirst(){
        setTitle("Student");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction =
                fragmentManager.beginTransaction().replace(R.id.content, FragmentStudent.newInstance());
        transaction.commit();
    }

    private void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
