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

import com.finalproject.cooperativeeducation.Util.StatusConnection;
import com.finalproject.cooperativeeducation.activity.R;
import com.finalproject.cooperativeeducation.manager.RestServiceManager;
import com.finalproject.cooperativeeducation.manager.service.RegisterService;

/**
 * Created by master on 20/3/2559.
 */
public class FragmentStudent extends Fragment implements View.OnClickListener{

    private EditText edt_student_Name;
    private EditText edt_student_Surname;
    private EditText edt_student_PhoneNumber;
    private EditText edt_student_StudentNumber;
    private EditText edt_student_Position;
    private EditText edt_student_Detail;
    private EditText edt_student_Enterprise;
    private EditText edt_student_Address;
    private Button btn_student_Submit;

    public FragmentStudent(){

    }
    public static FragmentStudent newInstance(){
        FragmentStudent fragment = new FragmentStudent();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_student_fragment, container, false);
        initView(view);
        init();

        return view;
    }

    private void initView(View view){
        edt_student_Name = (EditText) view.findViewById(R.id.edt_student_Name);
        edt_student_Surname = (EditText) view.findViewById(R.id.edt_student_Surname);
        edt_student_PhoneNumber = (EditText) view.findViewById(R.id.edt_student_PhoneNumber);
        edt_student_StudentNumber = (EditText) view.findViewById(R.id.edt_student_StudentNumber);
        edt_student_Position = (EditText) view.findViewById(R.id.edt_student_Position);
        edt_student_Detail = (EditText) view.findViewById(R.id.edt_student_Detail);
        edt_student_Enterprise = (EditText) view.findViewById(R.id.edt_student_Enterprise);
        edt_student_Address = (EditText) view.findViewById(R.id.edt_student_Address);
        btn_student_Submit = (Button) view.findViewById(R.id.btn_student_Submit);
    }

    private void init(){
        btn_student_Submit.setOnClickListener(this);
    }

    private void onSubmit(){
        if("".equals(edt_student_Name.getText().toString())
                && "".equals(edt_student_Surname.getText().toString())
                && "".equals(edt_student_PhoneNumber.getText().toString())
                && "".equals(edt_student_StudentNumber.getText().toString())
                && "".equals(edt_student_Position.getText().toString())
                && "".equals(edt_student_Detail.getText().toString())
                && "".equals(edt_student_Enterprise.getText().toString())
                && "".equals(edt_student_Address.getText().toString())) {
            Toast.makeText(getContext(), "Please input data", Toast.LENGTH_LONG).show();
        }else{
            if("".equals(edt_student_Name.getText().toString())
                    || "".equals(edt_student_Surname.getText().toString())
                    || "".equals(edt_student_PhoneNumber.getText().toString())
                    || "".equals(edt_student_StudentNumber.getText().toString())
                    || "".equals(edt_student_Position.getText().toString())
                    || "".equals(edt_student_Detail.getText().toString())
                    || "".equals(edt_student_Enterprise.getText().toString())
                    || "".equals(edt_student_Address.getText().toString())){
                if("".equals(edt_student_Name.getText().toString()))
                    Toast.makeText(getContext(), "Please input name", Toast.LENGTH_LONG).show();
                else if("".equals(edt_student_Surname.getText().toString()))
                    Toast.makeText(getContext(), "Please input surname", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_student_PhoneNumber.getText().toString()))
                    Toast.makeText(getContext(), "Please input phone number", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_student_StudentNumber.getText().toString()))
                    Toast.makeText(getContext(), "Please input student Number", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_student_Position.getText().toString()))
                    Toast.makeText(getContext(), "Please input position", Toast.LENGTH_LONG) .show();
                else if ("".equals(edt_student_Detail.getText().toString()))
                    Toast.makeText(getContext(), "Please input detail", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_student_Enterprise.getText().toString()))
                    Toast.makeText(getContext(), "Please input enterprise", Toast.LENGTH_LONG) .show();
                else if ("".equals(edt_student_Address.getText().toString()))
                    Toast.makeText(getContext(), "Please input address", Toast.LENGTH_LONG).show();
                else{
                    if(false){

                    }else{
//                        if(StatusConnection.connection(getActivity())){
//                            RegisterService call = RestServiceManager.create(RegisterService.class);
//                            call.register(edt_company_Name.getText().toString(),
//                                    edt_company_Surname.getText().toString(),
//                                    "112234455667",
//                                    )
//                        }
                    }
                }

            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_student_Submit:
                onSubmit();
                break;
        }
    }

}
