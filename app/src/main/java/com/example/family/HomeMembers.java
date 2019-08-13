package com.example.family;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.family.SQL.MyDatabaseHelper;


public class HomeMembers extends AppCompatActivity {

    private Button bt1;
    private Button bt2;
    private EditText con1;
    private EditText con2;
    private EditText con3;
    private Context mContext;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_home_members);

        dbHelper = new MyDatabaseHelper(mContext, "FamilyDB.db", null, 4);
        con1 = findViewById(R.id.dbet1);
        con2 = findViewById(R.id.dbet2);
        con3 = findViewById(R.id.dbet3);

        bt1 = findViewById(R.id.mbt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });

        bt2 = findViewById(R.id.mbt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
                String info1 = con1.getText().toString();
                String info2 = con2.getText().toString();
                String info3 = con3.getText().toString();

                ContentValues values = new ContentValues();
                values.put("name", info1);
                values.put("location", info2);
                values.put("gender", info3);

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.insert("Member", null, values);
                values.clear();
            }
        });

    }

}
