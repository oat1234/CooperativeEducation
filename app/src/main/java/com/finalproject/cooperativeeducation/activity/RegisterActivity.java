package com.finalproject.cooperativeeducation.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.finalproject.cooperativeeducation.fragment.FragmentCompany;
import com.finalproject.cooperativeeducation.fragment.FragmentStudent;
import com.finalproject.cooperativeeducation.fragment.FragmentTeacher;

/**
 * Created by master on 19/3/2559.
 */
public class RegisterActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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
                fragment = FragmentCompany.newInstance();
                break;
            case R.id.menu_student:
                fragment = FragmentStudent.newInstance();
                break;
            case R.id.menu_teacher:
                fragment = FragmentTeacher.newInstance();
                break;
        }

        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction =
                    fragmentManager.beginTransaction().replace(R.id.content, fragment);
            transaction.commit();
        }
        return super.onOptionsItemSelected(item);
    }
}
