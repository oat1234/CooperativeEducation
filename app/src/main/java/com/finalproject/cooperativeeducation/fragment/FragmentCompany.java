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
import com.finalproject.cooperativeeducation.controller.Utils.Validator;
import com.finalproject.cooperativeeducation.manager.RestServiceManager;
import com.finalproject.cooperativeeducation.manager.service.RegisterService;

/**
 * Created by master on 20/3/2559.
 */
public class FragmentCompany extends Fragment implements View.OnClickListener{
    private EditText edt_company_Name;
    private EditText edt_company_Surname;
    private EditText edt_company_PhoneNumber;
    private EditText edt_company_CompanyName;
    private EditText edt_company_Business;
    private EditText edt_company_Address;
    private EditText edt_company_Email;
    private Button btn_company_Submit;

    public FragmentCompany(){

    }

    public static FragmentCompany newInstance(){
        FragmentCompany fragment = new FragmentCompany();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_company_fragment, container, false);

        initView(view);
        init();
        return view;

    }
    private void initView(View view){
        edt_company_Name = (EditText) view.findViewById(R.id.edt_company_Name);
        edt_company_Surname = (EditText) view.findViewById(R.id.edt_company_Surname);
        edt_company_PhoneNumber = (EditText) view.findViewById(R.id.edt_company_PhoneNumber);
        edt_company_CompanyName = (EditText) view.findViewById(R.id.edt_company_CompanyName);
        edt_company_Business = (EditText) view.findViewById(R.id.edt_company_Business);
        edt_company_Address = (EditText) view.findViewById(R.id.edt_company_Address);
        edt_company_Email  = (EditText) view.findViewById(R.id.edt_company_Email);
        btn_company_Submit = (Button) view.findViewById(R.id.btn_company_Submit);
    }

    private void init(){
        btn_company_Submit.setOnClickListener(this);
    }

    private void onSubmit(){
        if("".equals(edt_company_Name.getText().toString())
                && "".equals(edt_company_Surname.getText().toString())
                && "".equals(edt_company_PhoneNumber.getText().toString())
                && "".equals(edt_company_CompanyName.getText().toString())
                && "".equals(edt_company_Business.getText().toString())
                && "".equals(edt_company_Address.getText().toString())
                && "".equals(edt_company_Email.getText().toString())) {
            Toast.makeText(getContext(), "Please input data", Toast.LENGTH_LONG).show();
        }else{
            if("".equals(edt_company_Name.getText().toString())
                    || "".equals(edt_company_Surname.getText().toString())
                    || "".equals(edt_company_PhoneNumber.getText().toString())
                    || "".equals(edt_company_CompanyName.getText().toString())
                    || "".equals(edt_company_Business.getText().toString())
                    || "".equals(edt_company_Address.getText().toString())
                    || "".equals(edt_company_Email.getText().toString())){
                if("".equals(edt_company_Name.getText().toString()))
                    Toast.makeText(getContext(), "Please input name", Toast.LENGTH_LONG).show();
                else if("".equals(edt_company_Surname.getText().toString()))
                    Toast.makeText(getContext(), "Please input surname", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_company_PhoneNumber.getText().toString()))
                    Toast.makeText(getContext(), "Please input phone number", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_company_CompanyName.getText().toString()))
                    Toast.makeText(getContext(), "Please input company name", Toast.LENGTH_LONG) .show();
                else if ("".equals(edt_company_Business.getText().toString()))
                    Toast.makeText(getContext(), "Please input business", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_company_Address.getText().toString()))
                    Toast.makeText(getContext(), "Please input address", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_company_Email.getText().toString()))
                    Toast.makeText(getContext(), "Please input E-mail", Toast.LENGTH_LONG).show();
            }else{
                if(!Validator.emailValidator(edt_company_Email.getText().toString()))
                    Toast.makeText(getContext(), "format e-mail iscorrect", Toast.LENGTH_LONG).show();
                else{

                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_company_Submit:
                onSubmit();
                break;
        }
    }
}
