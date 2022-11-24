package com.numeroscop.Activity;

import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.numeroscop.ApiCall.Model.OtpResBean;
import com.numeroscop.ApiCall.Presenter.OtpPresenter;
import com.numeroscop.ApiCall.View.IOtpView;
import com.numeroscop.R;
import com.numeroscop.Utils.NetworkCheck;
import com.numeroscop.Utils.SharedPreferenceData;
import com.numeroscop.databinding.ActivityOtpBinding;

public class OtpActivity extends BaseActivity implements IOtpView {

    ActivityOtpBinding binding;
    private EditText[] editTexts;
    OtpPresenter otpPresenter;
    SharedPreferenceData ProfileData;
    String otp,mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_otp);

        otpPresenter = new OtpPresenter();
        otpPresenter.setView(this);
        ProfileData = new SharedPreferenceData(this);

         mobile = getIntent().getStringExtra("mobile_no");


        String mask = mobile.replaceAll("\\w(?=\\w{4})", "*");
         binding.txtNumber.setText(mask);

        editTexts = new EditText[]{binding.edtOtp1, binding.edtOtp2, binding.edtOtp3, binding.edtOtp4,binding.edtOtp5};

        binding.edtOtp1.addTextChangedListener(new PinTextWatcher(0));
        binding.edtOtp2.addTextChangedListener(new PinTextWatcher(1));
        binding.edtOtp3.addTextChangedListener(new PinTextWatcher(2));
        binding.edtOtp4.addTextChangedListener(new PinTextWatcher(3));
        binding.edtOtp5.addTextChangedListener(new PinTextWatcher(4));

        binding.edtOtp1.setOnKeyListener(new PinOnKeyListener(0));
        binding.edtOtp2.setOnKeyListener(new PinOnKeyListener(1));
        binding.edtOtp3.setOnKeyListener(new PinOnKeyListener(2));
        binding.edtOtp4.setOnKeyListener(new PinOnKeyListener(3));
        binding.edtOtp5.setOnKeyListener(new PinOnKeyListener(4));


        binding.cvVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.edtOtp1.getText().toString().isEmpty()){
                    Toast.makeText(OtpActivity.this, "Please enter all field", Toast.LENGTH_SHORT).show();
                }
                else if(binding.edtOtp2.getText().toString().isEmpty()){
                    Toast.makeText(OtpActivity.this, "Please enter all field", Toast.LENGTH_SHORT).show();
                }
                else if(binding.edtOtp3.getText().toString().isEmpty()){
                    Toast.makeText(OtpActivity.this, "Please enter all field", Toast.LENGTH_SHORT).show();
                }
                else if(binding.edtOtp4.getText().toString().isEmpty()){
                    Toast.makeText(OtpActivity.this, "Please enter all field", Toast.LENGTH_SHORT).show();
                }
                else if(binding.edtOtp5.getText().toString().isEmpty()){
                    Toast.makeText(OtpActivity.this, "Please enter all field", Toast.LENGTH_SHORT).show();
                }
                else if(NetworkCheck.isConnected(OtpActivity.this)){

                    otpPresenter.OtpCall(OtpActivity.this,binding.edtOtp1.getText().toString()+ binding.edtOtp2.getText().toString()+ binding.edtOtp3.getText().toString()+
                            binding.edtOtp4.getText().toString()+ binding.edtOtp5.getText().toString(),mobile);
                }
                else{
                    NetworkCheck.showNetworkFailureAlert(OtpActivity.this);
                }

            }
        });
    }

    @Override
    public void onOtpSuccess(OtpResBean item) {
        if(item.isStatus()){
            new SharedPreferenceData(this).SavedLoginData(item);
            Intent intent = new Intent(OtpActivity.this,MainActivity.class);
            Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public Context getContext() {
        return this;
    }

    public class PinTextWatcher implements TextWatcher {

        private int currentIndex;
        private boolean isFirst = false, isLast = false;
        private String newTypedString = "";

        PinTextWatcher(int currentIndex) {
            this.currentIndex = currentIndex;

            if (currentIndex == 0)
                this.isFirst = true;
            else if (currentIndex == editTexts.length - 1)
                this.isLast = true;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            newTypedString = s.subSequence(start, start + count).toString().trim();
        }

        @Override
        public void afterTextChanged(Editable s) {

            String text = newTypedString;

            if (text.length() > 1)
                text = String.valueOf(text.charAt(0)); // TODO: We can fill out other EditTexts

            editTexts[currentIndex].removeTextChangedListener(this);
            editTexts[currentIndex].setText(text);
            editTexts[currentIndex].setSelection(text.length());
            editTexts[currentIndex].addTextChangedListener(this);

            if (text.length() == 1)
                moveToNext();
            else if (text.length() == 0)
                moveToPrevious();
        }

        private void moveToNext() {
            if (!isLast)
                editTexts[currentIndex + 1].requestFocus();

            if (isAllEditTextsFilled() && isLast) { // isLast is optional
                editTexts[currentIndex].clearFocus();
                hideKeyboard();
            }
        }

        private void moveToPrevious() {
            if (!isFirst)
                editTexts[currentIndex - 1].requestFocus();
        }

        private boolean isAllEditTextsFilled() {
            for (EditText editText : editTexts)
                if (editText.getText().toString().trim().length() == 0)
                    return false;
            return true;
        }

        private void hideKeyboard() {
            if (getCurrentFocus() != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        }

    }

    public class PinOnKeyListener implements View.OnKeyListener {

        private int currentIndex;

        PinOnKeyListener(int currentIndex) {
            this.currentIndex = currentIndex;
        }

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_UP) {
                if (editTexts[currentIndex].getText().toString().isEmpty() && currentIndex != 0)
                    editTexts[currentIndex - 1].requestFocus();
            }
            return false;
        }

    }
}