package com.example.allapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;

    @Override
    public boolean onSupportNavigateUp() {
        if(webView.canGoBack()){
            webView.goBack();
        }else {
            finish();
        }
        return super.onSupportNavigateUp();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webView = findViewById(R.id.myWeb);
        webView.setWebViewClient(new WebViewClient());
//        webView.loadUrl("https://niket.vercel.app/");


        String htmlData = "<html><body><h1>Hello World!</h1></body></html>";
        String mimeType = "text/html";
        String encoding = "UTF-8";
        webView.loadData(htmlData, mimeType, encoding);
    }


    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else {
            finish();
        }

        super.onBackPressed();
    }
}