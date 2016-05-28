package com.finalproject.cooperativeeducation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.finalproject.cooperativeeducation.manager.RestServiceManager;
import com.finalproject.cooperativeeducation.manager.dao.GetRegisterDao;
import com.finalproject.cooperativeeducation.manager.dao.MessageResponseDao;
import com.finalproject.cooperativeeducation.manager.service.GetRegisterService;
import com.finalproject.cooperativeeducation.manager.service.RegisterService;

import org.parceler.Parcels;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, Callback<GetRegisterDao>{

    private Button btnSubmit;
    private EditText edtRegisterEmail;
    private EditText edtRegisterPass;
    private EditText edtRegisterRePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        initView();

        btnSubmit.setOnClickListener(this);
    }
    private void initView() {
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        edtRegisterEmail = (EditText) findViewById(R.id.edtRegisterEmail);
        edtRegisterPass = (EditText) findViewById(R.id.edtRegisterPass);
        edtRegisterRePass = (EditText) findViewById(R.id.edtRegisterRePass);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSubmit:
                onSubmit();
                break;
        }
    }

    private void onSubmit(){
        if(validation()) {//validate

            register();
        }else{

        }
    }

    private boolean validation(){

        return true;
    }

    private void register(){
        RegisterService service = RestServiceManager.create(RegisterService.class);
        service.register(edtRegisterEmail.getText().toString(), edtRegisterPass.getText().toString()).enqueue(new Callback<MessageResponseDao>() {
            @Override
            public void onResponse(Call<MessageResponseDao> call, Response<MessageResponseDao> response) {
                if(response.isSuccessful()){
                    MessageResponseDao dao = response.body();
                    if(dao.getMsg().equals("0")){
                        Toast.makeText(RegisterActivity.this, "Email is duplicate", Toast.LENGTH_LONG).show();
                    }else{
                        GetRegisterService getRegisterService = RestServiceManager.create(GetRegisterService.class);
                        getRegisterService.getRegister(edtRegisterEmail.getText().toString()).enqueue(RegisterActivity.this);
                    }
                }else{
                    Toast.makeText(RegisterActivity.this, "Failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MessageResponseDao> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Filed : "+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void goToPersonalDetailActivity(GetRegisterDao dao){
        Intent intent = new Intent(RegisterActivity.this, PersonalDetailActivity.class);
        intent.putExtra("getRegister", Parcels.wrap(dao));
        startActivity(intent);
    }

    @Override
    public void onResponse(Call<GetRegisterDao> call, Response<GetRegisterDao> response) {
        if(response.isSuccessful()){
            GetRegisterDao dao = response.body();
            goToPersonalDetailActivity(dao);
        }else{
            Toast.makeText(RegisterActivity.this, "Failed", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<GetRegisterDao> call, Throwable t) {
        Toast.makeText(RegisterActivity.this, "Filed : "+t.getMessage(), Toast.LENGTH_LONG).show();
    }
}
