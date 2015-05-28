package com.mt178.diyihangdaima.Service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.provider.AlarmClock;
import android.util.Log;

import com.mt178.diyihangdaima.Receivers.ReceiverAlarm;

import java.util.Date;

/**
 * Created by llh on 2015/3/19.
 */
public class ServiceLongRunning extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("LongRunningService", "executed at " + new Date().toString());
            }
        }).start();
        AlarmManager manager= (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int hour=10*1000;
        long  tiggerAtTime= SystemClock.elapsedRealtime()+hour;
        Intent i=new Intent(this, ReceiverAlarm.class);
        PendingIntent pi=PendingIntent.getBroadcast(this,0,i,PendingIntent.FLAG_CANCEL_CURRENT);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,tiggerAtTime,pi);
        stopSelf();
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }
}
