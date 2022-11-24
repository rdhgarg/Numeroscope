package com.numeroscop.Activity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.numeroscop.ApiCall.Model.PersonalDateResBean;
import com.numeroscop.ApiCall.Presenter.PersonalDatePresenter;
import com.numeroscop.ApiCall.View.IPersonalDateView;
import com.numeroscop.R;
import com.numeroscop.Utils.NetworkCheck;
import com.numeroscop.Utils.SharedPreferenceData;
import com.numeroscop.databinding.ActivityPersonalMonthBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PersonalMonthActivity extends BaseActivity implements IPersonalDateView {

    ActivityPersonalMonthBinding binding;
    SharedPreferenceData profiledata;
    PersonalDatePresenter presenter;
    Dialog dialog;
    TextView textView,textOk;
    ImageView imageView;
    private int mYear;
    private int mMonth;
    private int mDay;
    String str="";
    String strDateOfBirth ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_personal_month);

        presenter = new PersonalDatePresenter();
        presenter.setView(this);
        profiledata = new SharedPreferenceData(this);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.month_reponse_dialog_layout);
        dialog.setCancelable(false);
        textView = dialog.findViewById(R.id.txtRespose);
        imageView = dialog.findViewById(R.id.imgCross);
        textOk = dialog.findViewById(R.id.txtOk);

        Window window = dialog.getWindow();
        window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        textOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        binding.txtSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatePickerDialog dpd = new DatePickerDialog(PersonalMonthActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int day) {
                                c.set(year, month, day);
                                String date = new SimpleDateFormat("dd-MM-yyyy").format(c.getTime());
                                binding.txtSelectDate.setText(date);
                                strDateOfBirth = date;
                                parseDateToddMMyyyy(date);
                                mYear = c.get(Calendar.YEAR);
                                mMonth = c.get(Calendar.MONTH);
                                mDay = c.get(Calendar.DAY_OF_MONTH);
                            }
                        }, mYear, mMonth, mDay);
                dpd.getDatePicker().setMaxDate(System.currentTimeMillis());

                // Calendar d = Calendar.getInstance();

                dpd.updateDate(mYear,mMonth,mDay);
                dpd.show();
            }
        });


        binding.txtSelectDesiredDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatePickerDialog dpd = new DatePickerDialog(PersonalMonthActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int day) {
                                c.set(year, month, day);
                                String date = new SimpleDateFormat("dd-MM-yyyy").format(c.getTime());
                                binding.txtSelectDesiredDate.setText(date);
                                strDateOfBirth = date;
                                parseDateToddMMyyyy(date);
                                mYear = c.get(Calendar.YEAR);
                                mMonth = c.get(Calendar.MONTH);
                                mDay = c.get(Calendar.DAY_OF_MONTH);
                            }
                        }, mYear, mMonth, mDay);
                dpd.getDatePicker().setMaxDate(System.currentTimeMillis());

                // Calendar d = Calendar.getInstance();

                dpd.updateDate(mYear,mMonth,mDay);
                dpd.show();
            }
        });

        binding.cvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(str.isEmpty()){
                    Toast.makeText(PersonalMonthActivity.this, "Please select your date of birth", Toast.LENGTH_SHORT).show();
                }else if(binding.txtSelectDesiredDate.getText().toString().equalsIgnoreCase("Select Desired Date")){
                    Toast.makeText(PersonalMonthActivity.this, "Please select desired date", Toast.LENGTH_SHORT).show();
                }else if(NetworkCheck.isConnected(PersonalMonthActivity.this)){
                    presenter.PersonalDateCall(PersonalMonthActivity.this,profiledata.getACCESS_TOKEN(),str,str);
                }else{

                    NetworkCheck.showNetworkFailureAlert(PersonalMonthActivity.this);
                }
            }
        });
    }


    private void  parseDateToddMMyyyy(String time) {
        String inputPattern = "dd-MM-yyyy";
        String outputPattern = "ddMMyyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.e("DAATTA",str);
    }

    @Override
    public void onPersonalDateSucess(PersonalDateResBean item) {
        if(item.isStatus()){
            //Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
            textView.setText(item.getData());
            dialog.show();
        }else{
            Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public Context getContext() {
        return null;
    }
}