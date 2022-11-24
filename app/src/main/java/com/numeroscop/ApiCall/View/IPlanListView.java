package com.numeroscop.ApiCall.View;


import com.numeroscop.ApiCall.Model.PlanListResBean;

public interface IPlanListView extends IUtopperView{
    void onGetPlanListSuccess(PlanListResBean item);
}