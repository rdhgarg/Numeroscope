package com.numeroscop.ApiCall.View;


import com.numeroscop.ApiCall.Model.SaveSolutionResBean;

public interface IGetSolutionView extends IUtopperView{
    void onGetSolutionSuccess(SaveSolutionResBean item);
}
