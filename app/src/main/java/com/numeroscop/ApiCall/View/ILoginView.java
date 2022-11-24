package com.numeroscop.ApiCall.View;

import com.numeroscop.ApiCall.Model.LoginResBean;

public interface ILoginView extends IUtopperView{
    void onLoginSuccess(LoginResBean item);
}
