package com.numeroscop.Activity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.numeroscop.Adapter.GridCompatibilityAdapter;
import com.numeroscop.Adapter.TotalCompatibilityAdapter;
import com.numeroscop.ApiCall.Model.MarriageDetailsResBean;

import com.numeroscop.ApiCall.Presenter.MarriageDetailsPresenter;
import com.numeroscop.ApiCall.View.IMarriageDetailsView;
import com.numeroscop.Model.NumberModel;
import com.numeroscop.R;
import com.numeroscop.Utils.NetworkCheck;
import com.numeroscop.Utils.SharedPreferenceData;
import com.numeroscop.databinding.ActivityMatchMakerResultBinding;

import java.util.ArrayList;
import java.util.List;

public class MatchMakerResultActivity extends BaseActivity implements IMarriageDetailsView, View.OnClickListener {
    ActivityMatchMakerResultBinding binding;
    SharedPreferenceData ProfileData;
    MarriageDetailsPresenter marriageDetailsPresenter;
    GridCompatibilityAdapter gridCompatibilityAdapter;
    TotalCompatibilityAdapter totalCompatibilityAdapter;
    ArrayList<NumberModel> list = new ArrayList<>();
    List<Integer> calMale = new ArrayList<>();
    List<Integer> calFeMale = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_match_maker_result);

        marriageDetailsPresenter = new MarriageDetailsPresenter();
        marriageDetailsPresenter.setView(this);
        init();

    }

    private void init(){

        binding.imgBack.setOnClickListener(this);
        Bundle extras = getIntent().getExtras();
        String male_dob = extras.getString("male_dob");
        String male_name = extras.getString("male_name");
        String female_name = extras.getString("female_name");
        String female_dob = extras.getString("female_dob");


        binding.textMName.setText(male_name);
        binding.textFName.setText(female_name);
        binding.textMale.setText(male_name);
        binding.textFemale.setText(female_name);


        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        ProfileData = new SharedPreferenceData(this);

        if(NetworkCheck.isConnected(this))
        {
            marriageDetailsPresenter.MarriageDetailsCall(this,ProfileData.getACCESS_TOKEN(),male_dob,
                    male_name,female_name,female_dob);
        }

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onMarriageDetailSuccess(MarriageDetailsResBean item) {

        if(item.getStatus()){
           setData(item);
        }else{
            Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    private void setData(MarriageDetailsResBean item){

        calMale.addAll(item.getMaleData().getCalculation());
        calFeMale.addAll(item.getFemaleData().getCalculation());
        binding.layout.setVisibility(View.VISIBLE);


        binding.textMDriver.setText(item.getMaleData().getDriver().toString());
        binding.textMConductor.setText(item.getMaleData().getConductor().toString());
        binding.textMKuaNum.setText(item.getMaleData().getKuwaNo().toString());

        binding.textFDriver.setText(item.getFemaleData().getDriver().toString());
        binding.textFConductor.setText(item.getFemaleData().getConductor().toString());
        binding.textFKuaNum.setText(item.getFemaleData().getKuwaNo().toString());


        binding.textDToDCompa.setText(item.getData().getDToD()+"%");
        binding.textCToCCompa.setText(item.getData().getCToC()+"%");
        binding.textKToKCompa.setText(item.getData().getKToK()+"%");
        binding.textKToKCompa.setText(item.getData().getKToK()+"%");
        binding.textTotalCompa.setText(item.getData().getTotalCompatibility()+"%");
        binding.textGridCompa.setText(item.getData().getMarrigeCompatibility()+"%");

      //  binding.layoutTable.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bottom_top));


        list.add(new NumberModel("4"));
        list.add(new NumberModel("9"));
        list.add(new NumberModel("2"));
        list.add(new NumberModel("3"));
        list.add(new NumberModel("5"));
        list.add(new NumberModel("7"));
        list.add(new NumberModel("8"));
        list.add(new NumberModel("1"));
        list.add(new NumberModel("6"));

        gridCompatibilityAdapter = new GridCompatibilityAdapter(list,calMale,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3, RecyclerView.VERTICAL,false);
        binding.rvGridMale.setLayoutManager(gridLayoutManager);
        binding.rvGridMale.setAdapter(gridCompatibilityAdapter);




        totalCompatibilityAdapter = new TotalCompatibilityAdapter(list, calFeMale,this);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(this,3, RecyclerView.VERTICAL,false);
        binding.rvGridFeMale.setLayoutManager(gridLayoutManager1);
        binding.rvGridFeMale.setAdapter(totalCompatibilityAdapter);

    }
}