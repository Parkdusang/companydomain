package com.applay.haetae.companydomain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FeelMusic extends AppCompatActivity {

    Intent intent;
    Button btnSimPlay, btnSimStop;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feel_music);

        intent = new Intent(this, Feel.class);
        btnSimPlay = (Button) findViewById(R.id.btnFillmusicPlay);
        btnSimStop = (Button) findViewById(R.id.btnFillmusicStop);


        btnSimPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startService(intent);
                android.util.Log.i("서비스 테스트", "startService()");
            }
        });

        btnSimStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopService(intent);
                android.util.Log.i("서비스 테스트", "stopService()");
            }
        });

    }
    @Override
    public void onPause(){
        super.onPause();
        stopService(intent);

    }
}
