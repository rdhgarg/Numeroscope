package com.numeroscop.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.numeroscop.R;
import com.numeroscop.databinding.ActivityContactUsBinding;
import com.numeroscop.databinding.ActivityReportsBinding;

public class ContactUsActivity extends AppCompatActivity {
    ActivityContactUsBinding binding;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_contact_us);

        binding.webViewContact.setWebViewClient(new myWebViewClient());
        binding.webViewContact.getSettings().setLoadsImagesAutomatically(true);
        binding.webViewContact.getSettings().setJavaScriptEnabled(true);
        binding.webViewContact.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.webViewContact.loadUrl("http://numeroscop.in/contact.html");


        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}

 class myWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl("http://numeroscop.in/contact.html");
        return true;
    }
}