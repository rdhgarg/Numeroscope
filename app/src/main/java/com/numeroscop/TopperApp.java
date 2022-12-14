package com.numeroscop;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.numeroscop.ApiCall.ApiService;
import com.numeroscop.Utils.ApiConstants;
import com.numeroscop.Utils.CustomInterceptor;

import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class TopperApp extends MultiDexApplication {

    private static TopperApp mInstance;
    private ApiService apiService, apiService1;
    String androidId = "",pushRegId = "";

    public TopperApp() {
        super();
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static synchronized TopperApp getInstance() {
        if (mInstance == null)
            mInstance = new TopperApp();
        return mInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        MultiDex.install(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        createApiService();
    }

    public ApiService createApiService() {
        Gson gson = new GsonBuilder().setLenient().create();
        File httpCacheDirectory = new File(getCacheDir(), "cache_file");
        Cache cache = new Cache(httpCacheDirectory, 20 * 1024 * 1024);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .connectionPool(new ConnectionPool(0, 5 * 60 * 1000, TimeUnit.SECONDS))
                .addInterceptor(new CustomInterceptor(getInstance(), Locale.getDefault().getLanguage(), "1"))
                .cache(cache)
                .build();


        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient)
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiService = retrofit.create(ApiService.class);
        return apiService;
    }

    public ApiService getApiService() {
        return apiService;

    }

}
