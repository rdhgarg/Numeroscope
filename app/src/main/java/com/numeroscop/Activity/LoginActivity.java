package com.numeroscop.Activity;

import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.numeroscop.ApiCall.Model.LoginResBean;
import com.numeroscop.ApiCall.Presenter.LoginPresenter;
import com.numeroscop.ApiCall.View.ILoginView;
import com.numeroscop.R;
import com.numeroscop.Utils.NetworkCheck;
import com.numeroscop.Utils.SharedPreferenceData;
import com.numeroscop.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity implements View.OnClickListener, ILoginView {

    ActivityLoginBinding binding;
    LoginPresenter loginPresenter;
    SharedPreferenceData profileData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);

        loginPresenter = new LoginPresenter();
        loginPresenter.setView(this);
        profileData = new SharedPreferenceData(this);

        binding.cvLogin.setOnClickListener(this);
        binding.txtRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cvLogin:
                if(binding.edtMobile.getText().toString().isEmpty()){
                    Toast.makeText(this, "please enter mobile number", Toast.LENGTH_SHORT).show();
                }else if(binding.edtMobile.getText().toString().length()<=7 || binding.edtMobile.getText().toString().length()>=20){
                    Toast.makeText(this, "please enter valid mobile number", Toast.LENGTH_SHORT).show();
                }
                else if(NetworkCheck.isConnected(this)){

                    loginPresenter.LoginCall(this,profileData.getACCESS_TOKEN(),binding.edtMobile.getText().toString());
                }
                else{
                    NetworkCheck.showNetworkFailureAlert(this);
                }
                break;

            case R.id.txtRegister:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;

        }
    }

    @Override
    public void onLoginSuccess(LoginResBean item) {
        if(item.isStatus()){
            Intent intent = new Intent(this,OtpActivity.class);
            intent.putExtra("mobile_no",binding.edtMobile.getText().toString());
            Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
            startActivity(intent);
         //   finish();
        }else{
            Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public Context getContext() {
        return this;
    }
}