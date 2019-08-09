package com.example.family;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    private Button bt1;
    private Button bt2;
    private EditText un;
    private EditText pw;
    String name = new String();
    String pass = new String();
    String DBname = new String();
    String DBpass = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        un = findViewById(R.id.et_user_name);
        pw = findViewById(R.id.et_password);

        showHW();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bt1 = findViewById(R.id.but1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInfo();
                getDBInfo();
                boolean correct = compare();

                if (correct) {
                    Intent it1 = new Intent();
                    it1.setClass(mContext, ActFirst.class);
                    startActivity(it1);
                } else {
                    Toast.makeText(mContext, "用户名或者密码不正确", Toast.LENGTH_LONG).show();
                }
            }
        });

        bt2 = findViewById(R.id.but2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2 = new Intent();
                it2.setClass(mContext, Register.class);
                startActivity(it2);
            }
        });
    }

    private void getInfo() {
        name = un.getText().toString();
        pass = pw.getText().toString();
        Log.d("test", "name is:" + name);
        Log.d("test", "pass is:" + pass);
    }

    private void getDBInfo() {
        SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
        DBname = pref.getString("NAME", "");
        DBpass = pref.getString("PASS", "");

        Log.d("test", "DBname is:" + DBname);
        Log.d("test", "DBpass is:" + DBpass);
    }

    private boolean compare() {
        boolean ret = false;
        if (name.equals(DBname) && pass.equals(DBpass)) ret = true;
        Log.d("test", "correct:" + ret);
        return ret;
    }


    private void showHW() {
        WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        Toast.makeText(mContext, "当前手机的屏幕宽度以及高度： " + dm.widthPixels + "*" +
                dm.heightPixels, Toast.LENGTH_LONG).show();
    }
}