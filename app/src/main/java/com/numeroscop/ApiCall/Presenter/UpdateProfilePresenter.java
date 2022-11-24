package com.numeroscop.ApiCall.Presenter;

import android.app.Activity;
import android.widget.Toast;


import com.numeroscop.ApiCall.Model.OtpResBean;

import com.numeroscop.ApiCall.View.IUpdateProfileView;
import com.numeroscop.R;
import com.numeroscop.TopperApp;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateProfilePresenter extends BasePresenter<IUpdateProfileView> {

        public void  GetUpdateProfileCall (Activity context, String accessToken, String name, String mobile_no , String email, String address, String business_name, String referal_code, MultipartBody.Part business_logo){
            getView().enableLoadingBar(context,true,context.getString(R.string.loading));

            RequestBody reqName = RequestBody.create(MediaType.parse("multipart/form-data"), name);
            RequestBody reqMobile = RequestBody.create(MediaType.parse("multipart/form-data"), mobile_no);
            RequestBody reqEmail = RequestBody.create(MediaType.parse("multipart/form-data"), email);
            RequestBody reqAddress = RequestBody.create(MediaType.parse("multipart/form-data"), address);
            RequestBody reqBusinessName = RequestBody.create(MediaType.parse("multipart/form-data"), business_name);
            RequestBody reqReferalCode = RequestBody.create(MediaType.parse("multipart/form-data"), referal_code);

            TopperApp.getInstance().getApiService().GetUpdateProfile("Bearer " +accessToken,reqName,reqMobile,reqEmail,reqAddress,reqBusinessName,reqReferalCode,business_logo)
                    .enqueue(new Callback<OtpResBean>() {
                        @Override
                        public void onResponse(Call<OtpResBean> call, Response<OtpResBean> response) {
                            getView().enableLoadingBar(context,false,"");
                            try {
                                if (!handleError(response, context)) {
                                    if (response.isSuccessful() && response.code() == 200){
                                        assert response.body() != null;
                                        getView().onUpdateProfileSuccess(response.body());

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
