package com.numeroscop.ApiCall.Model;

import com.google.gson.annotations.SerializedName;

public class SaveSolutionResBean {


    @SerializedName("status")
    private Boolean status;
    @SerializedName("data")
    private String data;
    @SerializedName("message")
    private String message;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
