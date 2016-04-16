package com.finalproject.cooperativeeducation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvRegister;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        tvRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    private void initView() {
        btnLogin = (Button) findViewById(R.id.btnlogin);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvRegister:
                goToRegister();
                break;
            case R.id.btnlogin:
                goToMainpage();
                break;

        }
    }

    private void goToRegister() {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        finish();
    }

    private void goToMainpage() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }
}
