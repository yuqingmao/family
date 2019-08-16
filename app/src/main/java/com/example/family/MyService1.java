package com.example.family;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService1 extends Service {
    public static final String TAG = "MyService1";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("myservice", "onCreate done");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("myservice", "onStartCommand done");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("myservice", "onDestroy done");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
