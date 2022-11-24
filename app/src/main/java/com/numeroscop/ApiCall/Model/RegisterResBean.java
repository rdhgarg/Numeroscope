package com.numeroscop.ApiCall.Model;

import com.google.gson.annotations.SerializedName;

public class RegisterResBean {

	@SerializedName("verify_otp_status")
	private String verifyOtpStatus;

	@SerializedName("mobile")
	private String mobile;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public String getVerifyOtpStatus(){
		return verifyOtpStatus;
	}

	public String getMobile(){
		return mobile;
	}

	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}
}