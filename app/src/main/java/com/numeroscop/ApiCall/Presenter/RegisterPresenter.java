package com.numeroscop.ApiCall.Presenter;

import android.app.Activity;
import android.widget.Toast;

import com.numeroscop.ApiCall.Model.RegisterResBean;
import com.numeroscop.ApiCall.View.IRegisterView;
import com.numeroscop.R;
import com.numeroscop.TopperApp;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter extends BasePresenter<IRegisterView>{

    SpotsDialog mProgressDialog;

    public void RegisterCall(final Activity context ,String accessToken, String name,String mobile,String email){

        getView().enableLoadingBar(context,true,context.getString(R.string.loading));

        TopperApp.getInstance().getApiService().Register("Bearer "+accessToken, name,mobile,email).enqueue(new Callback<RegisterResBean>() {
            @Override
            public void onResponse(Call<RegisterResBean> call, Response<RegisterResBean> response) {
                getView().enableLoadingBar(context,false,"");
                try {
                    if (!handleError(response, context)) {
                        if (response.isSuccessful() && response.code() == 200){
                            assert response.body() != null;
                            getView().onRegisterSuccess(response.body());

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
            public void onFailure(Call<RegisterResBean> call, Throwable t) {
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
