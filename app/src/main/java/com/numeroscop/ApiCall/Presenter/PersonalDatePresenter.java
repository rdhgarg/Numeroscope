package com.numeroscop.ApiCall.Presenter;

import android.app.Activity;
import android.widget.Toast;

import com.numeroscop.ApiCall.Model.PersonalDateResBean;
import com.numeroscop.ApiCall.View.IPersonalDateView;
import com.numeroscop.R;
import com.numeroscop.TopperApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonalDatePresenter extends BasePresenter<IPersonalDateView>{

    public void PersonalDateCall(final Activity context,String accessToken,String dob,String desired_date){
        getView().enableLoadingBar(context,true,context.getString(R.string.loading));

        TopperApp.getInstance().getApiService().GetPersonalDate("Bearer "+accessToken,dob,desired_date).enqueue(new Callback<PersonalDateResBean>() {
            @Override
            public void onResponse(Call<PersonalDateResBean> call, Response<PersonalDateResBean> response) {
                getView().enableLoadingBar(context , false ,"");
                try {
                    if (!handleError(response, context)) {
                        if (response.isSuccessful() && response.code() == 200){
                            assert response.body() != null;
                            getView().onPersonalDateSucess(response.body());

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
            public void onFailure(Call<PersonalDateResBean> call, Throwable t) {

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
