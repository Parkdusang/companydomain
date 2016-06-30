package com.applay.haetae.companydomain;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Akbo extends AppCompatActivity {

    Button btnSim1, btnSa1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akbo);
        btnSim1 = (Button)findViewById(R.id.btnSim);
        btnSa1 = (Button)findViewById(R.id.btnSa);

        btnSim1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inIntent = new Intent(getApplicationContext(), Sim.class);
                startActivity(inIntent);
                finish();
            }
        });
        btnSa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Sa.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();

            LinearLayout layout = (LinearLayout) findViewById(R.id.akbobackground);
            layout.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.background)));
            LinearLayout layout2 = (LinearLayout) findViewById(R.id.innerakbobackground);
            layout2.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.contentback)));

            ImageView img = (ImageView) findViewById(R.id.akbotop1);
            img.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.akbotop)));

    }

    @Override
    protected void onStop() {
        super.onStop(); //save state data (background color) for future use
        recycleView(findViewById(R.id.akbobackground));
        recycleView(findViewById(R.id.akbotop1));
        recycleView(findViewById(R.id.innerakbobackground));

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
