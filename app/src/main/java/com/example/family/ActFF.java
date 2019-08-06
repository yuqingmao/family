package com.example.family;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ActFF extends Activity {
    Context mContext;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        mContext = this;

        bt = findViewById(R.id.lgqn);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "找到老公了！", Toast.LENGTH_LONG).show();
                Intent it = new Intent();
                it.setClassName(mContext, "com.example.family.ActYM");
                startActivity(it);
            }
        });
    }
}
