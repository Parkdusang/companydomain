package com.applay.haetae.companydomain;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import uk.co.senab.photoview.PhotoViewAttacher;

public class Sim extends AppCompatActivity {

    Button btnNext,btnPre;
    PhotoViewAttacher simAttacher;
    ImageView sim1,sim2,sim3,sim4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim);

        final ViewFlipper vFlipper;
        vFlipper = (ViewFlipper)findViewById(R.id.viewFlipper2);
        btnPre = (Button)findViewById(R.id.btnPrev2);
        btnNext = (Button)findViewById(R.id.btnNext2);
        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.showPrevious();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.showNext();
            }
        });

        sim1 = (ImageView)findViewById(R.id.sim1);
        sim2 = (ImageView)findViewById(R.id.sim2);
        sim3 = (ImageView)findViewById(R.id.sim3);
        sim4 = (ImageView)findViewById(R.id.sim4);


    }
    @Override
    protected void onResume() {
        super.onResume();
        RelativeLayout layout1 = (RelativeLayout)findViewById(R.id.simback12);
        layout1.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.background2)));

        RelativeLayout layout2 = (RelativeLayout)findViewById(R.id.innersim);
        layout2.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.contentback2)));

        ImageView img = (ImageView) findViewById(R.id.simtop);
        img.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.simtop)));




        sim1.setImageResource(R.drawable.sim01);
        sim2.setImageResource(R.drawable.sim02);
        sim3.setImageResource(R.drawable.sim03);
        sim4.setImageResource(R.drawable.sim04);
        simAttacher = new PhotoViewAttacher(sim1);
        simAttacher.setScaleType((ImageView.ScaleType.FIT_CENTER));
        simAttacher = new PhotoViewAttacher(sim2);
        simAttacher.setScaleType((ImageView.ScaleType.FIT_CENTER));
        simAttacher = new PhotoViewAttacher(sim3);
        simAttacher.setScaleType((ImageView.ScaleType.FIT_CENTER));
        simAttacher = new PhotoViewAttacher(sim4);
        simAttacher.setScaleType((ImageView.ScaleType.FIT_CENTER));

    }

    @Override
    protected void onStop() {
        super.onStop(); //save state data (background color) for future use
        recycleView(findViewById(R.id.simback12));
        recycleView(findViewById(R.id.innersim));
        recycleView(findViewById(R.id.simtop));

        ((BitmapDrawable)sim1.getDrawable()).getBitmap().recycle();
        ((BitmapDrawable)sim2.getDrawable()).getBitmap().recycle();
        ((BitmapDrawable)sim3.getDrawable()).getBitmap().recycle();
        ((BitmapDrawable)sim4.getDrawable()).getBitmap().recycle();

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
