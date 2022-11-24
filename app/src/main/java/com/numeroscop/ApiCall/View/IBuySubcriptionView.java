package com.numeroscop.ApiCall.View;

import com.numeroscop.ApiCall.Model.BuySubcriptionResBean;


public interface IBuySubcriptionView extends IUtopperView{
    void onBuySubscriptionSuccess(BuySubcriptionResBean item);
}