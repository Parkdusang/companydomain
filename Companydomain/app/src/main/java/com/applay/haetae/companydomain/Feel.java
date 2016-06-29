package com.applay.haetae.companydomain;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class Feel extends Service {

    MediaPlayer mp2;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        android.util.Log.i("서비스 테스트", "onCreate()");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        android.util.Log.i("서비스 테스트", "onDestroy()");
        mp2.stop();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        android.util.Log.i("서비스 테스트", "onStartCommand()");
        mp2 = MediaPlayer.create(this, R.raw.simmusic);
        mp2.setLooping(true);
        mp2.start();
        return super.onStartCommand(intent, flags, startId);
    }


}
