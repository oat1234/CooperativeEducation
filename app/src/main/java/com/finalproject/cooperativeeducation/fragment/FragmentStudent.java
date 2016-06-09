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
import com.finalproject.cooperativeeducation.manager.RestServiceManager;
import com.finalproject.cooperativeeducation.manager.dao.GetRegisterDao;
import com.finalproject.cooperativeeducation.manager.dao.MessageResponseDao;
import com.finalproject.cooperativeeducation.manager.service.RegisterService;
import com.finalproject.cooperativeeducation.manager.service.RegisterStudentService;

import org.parceler.Parcels;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by master on 20/3/2559.
 */
public class FragmentStudent extends Fragment implements View.OnClickListener, Callback<MessageResponseDao>{
    private EditText edt_student_ID;
    private EditText edt_student_Name;
    private EditText edt_student_Surname;
    private EditText edt_student_PhoneNumber;
    private EditText edt_student_StudentNumber;
    private EditText edt_student_Position;
    private EditText edt_student_Detail;
    private EditText edt_student_Enterprise;
    private EditText edt_student_Address;
    private Button btn_student_Submit;

    private int userId;

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
        edt_student_ID = (EditText) view.findViewById(R.id.edt_student_ID);
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
        edt_student_ID.setText(""+userId);
        btn_student_Submit.setOnClickListener(this);
    }

    private void onSubmit(){
        String stuName = edt_student_Name.getText().toString();
        String stuSurname = edt_student_Surname.getText().toString();
        String stuPhoneNumber = edt_student_PhoneNumber.getText().toString();
        String stuStudentNumber = edt_student_StudentNumber.getText().toString();
        String stuPosition = edt_student_Position.getText().toString();
        String stuDetail = edt_student_Detail.getText().toString();
        String stuEnterprise = edt_student_Enterprise.getText().toString();
        String stuAddress = edt_student_Address.getText().toString();

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

                }

            }else{
                if(StatusConnection.connection(getActivity())){
                    RegisterStudentService service = RestServiceManager.create(RegisterStudentService.class);
                    service.register(userId, stuName,
                            stuSurname, stuPhoneNumber,
                            stuStudentNumber, stuPosition,
                            stuDetail, stuEnterprise, stuAddress).enqueue(this);
                }else{
                    Toast.makeText(getContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
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
