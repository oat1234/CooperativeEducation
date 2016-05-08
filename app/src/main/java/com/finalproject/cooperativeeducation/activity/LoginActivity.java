package com.finalproject.cooperativeeducation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.finalproject.cooperativeeducation.Util.StatusConnection;
import com.finalproject.cooperativeeducation.manager.RestServiceManager;
import com.finalproject.cooperativeeducation.manager.dao.MessageResponseDao;
import com.finalproject.cooperativeeducation.manager.service.LoginService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvRegister;
    private Button btnLogin;
    private EditText edtEmail;
    private EditText edtPassword;

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
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
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
    }

    private void goToMainpage() {
        if(StatusConnection.connection(LoginActivity.this)){
            LoginService call = RestServiceManager.create(LoginService.class);
            call.login(edtEmail.getText().toString(), edtPassword.getText().toString()).enqueue(new Callback<MessageResponseDao>() {
                @Override
                public void onResponse(Call<MessageResponseDao> call, Response<MessageResponseDao> response) {
                    if(response.isSuccessful()){
                        MessageResponseDao dao = response.body();
                        if(dao.getMsg().equals("0")){
                            Toast.makeText(LoginActivity.this, "Email or Password is inconrect", Toast.LENGTH_LONG).show();
                        }else{
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<MessageResponseDao> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Filed : "+t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }

    }
}
