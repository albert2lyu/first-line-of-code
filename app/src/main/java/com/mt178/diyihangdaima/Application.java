package com.mt178.diyihangdaima;

import com.activeandroid.ActiveAndroid;

/**
 * Created by llh on 2015/4/21.
 */
public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }
}
