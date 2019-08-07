package com.example.family;

import android.os.Bundle;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class HomeMembers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home_members);

        //create button
        Button bt1 = new Button(this);
        bt1.setText("我是动态添加按钮第一号");

        //create a LayoutParams, lp1 is serving the view of bt1
        RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, -2);
        lp1.addRule(RelativeLayout.CENTER_IN_PARENT);

        //create a inflater
        LayoutInflater inflater = LayoutInflater.from(this);

        //find layout instance from inflater
        View cur = inflater.inflate(R.layout.activity_home_members,null);
//        RelativeLayout rly = cur.findViewById(R.id.homes);

        RelativeLayout rly = findViewById(R.id.homes);
        rly.addView(bt1, lp1);

//        setContentView(rly);
    }

}
