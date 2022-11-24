package com.numeroscop.ApiCall.View;

import com.numeroscop.ApiCall.Model.GetNumberResBean;

public interface IGetNumberView extends IUtopperView{
    void onGetNumberSuccess(GetNumberResBean item);
}
