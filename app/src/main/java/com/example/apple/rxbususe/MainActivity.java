package com.example.apple.rxbususe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.apple.service.MyService;

import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContent = findViewById(R.id.tv_content);
        recieveEvent();
        Log.d(TAG, "MainActivity: +intent");

        Intent intent = new Intent(MainActivity.this, MyService.class);
        startService(intent);
    }

    public void jump(View view) {
        RecieveActivity.start(this);
    }

    private void recieveEvent() {
        Subscription subscription = RxBus.getDefault().toObservable(EventBean.class).subscribe(new Action1<EventBean>() {
            @Override
            public void call(EventBean eventBean) {
                tvContent.setText(eventBean.getUserId() + "------" + eventBean.getNickName());
            }
        });
        rxBusList.add(subscription);
    }

    public void sendEvent(View view) {
        RxBus.getDefault().post(new EventBean(1, "MainActivity"));
    }

}
