package com.applay.haetae.companydomain;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

public class HT_InnerVideo1 extends AppCompatActivity {
    WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ht__inner_video1);

        browser = (WebView) findViewById(R.id.webview1);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl("file:///android_asset/Video1.html");
    }
    @Override
    protected void onResume() {
        super.onResume();
        LinearLayout layout = (LinearLayout)findViewById(R.id.video1);
        layout.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.backvideo1)));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy(); //save state data (background color) for future use
        recycleView(findViewById(R.id.video1));
    }

    private void recycleView(View view) {
        if(view != null) {
            Drawable bg = view.getBackground();
            if(bg != null) {
                bg.setCallback(null);
                ((BitmapDrawable)bg).getBitmap().recycle();
                view.setBackgroundDrawable(null);
            }
        }
    }
}
