package com.applay.haetae.companydomain;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HT_EducationData extends AppCompatActivity {
    Button btnAkbo,btnMusic,btnBook,btnFeel;
    boolean check = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ht__education_data);

        btnAkbo = (Button)findViewById(R.id.btnAkbo);
        btnMusic = (Button)findViewById(R.id.btnMusic);
        btnBook = (Button)findViewById(R.id.btnBook);
        btnFeel = (Button)findViewById(R.id.btnFeel);
        btnAkbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Akbo.class);
                startActivity(intent);
            }
        });
        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Musicplay.class);
                startActivity(intent);
            }
        });
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Book.class);
                startActivity(intent);
            }
        });
        btnFeel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FeelMusic.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!check) {
            LinearLayout layout = (LinearLayout) findViewById(R.id.ht_educationback);
            layout.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.background)));
            LinearLayout layout1 = (LinearLayout) findViewById(R.id.inneredu);
            layout1.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.contentback)));

            ImageView img = (ImageView) findViewById(R.id.edutop1);
            img.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.edutop)));
            check = true;
        }
    }

    @Override
    protected void onStop() {
        super.onStop(); //save state data (background color) for future use
        check = false;
        recycleView(findViewById(R.id.ht_educationback));
        recycleView(findViewById(R.id.edutop1));
        recycleView(findViewById(R.id.inneredu));
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
