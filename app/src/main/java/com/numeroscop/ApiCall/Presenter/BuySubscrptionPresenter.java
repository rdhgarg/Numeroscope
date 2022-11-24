package com.numeroscop.ApiCall.Presenter;
import android.app.Activity;
import android.widget.Toast;
import com.numeroscop.ApiCall.Model.BuySubcriptionResBean;
import com.numeroscop.ApiCall.View.IBuySubcriptionView;
import com.numeroscop.R;
import com.numeroscop.TopperApp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuySubscrptionPresenter extends BasePresenter<IBuySubcriptionView>{

    public void BuySubscriptionCall(final Activity context, String accessToken, String plan_id, String transaction_id){
        getView().enableLoadingBar(context,true,context.getString(R.string.loading));

        TopperApp.getInstance().getApiService().GetBuySubcriptionList("Bearer "+accessToken,plan_id,transaction_id).enqueue(new Callback<BuySubcriptionResBean>() {
            @Override
            public void onResponse(Call<BuySubcriptionResBean> call, Response<BuySubcriptionResBean> response) {
                getView().enableLoadingBar(context , false ,"");
                try {
                    if (!handleError(response, context)) {
                        if (response.isSuccessful() && response.code() == 200){
                            assert response.body() != null;
                            getView().onBuySubscriptionSuccess(response.body());

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
            public void onFailure(Call<BuySubcriptionResBean> call, Throwable t) {
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
