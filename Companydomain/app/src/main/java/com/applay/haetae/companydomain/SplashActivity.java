package com.applay.haetae.companydomain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class SplashActivity extends Activity {
    Thread myThread = new Thread();
    boolean checkb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
//        Handler hd = new Handler();
//        hd.postDelayed(new splashhandler() , 2000); // 3초 후에 hd Handler 실행
    }

    private class splashhandler implements Runnable {
        public void run() {
            startActivity(new Intent(getApplication(), HT_VideoActivity.class)); // 로딩이 끝난후 이동할 Activity
            SplashActivity.this.finish(); // 로딩페이지 Activity Stack에서 제거
        }
    }

    public void updateclock() {
        int i = 0;
        while (i < 2) {

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 1) {
                if (checkb) {
                    startActivity(new Intent(getApplication(), Main.class)); // 로딩이 끝난후 이동할 Activity
                    SplashActivity.this.finish(); // 로딩페이지 Activity Stack에서 제거
                } else {
                    break;
                }
            }
            i++;
        }
    }

    @Override
    protected void onPause() {
        super.onPause(); //save state data (background color) for future use
        checkb = false;

    }

    @Override
    protected void onResume() {
        super.onResume();
        checkb = true;
        startT();
    }

    public void startT() {
        myThread = new Thread(new Runnable() {
            public void run() {
                updateclock();
            }
        });

        myThread.start();
    }

}

