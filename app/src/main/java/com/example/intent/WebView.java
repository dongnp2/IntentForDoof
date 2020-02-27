package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebViewClient;

import java.net.URL;

public class WebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        android.webkit.WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

        Uri uri = getIntent().getData();
        URL url;
        try{
            url = new URL(uri.getScheme(),uri.getHost(),uri.getPath());
            webView.loadUrl(url.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
