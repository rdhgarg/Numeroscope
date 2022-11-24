package com.numeroscop.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.google.android.material.snackbar.Snackbar;
import com.numeroscop.Adapter.PlanListAdapter;
import com.numeroscop.ApiCall.Model.BuySubcriptionResBean;
import com.numeroscop.ApiCall.Model.PlanListResBean;

import com.numeroscop.ApiCall.Presenter.BuySubscrptionPresenter;
import com.numeroscop.ApiCall.Presenter.PlanListPresenter;
import com.numeroscop.ApiCall.View.IBuySubcriptionView;
import com.numeroscop.ApiCall.View.IPlanListView;
import com.numeroscop.R;
import com.numeroscop.Utils.NetworkCheck;
import com.numeroscop.Utils.SharedPreferenceData;

import com.numeroscop.databinding.ActivityPlanListBinding;
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONObject;

import java.util.ArrayList;


public class PlanListActivity extends BaseActivity implements IPlanListView, IBuySubcriptionView, View.OnClickListener
        , PlanListAdapter.ItemClickListner, PaymentResultWithDataListener {
    ActivityPlanListBinding binding;
    PlanListAdapter planListAdapter;
    ArrayList<PlanListResBean.DataDTO> planeArrayList = new ArrayList<>();
    PlanListPresenter planListPresenter;
    BuySubscrptionPresenter buySubscrptionPresenter;
    SharedPreferenceData ProfileData;
    String planId = "";
    public int REQCODE = 198;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_plan_list);
        planListPresenter = new PlanListPresenter();
        buySubscrptionPresenter = new BuySubscrptionPresenter();
        planListPresenter.setView(this);
        buySubscrptionPresenter.setView(this);

        init();

        ProfileData = new SharedPreferenceData(this);
        if (NetworkCheck.isConnected(this)) {
            planListPresenter.PlanListCall(this, ProfileData.getACCESS_TOKEN());
        }
    }


    private void init() {
        binding.imgBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (binding.imgBack == view) {
            Intent intent = getIntent();
//            intent.putExtra("key", value);
            setResult(REQCODE, intent);

            finish();
        }
    }

    @Override
    public void onGetPlanListSuccess(PlanListResBean item) {

        planeArrayList.clear();
        if (item.getStatus()) {
            if (item.getData() != null) {
                planeArrayList.addAll(item.getData());
                LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getApplicationContext());
                linearLayoutManager3.setOrientation(LinearLayoutManager.VERTICAL); //
                binding.recycleView.setLayoutManager(linearLayoutManager3);
                //  call the constructor of CustomAdapter to send the reference and data to Adapter
                planListAdapter = new PlanListAdapter(PlanListActivity.this, planeArrayList,this);
                binding.recycleView.setAdapter(planListAdapter); //
                // set the Adapter to RecyclerView
                planListAdapter.notifyDataSetChanged();
            }


        } else {
            Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public Context getContext() {
        return this;
    }




    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
           Snackbar snackbar = Snackbar.make(
                binding.consRoot,
                "Payment Successful: " + paymentData.getPaymentId(),
                Snackbar.LENGTH_LONG
        );
        snackbar.show();

        Log.e("PAYMENTID==>>",paymentData.getPaymentId());


        if (NetworkCheck.isConnected(this)) {
            buySubscrptionPresenter.BuySubscriptionCall(this, ProfileData.getACCESS_TOKEN(),planId,paymentData.getPaymentId());
        }

    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {

    }

    @Override
    public void onItemClicked(int poisition) {
        planId = planeArrayList.get(poisition).getId().toString();
        RAZORPAY(planeArrayList.get(poisition).getAmount());
    }


    private void RAZORPAY(String price) {
        Double finalPay = Double.parseDouble(price) * 100;
        Checkout co = new Checkout();
        String stamount = finalPay.toString();
        try {
            JSONObject options = new JSONObject();
            options.put("name",ProfileData.getUser_name());
            options.put("description", getString(R.string.app_name));
            options.put("currency", "INR");
            options.put("amount", stamount);
            JSONObject preFill = new JSONObject();
            preFill.put("email", ProfileData.getEmail());
            preFill.put("contact", ProfileData.getMobile_no());
            options.put("prefill", preFill);
            co.setKeyID("rzp_live_5IbwMT80SFxScI");
            co.setImage(R.drawable.img_numerology);
            co.open(this, options);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBuySubscriptionSuccess(BuySubcriptionResBean item) {
        REQCODE = 199;
        if(item.getStatus()){
            if (NetworkCheck.isConnected(this)) {
                planListPresenter.PlanListCall(this, ProfileData.getACCESS_TOKEN());
            }
        }else {
            Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onBackPressed() {
        Intent intent = getIntent();
        setResult(REQCODE, intent);
        finish();
        super.onBackPressed();
    }
}

