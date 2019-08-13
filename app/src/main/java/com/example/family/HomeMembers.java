package com.example.family;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.family.SQL.MyDatabaseHelper;


public class HomeMembers extends AppCompatActivity {

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private EditText con1;
    private EditText con2;
    private EditText con3;
    private EditText con4;
    private Context mContext;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_home_members);

        addMemberToDataBase();
        deleteMemberToDataBase();
    }

    @Override
    protected void onStart(){
        super.onStart();

    }

    private void addMemberToDataBase(){
        dbHelper = new MyDatabaseHelper(mContext, "FamilyDB.db", null, 4);
        con1 = findViewById(R.id.dbet1);
        con2 = findViewById(R.id.dbet2);
        con3 = findViewById(R.id.dbet3);
        bt1 = findViewById(R.id.mbt1);
        bt2 = findViewById(R.id.mbt2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                Toast.makeText(mContext, "Added new item to Database successfully!"
                , Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void deleteMemberToDataBase(){
        dbHelper = new MyDatabaseHelper(mContext, "FamilyDB.db", null, 4);
        con4 = findViewById(R.id.dbet4);
        bt3 = findViewById(R.id.mbt3);

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Member", "name = ?", new String[]{con4.getText().toString()});
                Toast.makeText(mContext, "Deleted selected item from Database!"
                    , Toast.LENGTH_SHORT).show();
            }
        });
    }

}
