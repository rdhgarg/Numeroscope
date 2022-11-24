package com.numeroscop.ApiCall.Presenter;

import android.app.Activity;
import android.widget.Toast;

import com.numeroscop.ApiCall.Model.GetNumberResBean;
import com.numeroscop.ApiCall.View.IGetNumberView;
import com.numeroscop.R;
import com.numeroscop.TopperApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetNumberPresenter extends BasePresenter<IGetNumberView>{

    public void  GetNumberCall (final Activity context,String accessToken,String name,String mobile,String dob,String gender){
        getView().enableLoadingBar(context,true,context.getString(R.string.loading));

        TopperApp.getInstance().getApiService().GetNUmber("Bearer " +accessToken,name,mobile,dob,gender)
                .enqueue(new Callback<GetNumberResBean>() {
                    @Override
                    public void onResponse(Call<GetNumberResBean> call, Response<GetNumberResBean> response) {
                        getView().enableLoadingBar(context,false,"");
                        try {
                            if (!handleError(response, context)) {
                                if (response.isSuccessful() && response.code() == 200){
                                    assert response.body() != null;
                                    getView().onGetNumberSuccess(response.body());

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
                    public void onFailure(Call<GetNumberResBean> call, Throwable t) {

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
