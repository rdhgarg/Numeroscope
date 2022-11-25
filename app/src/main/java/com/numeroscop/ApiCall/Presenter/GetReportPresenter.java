package com.numeroscop.ApiCall.Presenter;

import android.app.Activity;
import android.widget.Toast;
import com.numeroscop.ApiCall.Model.GetReportResBean;
import com.numeroscop.ApiCall.View.IGetReportView;
import com.numeroscop.R;
import com.numeroscop.TopperApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetReportPresenter extends BasePresenter<IGetReportView>{

    public void  GetReportCall (final Activity context, String accessToken, String name, String mobile, String dob, String gender
            ,String report_id, String isRefresh){
        getView().enableLoadingBar(context,true,context.getString(R.string.loading));

        TopperApp.getInstance().getApiService().GetReport("Bearer " +accessToken,name,mobile,dob,gender,report_id, isRefresh)
                .enqueue(new Callback<GetReportResBean>() {
                    @Override
                    public void onResponse(Call<GetReportResBean> call, Response<GetReportResBean> response) {
                        getView().enableLoadingBar(context,false,"");
                        try {
                            if (!handleError(response, context)) {
                                if (response.isSuccessful() && response.code() == 200){
                                    assert response.body() != null;
                                    getView().onGetReportSuccess(response.body());

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
                    public void onFailure(Call<GetReportResBean> call, Throwable t) {

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
