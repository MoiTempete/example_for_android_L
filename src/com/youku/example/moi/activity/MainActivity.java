package com.youku.example.moi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.youku.example.moi.R;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnRecycler2 = (Button) findViewById(R.id.btn_recycler_vertical);
        btnRecycler2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        Button btnSampleRecycler = (Button) findViewById(R.id.btn_sample_recycler);
        btnSampleRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity2.class);
                startActivity(intent);
            }
        });

        Button btnAnimation = (Button) findViewById(R.id.btn_animation);
        btnAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AnimationActivity.class));
            }
        });

//        Button btnGraphics = (Button) findViewById(R.id.btn_graphics);
//        btnGraphics.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MyActivity.this, GraphicsActivity.class));
//            }
//        });

        Button btnTransition = (Button) findViewById(R.id.btn_Transition);
        btnTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TransitionActivity.class));
            }
        });

    }
}
