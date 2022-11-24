package com.numeroscop.ApiCall.View;

import android.content.Context;

public interface IUtopperView {

    Context getContext();
    void enableLoadingBar(Context context, boolean enable, String string);
    void onError(String reason);
}
