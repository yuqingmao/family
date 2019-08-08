package com.example.family;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ActFF extends Activity {
    Context mContext;
    private Button bt;

    private IntentFilter intentFilter;
    private NetworkChangeReceiver ncr;


    
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

        //broadcast dynamic receive
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        ncr = new NetworkChangeReceiver();
        registerReceiver(ncr, intentFilter);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(ncr);
    }

    class NetworkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent){
            Toast.makeText(context, "Network change", Toast.LENGTH_LONG).show();
        }
    }
}
