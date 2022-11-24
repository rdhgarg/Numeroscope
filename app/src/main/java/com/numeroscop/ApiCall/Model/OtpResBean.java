package com.numeroscop.ApiCall.Model;

import com.google.gson.annotations.SerializedName;

public class OtpResBean {

	@SerializedName("access_token")
	private String accessToken;

	@SerializedName("data")
	private Data data;

	@SerializedName("token_type")
	private String tokenType;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public String getAccessToken(){
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Data getData(){
		return data;
	}

	public String getTokenType(){
		return tokenType;
	}

	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}

	public class Data{

		@SerializedName("device_key")
		private Object deviceKey;

		@SerializedName("verify_otp_status")
		private String verifyOtpStatus;

		@SerializedName("mobile_no")
		private String mobileNo;

		@SerializedName("created_at")
		private String createdAt;

		@SerializedName("email_verified_at")
		private Object emailVerifiedAt;

		@SerializedName("otp")
		private Object otp;

		@SerializedName("created_by")
		private String createdBy;

		@SerializedName("profile_image")
		private Object profileImage;

		@SerializedName("updated_at")
		private String updatedAt;

		@SerializedName("register_otp")
		private String registerOtp;

		@SerializedName("role_id")
		private Object roleId;

		@SerializedName("device_token")
		private Object deviceToken;

		@SerializedName("name")
		private String name;

		@SerializedName("address")
		private String address;

		@SerializedName("business_logo")
		private String business_logo;

		public String getBusiness_logo() {
			return business_logo;
		}



		@SerializedName("business_name")
		private String businessName;


		@SerializedName("referal_code")
		private String referalCode;

		@SerializedName("wallet_amt")
		private Object walletAmt;

		@SerializedName("id")
		private int id;

		@SerializedName("email")
		private String email;

		@SerializedName("status")
		private String status;

		public Object getDeviceKey(){
			return deviceKey;
		}

		public String getVerifyOtpStatus(){
			return verifyOtpStatus;
		}

		public String getMobileNo(){
			return mobileNo;
		}

		public String getCreatedAt(){
			return createdAt;
		}

		public Object getEmailVerifiedAt(){
			return emailVerifiedAt;
		}

		public Object getOtp(){
			return otp;
		}

		public String getCreatedBy(){
			return createdBy;
		}

		public Object getProfileImage(){
			return profileImage;
		}

		public String getUpdatedAt(){
			return updatedAt;
		}

		public String getRegisterOtp(){
			return registerOtp;
		}

		public Object getRoleId(){
			return roleId;
		}

		public Object getDeviceToken(){
			return deviceToken;
		}

		public String getName(){
			return name;
		}

		public String getAddress() {
			return address;
		}

		public String getBusinessName() {
			return businessName;
		}

		public String getReferalCode() {
			return referalCode;
		}

		public Object getWalletAmt(){
			return walletAmt;
		}

		public int getId(){
			return id;
		}

		public String getEmail(){
			return email;
		}

		public String getStatus(){
			return status;
		}
	}
}