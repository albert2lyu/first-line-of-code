package com.mt178.diyihangdaima.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by llh on 2015/3/17.
 */
public class ReceiverBootComplete extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"llh----手机开机啦~~",Toast.LENGTH_SHORT).show();
    }
}
