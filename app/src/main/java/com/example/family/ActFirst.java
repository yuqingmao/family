package com.example.family;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class ActFirst extends Activity {
    int imgstart = 0;
    private Context mContext;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private int[] imgids = new int[]{
            R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4
    };
    private ImageView imgchange;

    final Handler myfirsthandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x12) {
                imgchange.setImageResource(imgids[imgstart++ % 4]);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("ActFirst", "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_first);

        imgchange = findViewById(R.id.imgchange);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myfirsthandler.sendEmptyMessage(0x12);

            }
        }, 0, 600);

        bindButton();

        mContext = this;
    }

    protected void bindButton() {
        b1 = findViewById(R.id.man1);
        b2 = findViewById(R.id.man2);
        b3 = findViewById(R.id.cat1);
        b4 = findViewById(R.id.cat2);
        b5 = findViewById(R.id.homemap);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent("myActYM"));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2 = new Intent();
                ComponentName comp = new ComponentName("com.example.family",
                        "com.example.family.ActFF");
                it2.setComponent(comp);
                startActivity(it2);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it3 = new Intent();
                it3.setClassName(mContext, "com.example.family.ActC1");
                startActivity(it3);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it4 = new Intent();
                it4.setClass(mContext, ActC2.class);

                it4.putExtra("lb", 33);
                startActivity(it4);
            }
        });
    }


    public void onClickMap(View view) {
        Uri uri = Uri.parse("geo:37.363429, -121.993048");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    protected void onStart(){
        super.onStart();

        Log.d("ActFirst", "onStart: ");

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                findViewById(R.id.t4).getLayoutParams());
        params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.setMargins(0, 100, 0, 100);
        TextView cur = findViewById(R.id.t4);
        cur.setLayoutParams(params);
    }
    protected void onResume(){
        super.onResume();

        Log.d("ActFirst", "onResume: ");
    }
    protected void onPause(){
        super.onPause();

        Log.d("ActFirst", "onPause: ");
    }
    protected void onStop(){
        super.onStop();

        Log.d("ActFirst", "onStop: ");
    }
    protected void onDestroy(){
        super.onDestroy();

        Log.d("ActFirst", "onDestroy: ");
    }

    protected void onRestart(){
        super.onRestart();

        Log.d("ActFirst", "onRestart: ");
    }


}
