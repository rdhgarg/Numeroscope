package com.numeroscop.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.numeroscop.Adapter.NumberAdapter;
import com.numeroscop.ApiCall.Model.GetNumberResBean;
import com.numeroscop.Model.NumberModel;
import com.numeroscop.R;
import com.numeroscop.Utils.SharedPreferenceData;
import com.numeroscop.databinding.ActivityLoshoGridBinding;

import java.util.ArrayList;

public class LoshoGridActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActivityLoshoGridBinding binding;
    NumberAdapter numberAdapter;
    ArrayList<NumberModel>list = new ArrayList<>();
    SharedPreferenceData ProfileData;
    GetNumberResBean.Data numberResBean;
    String strBirth ="",strName = "", strphone ="",strGender = "",strReportID ="";
    TextView txtUserName,txtNumber,txtEmailId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_losho_grid);
        numberResBean = (GetNumberResBean.Data)getIntent().getSerializableExtra("tabelData");


        NavigationView navigationView = (NavigationView) findViewById(R.id.NavMenu);
        View header = navigationView.getHeaderView(0);
        txtUserName = (TextView) header.findViewById(R.id.txtUserName);
        txtNumber = (TextView) header.findViewById(R.id.txtNumber);
        txtEmailId = (TextView) header.findViewById(R.id.txtEmailId);
        ImageView imgEdit = (ImageView) header.findViewById(R.id.imgEdit);

        binding.Drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.Drawer.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(LoshoGridActivity.this,EditProfileActivity.class);
                startActivity(intent);
            }
        });

        Bundle extras = getIntent().getExtras();
        String  BirthString = extras.getString("birth");

        strBirth = extras.getString("apibirth");
        strName = extras.getString("name");
        strphone  = extras.getString("phone");
        strGender = extras.getString("gender");
        strReportID = extras.getString("report_id");

        binding.txtDateOfBirth.setText(BirthString);
        ProfileData = new SharedPreferenceData(this);

        Log.e("NAMEEEE>>>",ProfileData.getUser_name());

        binding.textName.setText("Name : "+strName);


        setHeaderData();

        binding.txtNumberLucky.setText(ProfileData.getLUCKYNUMBER());
        binding.txtNumberKuwo.setText(ProfileData.getKUWANUMBER());


        String strMissing   = ProfileData.getMISSINGNUMBER().replace("[", "").replace("]","");
        binding.txtNumberMissing.setText(strMissing);


        String strPresenter   = ProfileData.getPRESENTNUMBER().replace("[", "").replace("]","");

        binding.txtNumberPresent.setText(strPresenter);
        binding.txtDriverNumber.setText(ProfileData.getDRIVER());
        binding.txtConductorNumber.setText(ProfileData.getCONDUCTOR());
        binding.txtNumberName.setText(ProfileData.getNAMENUMBER());


        list.add(new NumberModel("4"));
        list.add(new NumberModel("9"));
        list.add(new NumberModel("2"));
        list.add(new NumberModel("3"));
        list.add(new NumberModel("5"));
        list.add(new NumberModel("7"));
        list.add(new NumberModel("8"));
        list.add(new NumberModel("1"));
        list.add(new NumberModel("6"));

        numberAdapter = new NumberAdapter(list, numberResBean,ProfileData.getDRIVER(),ProfileData.getCONDUCTOR(),ProfileData.getKUWANUMBER(), this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3, RecyclerView.VERTICAL,false);
        binding.rvNumber.setLayoutManager(gridLayoutManager);
        binding.rvNumber.setAdapter(numberAdapter);


        binding.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        binding.cvGenerateReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoshoGridActivity.this,GenerateReportActivity.class);
                i.putExtra("tabelData",numberResBean);
                i.putExtra("showbirth",BirthString);
                i.putExtra("apibirth",strBirth);
                i.putExtra("name",strName);
                i.putExtra("phone",strphone);
                i.putExtra("gender",strGender);
                i.putExtra("report_id",strReportID);
                startActivity(i);
            }
        });


        binding.NavMenu.setNavigationItemSelectedListener(this);


        binding.imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setHeaderData();
                binding.Drawer.openDrawer(GravityCompat.START);
            }
        });

        binding.textLogut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.Drawer.closeDrawer(GravityCompat.START);
                ProfileData.Logout();
                Intent intent = new Intent(LoshoGridActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ActivityCompat.finishAffinity(LoshoGridActivity.this);
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itContactUs:
                startActivity(new Intent(LoshoGridActivity.this,ContactUsActivity.class));
                binding.Drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.itPersonalMonth:
                startActivity(new Intent(LoshoGridActivity.this,PersonalMonthActivity.class));
                binding.Drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.itMatchMaker:
                startActivity(new Intent(LoshoGridActivity.this,MatchMakerInputActivity.class));
                binding.Drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.itPlanList:
                startActivity(new Intent(LoshoGridActivity.this,PlanListActivity.class));
                binding.Drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.itHome:
                startActivity(new Intent(LoshoGridActivity.this,MyReportActivity.class));
                binding.Drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.itTermCondition:
                startActivity(new Intent(LoshoGridActivity.this,TermAndConditionActivity.class));
                binding.Drawer.closeDrawer(GravityCompat.START);
                break;
        }
        return true;
    }
}