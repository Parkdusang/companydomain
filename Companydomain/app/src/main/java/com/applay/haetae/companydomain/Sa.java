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

public class Sa extends AppCompatActivity {

    Button btnPrev, btnNext;
    ViewFlipper vFlipper;
    PhotoViewAttacher saAttacher;
    ImageView saview01, saview02, saview03, saview04;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa);

        btnNext = (Button)findViewById(R.id.btnNext);
        btnPrev = (Button)findViewById(R.id.btnPrev);
        vFlipper = (ViewFlipper)findViewById(R.id.viewFlipper1);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.showNext();
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.showPrevious();
            }
        });


        saview01 = (ImageView)findViewById(R.id.sa1);
        saview02 = (ImageView)findViewById(R.id.sa2);
        saview03 = (ImageView)findViewById(R.id.sa3);
        saview04 = (ImageView)findViewById(R.id.sa4);


    }
    @Override
    protected void onResume() {
        super.onResume();
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.saActivityback);
        layout.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.background2)));

        RelativeLayout layout2 = (RelativeLayout)findViewById(R.id.innersa);
        layout2.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.contentback2)));

        ImageView img = (ImageView) findViewById(R.id.satop);
        img.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.satop)));



        saview01.setImageResource(R.drawable.sa1);
        saview02.setImageResource(R.drawable.sa2);
        saview03.setImageResource(R.drawable.sa3);
        saview04.setImageResource(R.drawable.sa4);

        saAttacher = new PhotoViewAttacher(saview01);
        saAttacher.setScaleType((ImageView.ScaleType.FIT_CENTER));
        saAttacher = new PhotoViewAttacher(saview02);
        saAttacher.setScaleType((ImageView.ScaleType.FIT_CENTER));
        saAttacher = new PhotoViewAttacher(saview03);
        saAttacher.setScaleType((ImageView.ScaleType.FIT_CENTER));
        saAttacher = new PhotoViewAttacher(saview04);
        saAttacher.setScaleType((ImageView.ScaleType.FIT_CENTER));

    }

    @Override
    protected void onStop() {
        super.onStop(); //save state data (background color) for future use
        recycleView(findViewById(R.id.saActivityback));
        recycleView(findViewById(R.id.satop));
        recycleView(findViewById(R.id.innersa));
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
