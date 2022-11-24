package com.numeroscop.ApiCall.Presenter;

import android.app.Activity;
import android.widget.Toast;


import com.numeroscop.ApiCall.Model.PlanListResBean;

import com.numeroscop.ApiCall.View.IPlanListView;
import com.numeroscop.R;
import com.numeroscop.TopperApp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PlanListPresenter extends BasePresenter<IPlanListView>{
    public void PlanListCall(final Activity context, String accessToken){
        getView().enableLoadingBar(context,true,context.getString(R.string.loading));

        TopperApp.getInstance().getApiService().GetPlanList("Bearer "+accessToken).enqueue(new Callback<PlanListResBean>() {
            @Override
            public void onResponse(Call<PlanListResBean> call, Response<PlanListResBean> response) {
                getView().enableLoadingBar(context,false ,"");
                try {
                    if (!handleError(response, context)) {
                        if (response.isSuccessful() && response.code() == 200){
                            assert response.body() != null;
                            getView().onGetPlanListSuccess(response.body());

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
            public void onFailure(Call<PlanListResBean> call, Throwable t) {
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
