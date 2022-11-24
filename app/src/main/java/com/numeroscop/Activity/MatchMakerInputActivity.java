package com.numeroscop.Activity;

import androidx.databinding.DataBindingUtil;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import com.numeroscop.R;
import com.numeroscop.databinding.ActivityMatchMakerInputBinding;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MatchMakerInputActivity extends BaseActivity implements View.OnClickListener{
    ActivityMatchMakerInputBinding binding;
    private int mYear;
    private int mMonth;
    private int mDay;
    Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_match_maker_input);

        init();
    }

    private  void init(){

        binding.txtSelectDate.setOnClickListener(this);
        binding.txtFSelectDate.setOnClickListener(this);
        binding.cvSubmit.setOnClickListener(this);
        binding.imgBack.setOnClickListener(this);

        c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


    }

    private void openCalender(TextView textView){

        DatePickerDialog dpd = new DatePickerDialog(MatchMakerInputActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        c.set(year, month, day);
                        String date = new SimpleDateFormat("dd-MM-yyyy").format(c.getTime());
                        textView.setText(date);
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



    @Override
    public void onClick(View view) {

        if (binding.txtSelectDate == view){
            openCalender(binding.txtSelectDate);
        }else if(binding.txtFSelectDate == view){
            openCalender(binding.txtFSelectDate);
        }else if(binding.cvSubmit == view){

            if(binding.edtName.getText().toString().isEmpty()){
                Toast.makeText(this, "Please Fill Name Male ", Toast.LENGTH_SHORT).show();
            }else if(binding.edtName2.getText().toString().isEmpty()){
                Toast.makeText(this, "Please Fill Name Female ", Toast.LENGTH_SHORT).show();
            }else if(binding.txtSelectDate.getText().toString().equalsIgnoreCase("Select Date of Birth")){
                Toast.makeText(this, "Select Date of Birth Male ", Toast.LENGTH_SHORT).show();
            }else if(binding.txtFSelectDate.getText().toString().equalsIgnoreCase("Select Date of Birth")){
                Toast.makeText(this, "Select Date of Birth Female", Toast.LENGTH_SHORT).show();
            }else{

                String s1 = binding.txtSelectDate.getText().toString().replace("-","");
                String s2 = binding.txtFSelectDate.getText().toString().replace("-","");
                Intent intent = new Intent(MatchMakerInputActivity.this,MatchMakerResultActivity.class);
                intent.putExtra("male_dob",s1);
                intent.putExtra("female_dob",s2);
                intent.putExtra("male_name",binding.edtName.getText().toString().trim());
                intent.putExtra("female_name",binding.edtName2.getText().toString().trim());
                startActivity(intent);
            }

        }else if(binding.imgBack == view){
            finish();
        }
    }
}