package com.applay.haetae.companydomain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class HT_InnerVideo2 extends AppCompatActivity {
    WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ht__inner_video2);


        browser = (WebView) findViewById(R.id.webview2);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl("file:///android_asset/Video1.html");
    }
}
