package com.finalproject.cooperativeeducation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.finalproject.cooperativeeducation.activity.R;
import com.finalproject.cooperativeeducation.controller.Utils.Validator;

/**
 * Created by master on 20/3/2559.
 */
public class FragmentTeacher extends Fragment implements View.OnClickListener {
    private EditText edt_teacher_Name;
    private EditText edt_teacher_Surname;
    private EditText edt_teacher_PhoneNumber;
    private EditText edt_teacher_Position;
    private EditText edt_teacher_Faculty;
    private EditText edt_teacher_Department;
    private EditText edt_teacher_Teach;
    private EditText edt_teacher_Email;
    private Button btn_teacher_Submit;

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
        initView(view);
        init();
        return view;
    }
    private void initView(View view){
        edt_teacher_Name = (EditText) view.findViewById(R.id.edt_teacher_Name);
        edt_teacher_Surname = (EditText) view.findViewById(R.id.edt_teacher_Surname);
        edt_teacher_PhoneNumber = (EditText) view.findViewById(R.id.edt_teacher_PhoneNumber);
        edt_teacher_Position = (EditText) view.findViewById(R.id.edt_teacher_Position);
        edt_teacher_Faculty = (EditText) view.findViewById(R.id.edt_teacher_Faculty);
        edt_teacher_Department = (EditText) view.findViewById(R.id.edt_teacher_Department);
        edt_teacher_Teach = (EditText) view.findViewById(R.id.edt_teacher_Teach);
        edt_teacher_Email  = (EditText) view.findViewById(R.id.edt_teacher_Email);
        btn_teacher_Submit = (Button) view.findViewById(R.id.btn_teacher_Submit);
    }

    private void init(){
        btn_teacher_Submit.setOnClickListener(this);
    }

    private boolean validator(){
        if("".equals(edt_teacher_Name.getText().toString())
                && "".equals(edt_teacher_Surname.getText().toString())
                && "".equals(edt_teacher_PhoneNumber.getText().toString())
                && "".equals(edt_teacher_Position.getText().toString())
                && "".equals(edt_teacher_Faculty.getText().toString())
                && "".equals(edt_teacher_Department.getText().toString())
                && "".equals(edt_teacher_Teach.getText().toString())
                && "".equals(edt_teacher_Email.getText().toString())) {
            Toast.makeText(getContext(), "Please input data", Toast.LENGTH_LONG).show();
            return false;
        }else{
            if("".equals(edt_teacher_Name.getText().toString())
                    || "".equals(edt_teacher_Surname.getText().toString())
                    || "".equals(edt_teacher_PhoneNumber.getText().toString())
                    || "".equals(edt_teacher_Position.getText().toString())
                    || "".equals(edt_teacher_Faculty.getText().toString())
                    || "".equals(edt_teacher_Department.getText().toString())
                    || "".equals(edt_teacher_Teach.getText().toString())
                    || "".equals(edt_teacher_Email.getText().toString())){
                if("".equals(edt_teacher_Name.getText().toString()))
                    Toast.makeText(getContext(), "Please input name", Toast.LENGTH_LONG).show();
                else if("".equals(edt_teacher_Surname.getText().toString()))
                    Toast.makeText(getContext(), "Please input surname", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_teacher_PhoneNumber.getText().toString()))
                    Toast.makeText(getContext(), "Please input phone number", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_teacher_Position.getText().toString()))
                    Toast.makeText(getContext(), "Please input position", Toast.LENGTH_LONG) .show();
                else if ("".equals(edt_teacher_Faculty.getText().toString()))
                    Toast.makeText(getContext(), "Please input faculty", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_teacher_Department.getText().toString()))
                    Toast.makeText(getContext(), "Please input department", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_teacher_Teach.getText().toString()))
                    Toast.makeText(getContext(), "Please input teach", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_teacher_Email.getText().toString()))
                    Toast.makeText(getContext(), "Please input E-mail", Toast.LENGTH_LONG).show();

                return false;
            }else {
                if (!Validator.emailValidator(edt_teacher_Email.getText().toString())) {
                    Toast.makeText(getContext(), "format e-mail iscorrect", Toast.LENGTH_LONG).show();
                    return false;
                }
                return true;
            }

        }
    }

    private void onSubmit(){
        if(validator()){

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
}
