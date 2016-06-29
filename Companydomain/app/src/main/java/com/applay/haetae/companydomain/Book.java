package com.applay.haetae.companydomain;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

public class Book extends AppCompatActivity {

    Button btnPrev, btnNext;
    ViewFlipper vFlipper;
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

    }


    @Override
    protected void onResume() {
        super.onResume();
        LinearLayout layout = (LinearLayout)findViewById(R.id.bookback);
        layout.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.background)));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy(); //save state data (background color) for future use
        recycleView(findViewById(R.id.bookback));
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
