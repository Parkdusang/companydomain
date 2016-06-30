package com.applay.haetae.companydomain;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import uk.co.senab.photoview.PhotoViewAttacher;

public class Book extends AppCompatActivity {

    Button btnPrev, btnNext;
    ViewFlipper vFlipper;
    ImageView bookview1, bookview2, bookview3;
    PhotoViewAttacher bookAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book);


        btnNext = (Button)findViewById(R.id.btnBookNext);
        btnPrev = (Button)findViewById(R.id.btnBookPrev);
        vFlipper = (ViewFlipper)findViewById(R.id.BookviewFlipper1);

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



        bookview1 = (ImageView)findViewById(R.id.book1);
        bookview2 = (ImageView)findViewById(R.id.book2);
        bookview3 = (ImageView)findViewById(R.id.book3);


    }


    @Override
    protected void onResume() {
        super.onResume();
        LinearLayout layout = (LinearLayout)findViewById(R.id.bookback);
        layout.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.background)));
//        bookview1.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources() , R.drawable.book1)));
//        bookview2.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.book2)));
//        bookview3.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources() , R.drawable.book3)));


        bookview1.setImageResource(R.drawable.book1);
        bookview2.setImageResource(R.drawable.book2);
        bookview3.setImageResource(R.drawable.book3);


        bookAttacher = new PhotoViewAttacher(bookview1);
        bookAttacher.setScaleType((ImageView.ScaleType.FIT_CENTER));
        bookAttacher.update();
        bookAttacher = new PhotoViewAttacher(bookview2);
        bookAttacher.setScaleType((ImageView.ScaleType.FIT_CENTER));
        bookAttacher.update();
        bookAttacher = new PhotoViewAttacher(bookview3);
        bookAttacher.setScaleType((ImageView.ScaleType.FIT_CENTER));
        bookAttacher.update();
    }

    @Override
    protected void onStop() {
        super.onStop(); //save state data (background color) for future use
        recycleView(findViewById(R.id.bookback));
        recycleView(findViewById(R.id.book1));
        recycleView(findViewById(R.id.book2));
        recycleView(findViewById(R.id.book3));
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
