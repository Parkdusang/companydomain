package com.applay.haetae.companydomain;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Musicplay extends AppCompatActivity {

    Button btnPlay, btnStop;
    MediaPlayer mp;
    boolean check2 = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicplay);

        btnPlay = (Button) findViewById(R.id.btnMusicPlay);
        btnStop = (Button) findViewById(R.id.btnMusicStop);
        mp = MediaPlayer.create(Musicplay.this, R.raw.music1);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!check2) {
                    check2 = true;
                    mp.start();

                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(check2) {
                    check2 = false;
                    mp.pause();
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        LinearLayout layout = (LinearLayout)findViewById(R.id.musicplayback);
        layout.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.background)));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy(); //save state data (background color) for future use
        recycleView(findViewById(R.id.musicplayback));
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
