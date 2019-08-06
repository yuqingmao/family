package com.example.family;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    private Button bt0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bt0 = findViewById(R.id.but1);
        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it4 = new Intent();
                it4.setClass(mContext, ActFirst.class);
                startActivity(it4);
            }
        });

        EditText et = findViewById(R.id.et_user_name);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                Toast.makeText(mContext, "您还未输入个人信息", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                Toast.makeText(mContext, "其实您输入了也没屁用", Toast.LENGTH_LONG).show();

            }

            @Override
            public void afterTextChanged(Editable editable) {
//                Toast.makeText(mContext, "我早就说了吧！输入了也没屁用", Toast.LENGTH_LONG).show();
            }
        });

    }

}