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
import com.finalproject.cooperativeeducation.manager.service.RegisterCompanyService;
import com.finalproject.cooperativeeducation.manager.service.RegisterService;


import org.parceler.Parcels;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by master on 20/3/2559.
 */
public class FragmentCompany extends Fragment implements View.OnClickListener, Callback<MessageResponseDao> {
    private EditText edt_company_ID;
    private EditText edt_company_Name;
    private EditText edt_company_Surname;
    private EditText edt_company_Position;
    private EditText edt_company_PhoneNumber;
    private EditText edt_company_CompanyName;
    private EditText edt_company_Business;
    private EditText edt_company_Address;
    private Button btn_company_Submit;

    private int userId;

    public FragmentCompany(){

    }

    public static FragmentCompany newInstance(){
        FragmentCompany fragment = new FragmentCompany();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_company_fragment, container, false);
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
        edt_company_ID = (EditText) view.findViewById(R.id.edt_company_ID);
        edt_company_Name = (EditText) view.findViewById(R.id.edt_company_Name);
        edt_company_Surname = (EditText) view.findViewById(R.id.edt_company_Surname);
        edt_company_Position = (EditText) view.findViewById(R.id.edt_company_Position);
        edt_company_PhoneNumber = (EditText) view.findViewById(R.id.edt_company_PhoneNumber);
        edt_company_CompanyName = (EditText) view.findViewById(R.id.edt_company_CompanyName);
        edt_company_Business = (EditText) view.findViewById(R.id.edt_company_Business);
        edt_company_Address = (EditText) view.findViewById(R.id.edt_company_Address);
        btn_company_Submit = (Button) view.findViewById(R.id.btn_company_Submit);
    }

    private void init(){
        edt_company_ID.setText(""+userId);
        btn_company_Submit.setOnClickListener(this);
    }

    private void onSubmit(){
        String EntName = edt_company_Name.getText().toString();
        String EntSurname = edt_company_Surname.getText().toString();
        String EntPosition = edt_company_Position.getText().toString();
        String EntPhoneNumber = edt_company_PhoneNumber.getText().toString();
        String EntCompanyName = edt_company_CompanyName.getText().toString();
        String EntBusiness = edt_company_Business.getText().toString();
        String EntAddress = edt_company_Address.getText().toString();

        if("".equals(edt_company_Name.getText().toString())
                && "".equals(edt_company_Surname.getText().toString())
                && "".equals(edt_company_Position.getText().toString())
                && "".equals(edt_company_PhoneNumber.getText().toString())
                && "".equals(edt_company_CompanyName.getText().toString())
                && "".equals(edt_company_Business.getText().toString())
                && "".equals(edt_company_Address.getText().toString())) {
            Toast.makeText(getContext(), "Please input data", Toast.LENGTH_LONG).show();
        }else{
            if("".equals(edt_company_Name.getText().toString())
                    || "".equals(edt_company_Surname.getText().toString())
                    || "".equals(edt_company_Position.getText().toString())
                    || "".equals(edt_company_PhoneNumber.getText().toString())
                    || "".equals(edt_company_CompanyName.getText().toString())
                    || "".equals(edt_company_Business.getText().toString())
                    || "".equals(edt_company_Address.getText().toString())){
                if("".equals(edt_company_Name.getText().toString()))
                    Toast.makeText(getContext(), "Please input name", Toast.LENGTH_LONG).show();
                else if("".equals(edt_company_Surname.getText().toString()))
                    Toast.makeText(getContext(), "Please input surname", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_company_Position.getText().toString()))
                    Toast.makeText(getContext(), "Please input position", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_company_PhoneNumber.getText().toString()))
                    Toast.makeText(getContext(), "Please input phone number", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_company_CompanyName.getText().toString()))
                    Toast.makeText(getContext(), "Please input company name", Toast.LENGTH_LONG) .show();
                else if ("".equals(edt_company_Business.getText().toString()))
                    Toast.makeText(getContext(), "Please input business", Toast.LENGTH_LONG).show();
                else if ("".equals(edt_company_Address.getText().toString()))
                    Toast.makeText(getContext(), "Please input address", Toast.LENGTH_LONG).show();
                else{

                }

            }else{
                if(StatusConnection.connection(getActivity())){
                    RegisterCompanyService service = RestServiceManager.create(RegisterCompanyService.class);
                    service.register(userId, EntName, EntSurname,
                            EntPosition, EntPhoneNumber, EntCompanyName,
                            EntBusiness, EntAddress).enqueue(this);
                }else{
                    Toast.makeText(getContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
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
