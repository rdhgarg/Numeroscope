package com.numeroscop.ApiCall.Presenter;

import android.app.Activity;
import android.widget.Toast;

import com.numeroscop.ApiCall.Model.MarriageDetailsResBean;
import com.numeroscop.ApiCall.View.IMarriageDetailsView;
import com.numeroscop.R;
import com.numeroscop.TopperApp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarriageDetailsPresenter extends BasePresenter<IMarriageDetailsView>{

    public void MarriageDetailsCall(final Activity context, String accessToken, String male_dob, String male_name,String female_name,String female_dob){
        getView().enableLoadingBar(context,true,context.getString(R.string.loading));

        TopperApp.getInstance().getApiService().GetMarriageDetails("Bearer "+accessToken,male_dob,male_name,female_name,female_dob).enqueue(new Callback<MarriageDetailsResBean>() {
            @Override
            public void onResponse(Call<MarriageDetailsResBean> call, Response<MarriageDetailsResBean> response) {
                getView().enableLoadingBar(context , false ,"");
                try {
                    if (!handleError(response, context)) {
                        if (response.isSuccessful() && response.code() == 200){
                            assert response.body() != null;
                            getView().onMarriageDetailSuccess(response.body());

                        }else {
                            Toast.makeText(context, response.message(), Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        getView().onError(null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    getView().onError(e.getMessage());
                }

            }

            @Override
            public void onFailure(Call<MarriageDetailsResBean> call, Throwable t) {
                try {
                    getView().enableLoadingBar(context, false,"");
                    t.printStackTrace();
                    getView().onError(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
