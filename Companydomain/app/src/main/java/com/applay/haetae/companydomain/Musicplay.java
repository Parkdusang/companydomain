package com.applay.haetae.companydomain;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Musicplay extends AppCompatActivity {

    Intent intent;
    Button btnPlay, btnStop;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicplay);

        intent = new Intent(this, Music.class);
        btnPlay = (Button) findViewById(R.id.btnMusicPlay);
        btnStop = (Button) findViewById(R.id.btnMusicStop);


        btnPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startService(intent);
                android.util.Log.i("서비스 테스트", "startService()");
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
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
