package com.numeroscop.ApiCall.View;

import com.numeroscop.ApiCall.Model.OtpResBean;

public interface IOtpView extends IUtopperView {
    void onOtpSuccess(OtpResBean item);
}
