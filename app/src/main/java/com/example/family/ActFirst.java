package com.example.family;


import android.Manifest.permission;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.Timer;
import java.util.TimerTask;


public class ActFirst extends Activity {
    int imgstart = 0;
    private Context mContext;
    private Button bh;
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

        Log.d("data", "onCreate: ");
        super.onCreate(savedInstanceState);
        mContext = this;
        getContacts();

        removeView();
        addView();

        setContentView(R.layout.act_first);


        imgchange = findViewById(R.id.imgchange);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myfirsthandler.sendEmptyMessage(0x12);

            }
        }, 0, 600);

        bindButton();
    }

    private void removeView(){
        LinearLayout ly = new LinearLayout(this);
        TextView title = findViewById(R.id.main_t1);
        ly.removeView(title);
    }

    private void addView(){
        LinearLayout ly = new LinearLayout(this);
        Button btn = new Button(this);
        btn.setText("JAVA 添加的按钮");
        ly.addView(btn);
    }

    protected void bindButton() {
        bh = findViewById(R.id.t4);
        b1 = findViewById(R.id.man1);
        b2 = findViewById(R.id.man2);
        b3 = findViewById(R.id.cat1);
        b4 = findViewById(R.id.cat2);
        b5 = findViewById(R.id.homemap);

        bh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it0 = new Intent();
                it0.setClassName(mContext, "com.example.family.HomeMembers");
                startActivity(it0);
            }
        });

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
                it4.setClassName(mContext, "com.example.family.ActC2");
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

        Log.d("data", "onStart: ");

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                findViewById(R.id.t4).getLayoutParams());
        params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.setMargins(0, 100, 0, 100);
        TextView cur = findViewById(R.id.t4);
        cur.setLayoutParams(params);
    }
    protected void onResume(){
        super.onResume();

        Log.d("data", "onResume: ");
    }
    protected void onPause(){
        super.onPause();

        Log.d("data", "onPause: ");
    }
    protected void onStop(){
        super.onStop();

        Log.d("data", "onStop: ");
    }
    protected void onDestroy(){
        super.onDestroy();

        Log.d("data", "onDestroy: ");
    }

    protected void onRestart(){
        super.onRestart();

        Log.d("data", "onRestart: ");
    }

    public void getContacts() {
        ContentResolver resolver = mContext.getContentResolver();
        Uri uri = Phone.CONTENT_URI;
        if ((ContextCompat.checkSelfPermission(mContext, permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED) ||
            (ContextCompat.checkSelfPermission(mContext, permission.WRITE_CONTACTS)
            != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(ActFirst.this,
                new String[]{permission.READ_CONTACTS, permission.WRITE_CONTACTS}, 1);
        } else {
            Cursor cursor = resolver.query(uri, null, null, null, null);
            while (cursor.moveToNext()) {
                String cName = cursor.getString(cursor.getColumnIndex(Phone.DISPLAY_NAME));
                String cNum = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
                Log.d("Test", "getContacts: " + cName);
                Log.d("Test", "getNumber: " + cNum);
            }
            ContentValues values = new ContentValues();
            values.put(Phone.DISPLAY_NAME, "addedContact");
            values.put(Phone.NUMBER, "1234567890");
            getContentResolver().update(uri, values, "display_name = ? and data1 = ?"
            , new String[]{"text", "1"});
            cursor.close();
        }
    }
}
