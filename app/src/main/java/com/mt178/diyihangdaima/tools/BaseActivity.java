package com.mt178.diyihangdaima.tools;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.mt178.diyihangdaima.atys.AtyCollector;

/**
 * Created by llh on 2015/3/15.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity",getClass().getName());
        AtyCollector.addAty(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AtyCollector.removeAty(this);
    }
}
