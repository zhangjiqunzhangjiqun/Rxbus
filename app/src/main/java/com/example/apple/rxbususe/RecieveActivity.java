package com.example.apple.rxbususe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.apple.service.MyService;

public class RecieveActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve);
        Log.d("", "RecieveActivity: +intent");

        Intent intent=new Intent(RecieveActivity.this, MyService.class);
        startService(intent);
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, RecieveActivity.class));
    }



    public void sendEvent(View view) {
        RxBus.getDefault().post(new EventBean(1, "听说名字长回头率很高"));
    }
}
