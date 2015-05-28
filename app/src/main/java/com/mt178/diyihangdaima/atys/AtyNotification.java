package com.mt178.diyihangdaima.atys;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;

import com.mt178.diyihangdaima.tools.BaseActivity;
import com.mt178.diyihangdaima.R;

/**
 * Created by llh on 2015/3/19.
 */
public class AtyNotification extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_layout);
        NotificationManager manager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(1);
    }
}
