package com.numeroscop.ApiCall.Presenter;

import android.app.Activity;
import android.widget.Toast;

import com.numeroscop.ApiCall.Model.LoginResBean;
import com.numeroscop.ApiCall.View.ILoginView;
import com.numeroscop.R;
import com.numeroscop.TopperApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter extends BasePresenter<ILoginView>{

    public void LoginCall(final Activity context,String accessToken,String mobile){
        getView().enableLoadingBar(context,true,context.getString(R.string.loading));

        TopperApp.getInstance().getApiService().Login("Bearer "+accessToken,mobile).enqueue(new Callback<LoginResBean>() {
            @Override
            public void onResponse(Call<LoginResBean> call, Response<LoginResBean> response) {
                getView().enableLoadingBar(context,false,"");

                try {
                    if (!handleError(response, context)) {
                        if (response.isSuccessful() && response.code() == 200){
                            assert response.body() != null;
                            getView().onLoginSuccess(response.body());

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
            public void onFailure(Call<LoginResBean> call, Throwable t) {

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
