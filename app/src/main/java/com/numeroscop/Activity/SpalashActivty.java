package com.numeroscop.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.numeroscop.R;
import com.numeroscop.Utils.SharedPreferenceData;

public class SpalashActivty extends AppCompatActivity {

    int delay = 6000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalash_activty);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    /*if(new SharedPreferenceData(SpalashActivty.this).IsLogin()){
                        Intent intent = new Intent(SpalashActivty.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else{*/
                        Intent intent = new Intent(SpalashActivty.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                    //}
                }
            },delay);

        }

}