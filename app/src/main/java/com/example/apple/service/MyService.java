package com.example.apple.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.apple.rxbususe.EventBean;
import com.example.apple.rxbususe.RxBus;

import java.util.ArrayList;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by Administrator on 2020/3/4 0004.
 */

public class MyService extends Service {
    String TAG = "MyService";

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(TAG, "onStartCommand======: +start");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand======: +onStartCommand");
        sendEvent();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean stopService(Intent name) {

        return super.stopService(name);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public void sendEvent() {
        RxBus.getDefault().post(new EventBean(2, "MainActivity"));
    }
}
