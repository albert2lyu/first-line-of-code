package com.mt178.diyihangdaima;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.activeandroid.query.Update;
import com.mt178.diyihangdaima.Receivers.ReceiverNetWorkChange;
import com.mt178.diyihangdaima.Service.ServiceLongRunning;
import com.mt178.diyihangdaima.atys.AtyChat;
import com.mt178.diyihangdaima.atys.AtyFruit;
import com.mt178.diyihangdaima.atys.AtyNewsTitle;
import com.mt178.diyihangdaima.atys.AtyNotification;
import com.mt178.diyihangdaima.atys.AtySeconed;
import com.mt178.diyihangdaima.db.Item;
import com.mt178.diyihangdaima.tools.BaseActivity;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;

    private IntentFilter intentFilter;
    private ReceiverNetWorkChange receiverNetWorkChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            String tempData = savedInstanceState.getString("data_key");
            Toast.makeText(this, tempData, Toast.LENGTH_SHORT);
        }
        init();

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        receiverNetWorkChange = new ReceiverNetWorkChange();
        registerReceiver(receiverNetWorkChange, intentFilter);

    }

    private void init() {
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.tomhuahua.github.io"));
                startActivity(intent);
            case R.id.button2:
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:650158"));
                startActivity(intent2);
            case R.id.button3:
                Intent intent3 = new Intent(MainActivity.this, AtySeconed.class);
                startActivityForResult(intent3, 1);
                break;
            case R.id.button4:
                Intent intent4 = new Intent(MainActivity.this, AtyFruit.class);
                startActivity(intent4);
                break;
            case R.id.button5:
                Intent intent5 = new Intent(MainActivity.this, AtyChat.class);
                startActivity(intent5);
                break;
            case R.id.button6:
                Intent intent6 = new Intent(MainActivity.this, AtyNewsTitle.class);
                startActivity(intent6);
                break;
            case R.id.button7:
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                Notification notification = new Notification();

                long[] vibrates = {0, 1000, 1000, 1000};
                notification.vibrate = vibrates;
                notification.ledARGB = Color.GREEN;
                notification.ledOnMS = 1000;
                notification.ledOffMS = 1000;
                notification.flags = Notification.FLAG_SHOW_LIGHTS;
                notification.icon = R.drawable.ic_launcher;
                notification.tickerText = "我是一个提醒";
                notification.when = System.currentTimeMillis();
                Intent intent7 = new Intent(MainActivity.this, AtyNotification.class);
                PendingIntent Pi = PendingIntent.getActivity(MainActivity.this, 0, intent7, PendingIntent.FLAG_CANCEL_CURRENT);
                notification.setLatestEventInfo(MainActivity.this, "我是一个提醒", "内容是什么？", Pi);
                manager.notify(1, notification);
                break;
            case R.id.button8:
                Intent intent8 = new Intent(MainActivity.this, ServiceLongRunning.class);
                startService(intent8);
                break;
            default:
                break;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "lifecycling--------------";
        outState.putString("data_key", tempData);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    Toast.makeText(this, returnData, Toast.LENGTH_SHORT).show();
                }
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiverNetWorkChange);
    }
}

