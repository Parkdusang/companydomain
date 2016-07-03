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

public class Musicplay extends AppCompatActivity {


    Button btnPlay, btnStop,btnPause;
    MediaPlayer mp;
    boolean check2 = false;
    SeekBar musicSeek;
    TextView musictime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicplay);

        btnPlay = (Button) findViewById(R.id.btnMusicPlay);
        btnPause = (Button) findViewById(R.id.btnMusicPause);
        btnStop = (Button) findViewById(R.id.btnMusicStop);
        mp = MediaPlayer.create(Musicplay.this, R.raw.music1);
        musicSeek = (SeekBar) findViewById(R.id.MusicSeekbar);
        musictime = (TextView) findViewById(R.id.MusicTime);

        musicSeek.setVisibility(ProgressBar.VISIBLE);
        musicSeek.setMax(mp.getDuration());
        musicSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp.seekTo(progress);
                }
                int m = progress / 60000;
                int s = (progress % 60000) / 1000;
                String strTime = String.format("%02d:%02d", m, s);
                musictime.setText(strTime);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!check2) {
                    check2 = true;
                    mp.start();
                    Thread();
                }
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(check2) {
                    check2 = false;
                    mp.pause();
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.stop();
                try {
                    mp.prepare();
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
                mp.seekTo(0);
                finish();
            }
        });
    }

    public void Thread() {
        Runnable task = new Runnable(){
            public void run(){
                // 음악이 재생중일때
                while(mp.isPlaying()){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    musicSeek.setProgress(mp.getCurrentPosition());
                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LinearLayout layout = (LinearLayout)findViewById(R.id.musicplayback);
        layout.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.background2)));


        LinearLayout layout2 = (LinearLayout)findViewById(R.id.innermusicback);
        layout2.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.contentback2)));


        ImageView img = (ImageView)findViewById(R.id.musicplaytop);
        img.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.musicplaytop)));


    }

    @Override
    protected void onStop() {
        super.onStop(); //save state data (background color) for future use
        recycleView(findViewById(R.id.musicplayback));
        recycleView(findViewById(R.id.innermusicback));

        recycleView(findViewById(R.id.musicplaytop));
        mp.stop();
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
