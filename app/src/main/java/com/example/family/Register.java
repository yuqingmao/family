package com.example.family;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends Activity {

    Context mContext;
    private Button bt3;
    private EditText un;
    private EditText pw;
    String name = new String();
    String pass = new String();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        mContext = this;

        un = findViewById(R.id.et1);
        pw = findViewById(R.id.et2);

        bt3 = findViewById(R.id.but3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoPreference();

                Intent it3 = new Intent();
                it3.setClass(mContext, MainActivity.class);
                startActivity(it3);
            }
        });
    }

    private void gotoPreference(){
        name = un.getText().toString();
        pass = pw.getText().toString();
        Log.d("test", "name is:" + name);
        Log.d("test", "pass is:" + pass);

        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString("NAME", name);
        editor.putString("PASS", pass);
        editor.apply();

    }


}
