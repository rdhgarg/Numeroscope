package com.numeroscop.ApiCall;


import com.numeroscop.ApiCall.Model.BuySubcriptionResBean;
import com.numeroscop.ApiCall.Model.GetNumberResBean;
import com.numeroscop.ApiCall.Model.GetReportResBean;
import com.numeroscop.ApiCall.Model.LoginResBean;
import com.numeroscop.ApiCall.Model.MarriageDetailsResBean;
import com.numeroscop.ApiCall.Model.MyReportResBean;
import com.numeroscop.ApiCall.Model.OtpResBean;
import com.numeroscop.ApiCall.Model.PersonalDateResBean;
import com.numeroscop.ApiCall.Model.PlanListResBean;
import com.numeroscop.ApiCall.Model.RegisterResBean;
import com.numeroscop.ApiCall.Model.SaveSolutionResBean;
import com.numeroscop.Utils.ApiConstants;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    @FormUrlEncoded
    @POST(ApiConstants.REGISTER_URL)
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<RegisterResBean> Register(@Header("Authorization") String accessToken,
                                   @Field("name") String name,
                                   @Field("mobile") String mobile,
                                   @Field("email") String email);

    @FormUrlEncoded
    @POST(ApiConstants.LOGIN_URL)
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<LoginResBean> Login(@Header("Authorization") String accessToken,
                             @Field("mobile") String mobile);

    @FormUrlEncoded
    @POST(ApiConstants.OTP_URL)
    Call<OtpResBean> Otp(@Field("otp") String otp,
                         @Field("mobile") String mobile);

    @FormUrlEncoded
    @POST(ApiConstants.GET_NUMBER)
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<GetNumberResBean>GetNUmber(@Header("Authorization") String accessToken,
                                    @Field("name") String name,
                                    @Field("mobile") String mobile,
                                    @Field("dob") String dob,
                                    @Field("gender") String gender);

    @FormUrlEncoded
    @POST(ApiConstants.GET_REPORT_URL)
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<GetReportResBean>GetReport(@Header("Authorization") String accessToken,
                                    @Field("name") String name,
                                    @Field("mobile") String mobile,
                                    @Field("dob") String dob,
                                    @Field("gender") String gender,
                                    @Field("report_id") String report_id,
                                    @Field("is_refresh") String isRefresh);


    @FormUrlEncoded
    @POST(ApiConstants.SAVE_SOLUTION_URL)
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<SaveSolutionResBean>SaveSolution(@Header("Authorization") String accessToken,
                                          @Field("solution") String solution,
                                          @Field("report_id") String report_id);


    @Multipart
    @POST(ApiConstants.GET_PROFILE_URL)
    @Headers({"Accept: application/json"})
    Call<OtpResBean>GetUpdateProfile(@Header("Authorization") String accessToken,
                                         @Part("name") RequestBody name,
                                         @Part("mobile_no") RequestBody mobile_no,
                                         @Part("email") RequestBody email,
                                         @Part("address") RequestBody address,
                                         @Part("business_name") RequestBody business_name,
                                         @Part("referal_code") RequestBody referal_code,
                                         @Part MultipartBody.Part business_logo);

    @FormUrlEncoded
    @POST(ApiConstants.GET_PERSONAL_DATE_URL)
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<PersonalDateResBean>GetPersonalDate(@Header("Authorization") String accessToken,
                                             @Field("dob") String dob,
                                             @Field("desire_date") String desire_date);


    @FormUrlEncoded
    @POST(ApiConstants.GET_MARRIGE_DETAIL_URL)
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<MarriageDetailsResBean>GetMarriageDetails(@Header("Authorization") String accessToken,
                                                   @Field("male_dob") String male_dob,
                                                   @Field("male_name") String male_name,
                                                   @Field("female_name") String female_name,
                                                   @Field("female_dob") String female_dob);


    @POST(ApiConstants.GET_Plan_URL)
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<PlanListResBean>GetPlanList(@Header("Authorization") String accessToken);


    @FormUrlEncoded
    @POST(ApiConstants.GET_BUY_SUBSCRITION_URL)
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<BuySubcriptionResBean>GetBuySubcriptionList(@Header("Authorization") String accessToken,
                                                     @Field("plan_id") String plan_id,
                                                     @Field("transaction_id") String transaction_id);

    @POST(ApiConstants.GET_MY_REPORTS)
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<MyReportResBean>GetMyReports(@Header("Authorization") String accessToken);


}



