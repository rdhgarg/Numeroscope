package com.numeroscop.ApiCall.Model;

import com.google.gson.annotations.SerializedName;

public class ProfileResBean {

    @SerializedName("status")
    private Boolean status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataDTO data;

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

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        @SerializedName("id")
        private Integer id;
        @SerializedName("name")
        private String name;
        @SerializedName("business_name")
        private String businessName;
        @SerializedName("address")
        private String address;
        @SerializedName("business_logo")
        private Object businessLogo;
        @SerializedName("email")
        private String email;
        @SerializedName("role_id")
        private Object roleId;
        @SerializedName("mobile_no")
        private String mobileNo;
        @SerializedName("email_verified_at")
        private Object emailVerifiedAt;
        @SerializedName("status")
        private Integer status;
        @SerializedName("created_by")
        private Integer createdBy;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("profile_image")
        private Object profileImage;
        @SerializedName("verify_otp_status")
        private String verifyOtpStatus;
        @SerializedName("register_otp")
        private String registerOtp;
        @SerializedName("device_token")
        private Object deviceToken;
        @SerializedName("device_key")
        private Object deviceKey;
        @SerializedName("referal_code")
        private String referalCode;
        @SerializedName("refer_code")
        private Object referCode;
        @SerializedName("otp")
        private Object otp;
        @SerializedName("end_date")
        private String endDate;
        @SerializedName("no_of_reports")
        private String noOfReports;
        @SerializedName("wallet_amt")
        private Object walletAmt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Object getBusinessLogo() {
            return businessLogo;
        }

        public void setBusinessLogo(Object businessLogo) {
            this.businessLogo = businessLogo;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getRoleId() {
            return roleId;
        }

        public void setRoleId(Object roleId) {
            this.roleId = roleId;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public Object getEmailVerifiedAt() {
            return emailVerifiedAt;
        }

        public void setEmailVerifiedAt(Object emailVerifiedAt) {
            this.emailVerifiedAt = emailVerifiedAt;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Integer createdBy) {
            this.createdBy = createdBy;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Object getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(Object profileImage) {
            this.profileImage = profileImage;
        }

        public String getVerifyOtpStatus() {
            return verifyOtpStatus;
        }

        public void setVerifyOtpStatus(String verifyOtpStatus) {
            this.verifyOtpStatus = verifyOtpStatus;
        }

        public String getRegisterOtp() {
            return registerOtp;
        }

        public void setRegisterOtp(String registerOtp) {
            this.registerOtp = registerOtp;
        }

        public Object getDeviceToken() {
            return deviceToken;
        }

        public void setDeviceToken(Object deviceToken) {
            this.deviceToken = deviceToken;
        }

        public Object getDeviceKey() {
            return deviceKey;
        }

        public void setDeviceKey(Object deviceKey) {
            this.deviceKey = deviceKey;
        }

        public String getReferalCode() {
            return referalCode;
        }

        public void setReferalCode(String referalCode) {
            this.referalCode = referalCode;
        }

        public Object getReferCode() {
            return referCode;
        }

        public void setReferCode(Object referCode) {
            this.referCode = referCode;
        }

        public Object getOtp() {
            return otp;
        }

        public void setOtp(Object otp) {
            this.otp = otp;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getNoOfReports() {
            return noOfReports;
        }

        public void setNoOfReports(String noOfReports) {
            this.noOfReports = noOfReports;
        }

        public Object getWalletAmt() {
            return walletAmt;
        }

        public void setWalletAmt(Object walletAmt) {
            this.walletAmt = walletAmt;
        }
    }
}
