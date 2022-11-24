package com.numeroscop.ApiCall.Presenter;

import android.app.Activity;
import android.widget.Toast;

import com.numeroscop.ApiCall.Model.OtpResBean;
import com.numeroscop.ApiCall.View.IOtpView;
import com.numeroscop.R;
import com.numeroscop.TopperApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpPresenter extends BasePresenter<IOtpView>{

    public void OtpCall (final Activity context ,String otp,String mobile){

        getView().enableLoadingBar(context,true,context.getString(R.string.loading));

        TopperApp.getInstance().getApiService().Otp(otp,mobile).enqueue(new Callback<OtpResBean>() {
            @Override
            public void onResponse(Call<OtpResBean> call, Response<OtpResBean> response) {
                getView().enableLoadingBar(context , false ,"");
                try {
                    if (!handleError(response, context)) {
                        if (response.isSuccessful() && response.code() == 200){
                            assert response.body() != null;
                            getView().onOtpSuccess(response.body());

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
            public void onFailure(Call<OtpResBean> call, Throwable t) {

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
