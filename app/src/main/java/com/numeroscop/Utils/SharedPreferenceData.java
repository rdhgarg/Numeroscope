package com.numeroscop.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.numeroscop.ApiCall.Model.GetNumberResBean;
import com.numeroscop.ApiCall.Model.OtpResBean;

public class SharedPreferenceData {
    SharedPreferences sharedPreferences, sharedPreferences1;
    Context context;
    private String MyLoginPREFERENCES = "MyLoginPrefs" ;
    private String SELECTED_DEPARTMENT_PREFERENCES = "SelectedDepartmentPrefs" ;
    private String DELIVERY_ADDRESS_PREFERENCES = "DeliveryAddressPrefs" ;
    private String USER_ID = "user_id" ;
    private String NAME = "name" ;
    private String PASSWORD = "password" ;
    private String FATHER_NAME = "father_name" ;
    private String MOBILE_NO = "mobile_no" ;
    private String ADDRESS = "address" ;
    private String BUSINESS_NAME = "business_name" ;
    private String REFERAL_CODE = "referal_code" ;
    private String BUSINESS_LOGO = "business_logo" ;
    private String EMAIL = "email" ;
    private String ACCESS_TOKEN = "access_token";
    private String REGISTRATION_NO = "registration_no" ;
    private String PROFILE_IMAGE = "profile_image" ;
    private String SELECTED_DEPART_ID = "selected_depart";
    private String DEFAULT_ADDRESS = "default_address";
    private String PINCODE = "pincode";
    private String SECTION_TYPE = "section_type";
    private String IS_FIRST_TIME = "is_first_time";
    private String DAY = "day";
    private String MONTH = "month";
    private String YEAR = "year";
    private String DRIVER = "driver";
    private String CONDUCTOR = "conductor";
    private String LUCKYNUMBER = "luckynumber";
    private String KUWANUMBER = "kuwanumber";
    private String MISSINGNUMBER = "missingnumber";
    private String PRESENTNUMBER = "presentnumber";
    private String NAMENUMBER = "namenumber";
    private String CALCULATION = "calculation";



    public SharedPreferenceData(Context context){
        this.context = context;
    }


  public void SavedLoginData(OtpResBean otpResBean){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        OtpResBean.Data data = otpResBean.getData();
        editor.putString(USER_ID,""+data.getId());
        editor.putString(NAME, data.getName());
        editor.putString(ACCESS_TOKEN,otpResBean.getAccessToken());
        editor.putString(EMAIL,data.getEmail());
        editor.putString(MOBILE_NO,data.getMobileNo());
        editor.putString(ADDRESS,data.getAddress());
        editor.putString(BUSINESS_NAME,data.getBusinessName());
        editor.putString(REFERAL_CODE,data.getReferalCode());
        editor.putString(BUSINESS_LOGO,data.getBusiness_logo());
        editor.commit();
    }

    public void SavedGetNumberData(GetNumberResBean getNumberResBean){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        GetNumberResBean.Data data = getNumberResBean.getData();
        editor.putString(DRIVER,""+data.getDriver());
        editor.putString(CONDUCTOR,""+data.getConductor());
        editor.putString(LUCKYNUMBER,""+data.getLuckyNo());
        editor.putString(KUWANUMBER,""+data.getKuwaNo());
        editor.putString(PRESENTNUMBER,""+data.getPresent());
        editor.putString(MISSINGNUMBER,""+data.getMissing());
        editor.putString(NAMENUMBER,""+data.getNameNo());
        editor.putString(CALCULATION,""+data.getCalculation());
        editor.commit();
    }

    public String getLUCKYNUMBER(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(LUCKYNUMBER,"");
    }
    public String getKUWANUMBER(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KUWANUMBER,"");
    }

    public String getCALCULATION(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(CALCULATION,"");
    }

    public String getMISSINGNUMBER(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(MISSINGNUMBER,"");
    }
    public String getDRIVER(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(DRIVER,"");
    }
    public String getCONDUCTOR(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(CONDUCTOR,"");
    }
    public String getNAMENUMBER(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(NAMENUMBER,"");
    }
    public String getPRESENTNUMBER(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(PRESENTNUMBER,"");
    }

    public void savePincode(String pincode){
        sharedPreferences = context.getSharedPreferences(DELIVERY_ADDRESS_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PINCODE, pincode);
        editor.commit();
    }

    public void saveSectionType(String sectionType){
        sharedPreferences = context.getSharedPreferences(DELIVERY_ADDRESS_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SECTION_TYPE, sectionType);
        editor.commit();
    }

    public void isAppInstalledFirstTime(boolean isFirstTime){
        sharedPreferences = context.getSharedPreferences(DELIVERY_ADDRESS_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IS_FIRST_TIME, isFirstTime);
        editor.commit();
    }

    public void Logout(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        sharedPreferences1 = context.getSharedPreferences(DELIVERY_ADDRESS_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        SharedPreferences.Editor editor1 = sharedPreferences1.edit();
        editor.clear();
        editor1.clear();
        editor.commit();
        editor1.commit();
    }

    public boolean IsLogin(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.contains(USER_ID);
    }

    public String getUser_id(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(USER_ID, "");
    }

    public String getUser_name(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(NAME, "");
    }

    public String getMobile_no(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(MOBILE_NO, "");
    }

    public String getADDRESS(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(ADDRESS, "");
    }

    public String getBUSINESS_NAME(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(BUSINESS_NAME, "");
    }

    public String getBUSINESS_LOGO(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(BUSINESS_LOGO, "");
    }


    public String getREFERAL_CODE(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(REFERAL_CODE, "");
    }

    public String getProfile_image(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(PROFILE_IMAGE, "");
    }

    public String getDobDay(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(DAY, "");
    }

    public String getDobMonth(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(MONTH, "");
    }

    public String getDobYear(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(YEAR, "");
    }

    public String getEmail(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(EMAIL, "");
    }

    public String getACCESS_TOKEN(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(ACCESS_TOKEN, "");
    }



    public String getPINCODE(){
        sharedPreferences = context.getSharedPreferences(MyLoginPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(PINCODE, "");
    }

    public String getCurrentPINCODE(){
        sharedPreferences = context.getSharedPreferences(DELIVERY_ADDRESS_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(PINCODE, "");
    }

    public String getSectionType(){
        sharedPreferences = context.getSharedPreferences(DELIVERY_ADDRESS_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(SECTION_TYPE, "");
    }

    public Boolean getIsAppInstalledFirstTime(){
        sharedPreferences = context.getSharedPreferences(DELIVERY_ADDRESS_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(IS_FIRST_TIME, true);
    }
}
