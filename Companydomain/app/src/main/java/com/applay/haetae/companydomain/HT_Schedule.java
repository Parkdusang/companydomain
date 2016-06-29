package com.applay.haetae.companydomain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HT_Schedule extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ht__schedule);

        setLayout();

        // 웹뷰에서 자바스크립트실행가능
        mWebView.getSettings().setJavaScriptEnabled(true);
        // 구글홈페이지 지정
        mWebView.loadUrl("http://www.art-block.co.kr/web/aq/play_list.asp");
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setSupportZoom(true);
        // WebViewClient 지정
        mWebView.setWebViewClient(new WebViewClientClass());

    }

    @Override
    public boolean onKeyDown ( int keyCode, KeyEvent event){
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    private void setLayout () {
        mWebView = (WebView) findViewById(R.id.webview);
    }
}