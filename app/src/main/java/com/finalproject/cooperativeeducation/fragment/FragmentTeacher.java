package com.finalproject.cooperativeeducation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.finalproject.cooperativeeducation.Util.StatusConnection;
import com.finalproject.cooperativeeducation.activity.MainActivity;
import com.finalproject.cooperativeeducation.activity.R;
import com.finalproject.cooperativeeducation.controller.Utils.Validator;
import com.finalproject.cooperativeeducation.manager.RestServiceManager;
import com.finalproject.cooperativeeducation.manager.dao.GetRegisterDao;
import com.finalproject.cooperativeeducation.manager.dao.MessageResponseDao;
import com.finalproject.cooperativeeducation.manager.service.RegisterTeacherService;

import org.parceler.Parcels;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by master on 20/3/2559.
 */
public class FragmentTeacher extends Fragment implements View.OnClickListener, Callback<MessageResponseDao> {
    private EditText edt_teacher_ID;
    private EditText edt_teacher_Name;
    private EditText edt_teacher_Surname;
    private EditText edt_teacher_PhoneNumber;
    private EditText edt_teacher_Position;
    private EditText edt_teacher_Faculty;
    private EditText edt_teacher_Department;
    private EditText edt_teacher_Teach;
    private Button btn_teacher_Submit;

    private int userId;

    public FragmentTeacher(){

    }
    public static FragmentTeacher newInstance(){
        FragmentTeacher fragment = new FragmentTeacher();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_teacher_fragment, container, false);
        Bundle bundle = this.getArguments();
        if(bundle != null) {
            GetRegisterDao dao = Parcels.unwrap(bundle.getParcelable("getRegister"));
            userId = dao.getData().get(0).getId();
        }
        initView(view);
        init();
        return view;
    }
    private void initView(View view){
        edt_teacher_ID = (EditText) view.findViewById(R.id.edt_teacher_ID);
        edt_teacher_Name = (EditText) view.findViewById(R.id.edt_teacher_Name);
        edt_teacher_Surname = (EditText) view.findViewById(R.id.edt_teacher_Surname);
        edt_teacher_PhoneNumber = (EditText) view.findViewById(R.id.edt_teacher_PhoneNumber);
        edt_teacher_Position = (EditText) view.findViewById(R.id.edt_teacher_Position);
        edt_teacher_Faculty = (EditText) view.findViewById(R.id.edt_teacher_Faculty);
        edt_teacher_Department = (EditText) view.findViewById(R.id.edt_teacher_Department);
        edt_teacher_Teach = (EditText) view.findViewById(R.id.edt_teacher_Teach);
        btn_teacher_Submit = (Button) view.findViewById(R.id.btn_teacher_Submit);
    }

    private void init(){
        edt_teacher_ID.setText(""+userId);
        btn_teacher_Submit.setOnClickListener(this);
    }

    private void onSubmit(){
        String InsName = edt_teacher_Name.getText().toString();
        String InsSurname = edt_teacher_Surname.getText().toString();
        String InsPhoneNumber = edt_teacher_PhoneNumber.getText().toString();
        String InsPosition = edt_teacher_Position.getText().toString();
        String InsFaculty = edt_teacher_Faculty.getText().toString();
        String InsDepartment = edt_teacher_Department.getText().toString();
        String InsMajor = edt_teacher_Teach.getText().toString();
        if("".equals(edt_teacher_Name.getText().toString())
                && "".equals(edt_teacher_Surname.getText().toString())
                && "".equals(edt_teacher_PhoneNumber.getText().toString())
                && "".equals(edt_teacher_Position.getText().toString())
                && "".equals(edt_teacher_Faculty.getText().toString())
                && "".equals(edt_teacher_Department.getText().toString())
                && "".equals(edt_teacher_Teach.getText().toString())) {
            Toast.makeText(getContext(), "Please input data", Toast.LENGTH_LONG).show();
        }else{
            if("".equals(edt_teacher_Name.getText().toString())
                    || "".equals(edt_teacher_Surname.getText().toString())
                    || "".equals(edt_teacher_PhoneNumber.getText().toString())
                    || "".equals(edt_teacher_Position.getText().toString())
                    || "".equals(edt_teacher_Faculty.getText().toString())
                    || "".equals(edt_teacher_Department.getText().toString())
                    || "".equals(edt_teacher_Teach.getText().toString())) {
                if ("".equals(edt_teacher_Name.getText().toString()))
                    Toast.makeText(getContext(), "Please input name", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_teacher_Surname.getText().toString()))
                    Toast.makeText(getContext(), "Please input surname", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_teacher_PhoneNumber.getText().toString()))
                    Toast.makeText(getContext(), "Please input phone number", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_teacher_Position.getText().toString()))
                    Toast.makeText(getContext(), "Please input position", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_teacher_Faculty.getText().toString()))
                    Toast.makeText(getContext(), "Please input faculty", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_teacher_Department.getText().toString()))
                    Toast.makeText(getContext(), "Please input department", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_teacher_Teach.getText().toString()))
                    Toast.makeText(getContext(), "Please input teach", Toast.LENGTH_LONG).show();
                else {
                }
            }else{
                if(StatusConnection.connection(getActivity())){
                RegisterTeacherService service = RestServiceManager.create(RegisterTeacherService.class);
                service.register(userId, InsName,
                        InsSurname, InsPhoneNumber,
                        InsPosition, InsFaculty,
                        InsDepartment, InsMajor).enqueue(this);
                }else {
                    Toast.makeText(getContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                }
            }

        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_teacher_Submit:
                onSubmit();
                break;
        }
    }

    @Override
    public void onResponse(Call<MessageResponseDao> call, Response<MessageResponseDao> response) {
        if(response.isSuccessful()){
            MessageResponseDao dao = response.body();
            if(dao.getMsg().equals("0")){
                // fail
                Toast.makeText(getActivity(), "register failed", Toast.LENGTH_LONG).show();
            }else{
                // success
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra("userId", userId);
                startActivity(intent);
            }
        }else
            Toast.makeText(getContext(), "Failed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(Call<MessageResponseDao> call, Throwable t) {
        Toast.makeText(getContext(), "Filed : "+t.getMessage(), Toast.LENGTH_LONG).show();
    }

}
