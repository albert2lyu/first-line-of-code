package com.mt178.diyihangdaima.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by llh on 2015/3/17.
 */
public class ReceiverNetWorkChange extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connManage = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManage.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
            Toast.makeText(context, "netWork is avaliable~~~", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(context, "netWork is unavailable~~~", Toast.LENGTH_SHORT).show();
        }
    }
}
