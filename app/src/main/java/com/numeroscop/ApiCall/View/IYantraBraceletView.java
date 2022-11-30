package com.numeroscop.ApiCall.View;

import com.numeroscop.ApiCall.Model.SaveSolutionResBean;
import com.numeroscop.ApiCall.Model.YantraBraceletResBean;

public interface IYantraBraceletView extends IUtopperView{
    void OnYantraBraceletSuccess(YantraBraceletResBean item);
    void onGetSolutionSuccess(SaveSolutionResBean item);
}
