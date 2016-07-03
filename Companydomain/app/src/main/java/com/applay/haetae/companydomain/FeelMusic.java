package com.applay.haetae.companydomain;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

public class FeelMusic extends AppCompatActivity {


    Button btnSimPlay, btnSimStop, btnSimPause;
    MediaPlayer mp2;
    boolean check = false;
    SeekBar simSeek;
    TextView simmusic;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feel_music);

        btnSimPlay = (Button) findViewById(R.id.btnfillPlay);
        btnSimPause = (Button) findViewById(R.id.btnfillPause);
        btnSimStop = (Button) findViewById(R.id.btnfillStop);
        mp2 = MediaPlayer.create(FeelMusic.this, R.raw.simmusic);
        simSeek = (SeekBar) findViewById(R.id.SimSeekbar);
        simmusic = (TextView) findViewById(R.id.SimmusicTime);

        simSeek.setVisibility(ProgressBar.VISIBLE);
        simSeek.setMax(mp2.getDuration());
        simSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp2.seekTo(progress);
                }
                int m = progress / 60000;
                int s = (progress % 60000) / 1000;
                String strTime = String.format("%02d:%02d", m, s);
                simmusic.setText(strTime);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btnSimPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!check) {
                    check = true;
                    mp2.start();
                    Thread();
                }
            }
        });

        btnSimPause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (check) {
                    check = false;
                    mp2.pause();
                }
            }
        });

        btnSimStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp2.stop();
                try {
                    mp2.prepare();
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
                mp2.seekTo(0);
                finish();
            }
        });
    }

    public void Thread() {
        Runnable task = new Runnable(){
            public void run(){
                // 음악이 재생중일때
                while(mp2.isPlaying()){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    simSeek.setProgress(mp2.getCurrentPosition());
                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }


    @Override
    protected void onResume() {
        super.onResume();
        LinearLayout layout = (LinearLayout)findViewById(R.id.fillback);
        layout.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.background2)));
        LinearLayout layout2 = (LinearLayout)findViewById(R.id.innerfillback);
        layout2.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.contentback2)));


        ImageView img = (ImageView)findViewById(R.id.fillmusicplaytop);
        img.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.fillmusictop)));


    }

    @Override
    protected void onStop() {
        super.onStop(); //save state data (background color) for future use
        recycleView(findViewById(R.id.fillback));
        recycleView(findViewById(R.id.innerfillback));
        recycleView(findViewById(R.id.fillmusicplaytop));
        mp2.stop();
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
