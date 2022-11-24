package com.numeroscop.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.numeroscop.R;
import com.numeroscop.databinding.ActivityTermAndConditionBinding;

public class TermAndConditionActivity extends AppCompatActivity {
    ActivityTermAndConditionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_term_and_condition);
        binding.webViewContact.setWebViewClient(new myWebViewClientT());
        binding.webViewContact.getSettings().setLoadsImagesAutomatically(true);
        binding.webViewContact.getSettings().setJavaScriptEnabled(true);
        binding.webViewContact.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.webViewContact.loadUrl("http://numeroscop.in/terms.html");


        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}

class myWebViewClientT extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl("http://numeroscop.in/terms.html");
        return true;
    }
}