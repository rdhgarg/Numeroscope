package com.numeroscop.Activity;

import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.numeroscop.ApiCall.Model.RegisterResBean;
import com.numeroscop.ApiCall.Presenter.RegisterPresenter;
import com.numeroscop.ApiCall.View.IRegisterView;
import com.numeroscop.R;
import com.numeroscop.Utils.NetworkCheck;
import com.numeroscop.Utils.SharedPreferenceData;
import com.numeroscop.Utils.Utils;
import com.numeroscop.databinding.ActivityRegisterBinding;

public class RegisterActivity extends BaseActivity implements View.OnClickListener, IRegisterView {

    ActivityRegisterBinding binding;
    RegisterPresenter registerPresenter;
    SharedPreferenceData profileData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this,R.layout.activity_register);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        registerPresenter = new RegisterPresenter();
        registerPresenter.setView(this);
        profileData = new SharedPreferenceData(this);

       binding.cvRegister.setOnClickListener(this);
       binding.txtLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cvRegister:
                if(binding.edtName.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "please enter full name", Toast.LENGTH_SHORT).show();
                }
                else if(binding.edtMobileNumber.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "please enter mobile number", Toast.LENGTH_SHORT).show();
                }
                else if(binding.edtMobileNumber.getText().toString().length()<=7 || binding.edtMobileNumber.getText().toString().length()>=20){
                    Toast.makeText(RegisterActivity.this, "please enter valid mobile number", Toast.LENGTH_SHORT).show();
                }
                else if(binding.edtEmailId.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "please enter email id", Toast.LENGTH_SHORT).show();
                }
                else if(!Utils.isEmailValid(binding.edtEmailId.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "please enter valid email id", Toast.LENGTH_SHORT).show();
                }
                else if(NetworkCheck.isConnected(RegisterActivity.this)){
                    registerPresenter.RegisterCall(RegisterActivity.this,profileData.getACCESS_TOKEN(),binding.edtName.getText().toString(),binding.edtMobileNumber.getText().toString(),
                            binding.edtEmailId.getText().toString());
                }
                else{
                    NetworkCheck.showNetworkFailureAlert(RegisterActivity.this);
                }
                break;

            case R.id.txtLogin:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void onRegisterSuccess(RegisterResBean item) {

        if(item.isStatus()){
            Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this,OtpActivity.class);
            intent.putExtra("mobile_no",item.getMobile().toString());
            startActivity(intent);
          //  finish();

        }else{
            Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public Context getContext() {
        return this;
    }

}