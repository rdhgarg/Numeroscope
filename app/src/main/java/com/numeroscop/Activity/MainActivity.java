package com.numeroscop.Activity;

import static com.google.android.play.core.install.model.AppUpdateType.IMMEDIATE;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.numeroscop.ApiCall.Model.GetNumberResBean;
import com.numeroscop.ApiCall.Presenter.GetNumberPresenter;
import com.numeroscop.ApiCall.View.IGetNumberView;
import com.numeroscop.R;
import com.numeroscop.Utils.NetworkCheck;
import com.numeroscop.Utils.SharedPreferenceData;
import com.numeroscop.databinding.ActivityMainBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends BaseActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener, IGetNumberView {
    ActivityMainBinding binding;
    private boolean doubleBackToExitPressedOnce = false;
    GetNumberPresenter getNumberPresenter;
    SharedPreferenceData ProfileData;
    String gender;
    String StrDate ="";
    private int mYear;
    private int mMonth;
    private int mDay;
    String str="";
    String strDateOfBirth ="";
    private int MY_REQUEST_CODE=1000;
    AppUpdateManager appUpdateManager;
    TextView txtUserName, txtNumber, txtEmailId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        getNumberPresenter = new GetNumberPresenter();
        getNumberPresenter.setView(this);
        ProfileData = new SharedPreferenceData(this);

        NavigationView navigationView = (NavigationView) findViewById(R.id.NavMenu);
        View header = navigationView.getHeaderView(0);
        txtUserName = (TextView) header.findViewById(R.id.txtUserName);
        txtNumber = (TextView) header.findViewById(R.id.txtNumber);
        txtEmailId = (TextView) header.findViewById(R.id.txtEmailId);
        //ImageView imgEdit = (ImageView) header.findViewById(R.id.imgEdit);
        setHeaderData();

        binding.txtName.setText(ProfileData.getUser_name());

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        binding.txtSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatePickerDialog dpd = new DatePickerDialog(MainActivity.this,
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

        binding.cvSubmit.setOnClickListener(this);
        binding.imgMenu.setOnClickListener(this);
        binding.imgInfo.setOnClickListener(this);
        binding.NavMenu.setNavigationItemSelectedListener(this);

        int Id = binding.RadioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(Id);
        gender = radioButton.getText().toString();

        binding.RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int Id = binding.RadioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(Id);
                gender = radioButton.getText().toString();

            }
        });

        binding.txtLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.Drawer.closeDrawer(GravityCompat.START);
                ProfileData.Logout();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ActivityCompat.finishAffinity(MainActivity.this);
                startActivity(intent);
                finish();
            }
        });


    }

    private void setHeaderData() {
        txtUserName.setText(ProfileData.getUser_name());
        txtNumber.setText(ProfileData.getMobile_no());
        txtEmailId.setText(ProfileData.getEmail());
    }

    @Override
    public void onResume(){
        super.onResume();
        appUpdateManager = AppUpdateManagerFactory.create(this);

// Returns an intent object that you use to check for an update.
        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();
        appUpdateManager
                .getAppUpdateInfo()
                .addOnSuccessListener(
                        appUpdateInfo -> {
                            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                                    && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)) {
                                // If an in-app update is already running, resume the update.
                                try {
                                    appUpdateManager.startUpdateFlowForResult(appUpdateInfo, IMMEDIATE,
                                            this, MY_REQUEST_CODE);
                                } catch (IntentSender.SendIntentException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode != RESULT_OK) {
                InstallStateUpdatedListener listener = state -> {
                    if (state.installStatus() == InstallStatus.DOWNLOADED) {
                        // After the update is downloaded, show a notification
                        // and request user confirmation to restart the app.
                        popupSnackbarForCompleteUpdate();
                    }
                };
            }
        }
    }

    // Displays the snackbar notification and call to action.
    private void popupSnackbarForCompleteUpdate() {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.consRoot), "An update has just been downloaded.",
                        Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("RESTART", view -> appUpdateManager.completeUpdate());
        snackbar.setActionTextColor(getResources().getColor(R.color.black));
        snackbar.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cvSubmit:
                if(binding.edtName.getText().toString().isEmpty()){
                    Toast.makeText(this, "please enter full name", Toast.LENGTH_SHORT).show();
                }
                else if(binding.edtMobileNumber.getText().toString().isEmpty()){
                    Toast.makeText(this, "please enter mobile number", Toast.LENGTH_SHORT).show();
                }
                else if(str.isEmpty()){
                    Toast.makeText(this, "please select date of birth", Toast.LENGTH_SHORT).show();
                }
                else if(NetworkCheck.isConnected(this)){
                    getNumberPresenter.GetNumberCall(this,ProfileData.getACCESS_TOKEN(),binding.edtName.getText().toString().trim(),
                            binding.edtMobileNumber.getText().toString().trim(),str,gender);
                }
                else {
                    NetworkCheck.showNetworkFailureAlert(this);
                }

                break;

            case R.id.imgInfo:
                Intent intent = new Intent(MainActivity.this,PlaneDetailActivity.class);
                startActivity(intent);
                break;

            case R.id.imgMenu:
                binding.Drawer.openDrawer(GravityCompat.START);
                break;
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itContactUs:
                startActivity(new Intent(MainActivity.this,ContactUsActivity.class));
                binding.Drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.itPersonalMonth:
                startActivity(new Intent(MainActivity.this,PersonalMonthActivity.class));
                binding.Drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.itMatchMaker:
                startActivity(new Intent(MainActivity.this,MatchMakerInputActivity.class));
                binding.Drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.itPlanList:
                startActivity(new Intent(MainActivity.this,PlanListActivity.class));
                binding.Drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.itHome:
                startActivity(new Intent(MainActivity.this,MyReportActivity.class));
                binding.Drawer.closeDrawer(GravityCompat.START);
               break;

            case R.id.itTermCondition:
                startActivity(new Intent(MainActivity.this,TermAndConditionActivity.class));
                binding.Drawer.closeDrawer(GravityCompat.START);
                break;
        }
        return true;
    }


    @Override
    public void onGetNumberSuccess(GetNumberResBean item) {
        if(item.isStatus()){
            new SharedPreferenceData(this).SavedGetNumberData(item);
            Log.e("Successss","Successss");
            Intent i = new Intent(MainActivity.this,LoshoGridActivity.class);
            i.putExtra("tabelData", item.getData());
            i.putExtra("birth",strDateOfBirth);
            i.putExtra("apibirth",str);
            i.putExtra("name",binding.edtName.getText().toString().trim());
            i.putExtra("phone",binding.edtMobileNumber.getText().toString().trim());
            i.putExtra("gender",gender);
            i.putExtra("report_id",String.valueOf(item.getReportId()));
            startActivity(i);
        }else{
            Toast.makeText(this, item.isMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onBackPressed(){
//        if (binding.Drawer.isOpen()){
//            binding.Drawer.closeDrawer(GravityCompat.START);
//        }
//        else {
            if (doubleBackToExitPressedOnce) {

                new AlertDialog.Builder(this)
                        .setIcon(R.drawable.img_numerology)
                        .setTitle("exit")
                        .setCancelable(false)
                        .setMessage("Are you sure want to exit")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ProfileData.Logout();
                                finishAffinity();
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }

            this.doubleBackToExitPressedOnce = true;
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
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


}
