package com.numeroscop.ApiCall.Model;

import com.google.gson.annotations.SerializedName;

public class BuySubcriptionResBean {

    @SerializedName("status")
    private Boolean status;
    @SerializedName("message")
    private String message;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
