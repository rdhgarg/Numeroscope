package com.numeroscop.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.numeroscop.Adapter.BraceletAdapter;
import com.numeroscop.Adapter.NumberAdapter;
import com.numeroscop.Adapter.YantraAdapter;
import com.numeroscop.ApiCall.Model.SaveSolutionResBean;
import com.numeroscop.ApiCall.Model.YantraBraceletResBean;
import com.numeroscop.ApiCall.Presenter.YantraBraceletPresenter;
import com.numeroscop.ApiCall.View.IYantraBraceletView;
import com.numeroscop.R;
import com.numeroscop.Utils.NetworkCheck;
import com.numeroscop.Utils.SharedPreferenceData;
import com.numeroscop.databinding.ActivityYantrabraceletBinding;

import java.util.ArrayList;
import java.util.List;

public class YantraBraceletActivity extends BaseActivity implements YantraAdapter.ItemClickListner, BraceletAdapter.ItemClickListner
        , IYantraBraceletView {

    ActivityYantrabraceletBinding binding;
    YantraAdapter yantraAdapter;
    BraceletAdapter braceletAdapter;
    List<YantraBraceletResBean.Data.YantraItem> yantraList = new ArrayList<>();
    List<YantraBraceletResBean.Data.BraceletItem> braceletList = new ArrayList<>();
    YantraBraceletPresenter presenter;
    SharedPreferenceData userData;
    String strReportID, strPdf;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_yantrabracelet);
        presenter = new YantraBraceletPresenter();
        presenter.setView(this);
        userData = new SharedPreferenceData(this);
        strReportID = getIntent().getStringExtra("reportId");
        strPdf = getIntent().getStringExtra("pdfLink");

        yantraAdapter = new YantraAdapter(this, yantraList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2, RecyclerView.VERTICAL,false);
        binding.recyYantra.setLayoutManager(gridLayoutManager);
        binding.recyYantra.setAdapter(yantraAdapter);

        braceletAdapter = new BraceletAdapter(this, braceletList, this);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(this,2, RecyclerView.VERTICAL,false);
        binding.recyBracelet.setLayoutManager(gridLayoutManager1);
        binding.recyBracelet.setAdapter(braceletAdapter);

        presenter.YantraBraceletCall(this, userData.getACCESS_TOKEN());
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.cardSubmit:
                String Strsolution = binding.editSolution.getText().toString().trim();
                ArrayList<String> yantraIdList = new ArrayList<>();
                ArrayList<String> braceletIdList = new ArrayList<>();
                for (int i=0; i<yantraList.size(); i++){
                    if (yantraList.get(i).getIsSelected()){
                        yantraIdList.add(""+yantraList.get(i).getId());
                    }
                }
                for (int i=0; i<braceletList.size(); i++){
                    if (braceletList.get(i).getIsSelected()){
                        braceletIdList.add(""+braceletList.get(i).getId());
                    }
                }

                if(TextUtils.isEmpty(Strsolution)){
                    Toast.makeText(YantraBraceletActivity.this, "PLease Fill Solution", Toast.LENGTH_SHORT).show();
                }else {
                    if(NetworkCheck.isConnected(getContext())) {
                        presenter.SaveSolutionCall(YantraBraceletActivity.this, strReportID, Strsolution, yantraIdList, braceletIdList, userData.getACCESS_TOKEN());
                    }
                }
            break;
            case R.id.txtSkip:
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(strPdf));
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void onYantraClicked(int poisition) {
        if (yantraList.get(poisition).getIsSelected()){
            yantraList.get(poisition).setSelected(false);
        }else {
            yantraList.get(poisition).setSelected(true);
        }
        yantraAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBraceletClicked(int poisition) {
        if (braceletList.get(poisition).getIsSelected()){
            braceletList.get(poisition).setSelected(false);
        }else {
            braceletList.get(poisition).setSelected(true);
        }
        braceletAdapter.notifyDataSetChanged();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void OnYantraBraceletSuccess(YantraBraceletResBean item) {
        if(item.isStatus()){
            yantraList.addAll(item.getData().getYantra());
            braceletList.addAll(item.getData().getBracelet());

            yantraAdapter.notifyDataSetChanged();
            braceletAdapter.notifyDataSetChanged();

            if (yantraList.size()==0){
                binding.txtYantra.setVisibility(View.GONE);
            }
            if (braceletList.size()==0){
                binding.txtBracelet.setVisibility(View.GONE);
            }
        }else {
            binding.txtNoProduct.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onGetSolutionSuccess(SaveSolutionResBean item) {
        if(item.getStatus()){
            Intent returnIntent = new Intent();
            returnIntent.putExtra("result","");
            setResult(Activity.RESULT_OK,returnIntent);
            finish();
        }else{
            Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
