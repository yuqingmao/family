package com.example.family.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.*;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static String CREATE_KEY = "create table Member ("
            + "id integer primary key autoincrement, "
            + "name text, "
            + "location text, "
            + "gender text)";
    private Context mContext;

    public MyDatabaseHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_KEY);
        Toast.makeText(mContext, "Created DB successfully", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Member.db");
        db.execSQL("drop table if exists Familys.db");
        onCreate(db);

        Toast.makeText(mContext, "Upgrade DB successfully", Toast.LENGTH_LONG).show();
    }
}
