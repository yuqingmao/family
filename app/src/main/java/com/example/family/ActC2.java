package com.example.family;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;


public class ActC2 extends Activity {
    public int weight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        Intent intent = getIntent();
        weight = intent.getIntExtra("lb", 0);

//        TextView tv = findViewById(R.id.t5);
//        tv.setText("这货的体重为：" + weight + " 斤");

    }
}
