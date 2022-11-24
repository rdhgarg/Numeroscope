package com.numeroscop.ApiCall.Presenter;

import android.app.Activity;
import android.widget.Toast;


import com.numeroscop.ApiCall.Model.SaveSolutionResBean;
import com.numeroscop.ApiCall.View.IGetSolutionView;
import com.numeroscop.R;
import com.numeroscop.TopperApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SolutionPresenPresenter extends BasePresenter<IGetSolutionView>{

    public void  SaveSolutionCall (final Activity context, String accessToken, String solution, String report_id){
        getView().enableLoadingBar(context,true,context.getString(R.string.loading));

        TopperApp.getInstance().getApiService().SaveSolution("Bearer " +accessToken,solution,report_id)
                .enqueue(new Callback<SaveSolutionResBean>() {
                    @Override
                    public void onResponse(Call<SaveSolutionResBean> call, Response<SaveSolutionResBean> response) {
                        getView().enableLoadingBar(context,false,"");
                        try {
                            if (!handleError(response, context)) {
                                if (response.isSuccessful() && response.code() == 200){
                                    assert response.body() != null;
                                    getView().onGetSolutionSuccess(response.body());

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
                    public void onFailure(Call<SaveSolutionResBean> call, Throwable t) {

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
