package com.numeroscop.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.numeroscop.Adapter.MyReportAdapter;
import com.numeroscop.Adapter.PlanListAdapter;
import com.numeroscop.ApiCall.Model.MyReportResBean;
import com.numeroscop.ApiCall.Model.PlanListResBean;
import com.numeroscop.ApiCall.Presenter.MyReportPresenter;
import com.numeroscop.ApiCall.View.IReportView;
import com.numeroscop.R;
import com.numeroscop.Utils.NetworkCheck;
import com.numeroscop.Utils.SharedPreferenceData;
import com.numeroscop.databinding.ActivityLoshoGridBinding;
import com.numeroscop.databinding.ActivityMyReportBinding;
import com.numeroscop.databinding.ActivityReportsBinding;

import java.util.ArrayList;

public class MyReportActivity extends BaseActivity implements IReportView, MyReportAdapter.ReportClickListner {

    ActivityMyReportBinding binding;
    SharedPreferenceData ProfileData;
    MyReportPresenter presenter;
    MyReportAdapter myReportAdapter;
    ArrayList<MyReportResBean.DataItem> reportList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding  = DataBindingUtil.setContentView(this, R.layout.activity_my_report);
        presenter = new MyReportPresenter();
        presenter.setView(this);

        ProfileData = new SharedPreferenceData(this);
        if (NetworkCheck.isConnected(this)) {
            presenter.MyreportListCall(this, ProfileData.getACCESS_TOKEN());
        }

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onReportClicked(int position) {
        Intent i = new Intent(MyReportActivity.this,GenerateReportActivity.class);
        i.putExtra("showbirth", reportList.get(position).getDobOrignal());
        i.putExtra("apibirth", reportList.get(position).getDob());
        i.putExtra("name", reportList.get(position).getName());
        i.putExtra("phone", reportList.get(position).getMobile());
        i.putExtra("gender", reportList.get(position).getGender());
        i.putExtra("report_id", ""+reportList.get(position).getId());
        startActivity(i);
    }

    @Override
    public void onMyReportSuccess(MyReportResBean item) {
        reportList.clear();
        if (item.isStatus()) {
            if (item.getData() != null) {
                reportList.addAll(item.getData());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); //
                binding.recyMyReport.setLayoutManager(linearLayoutManager);
                myReportAdapter = new MyReportAdapter(MyReportActivity.this, reportList,this);
                binding.recyMyReport.setAdapter(myReportAdapter);
            }
        } else {
            Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public Context getContext() {
        return this;
    }
}