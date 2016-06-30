package com.applay.haetae.companydomain;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FeelMusic extends AppCompatActivity {


    Button btnSimPlay, btnSimStop;
    MediaPlayer mp2;
    boolean check = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feel_music);


        btnSimPlay = (Button) findViewById(R.id.btnFillmusicPlay);
        btnSimStop = (Button) findViewById(R.id.btnFillmusicStop);
        mp2 = MediaPlayer.create(FeelMusic.this, R.raw.simmusic);

        btnSimPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!check) {
                    check = true;
                    mp2.start();
                }
            }
        });

        btnSimStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(check) {
                    check = false;
                    mp2.pause();
                }
            }
        });

    }

}
