package com.mt178.diyihangdaima.atys;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by llh on 2015/3/15.
 */
public class AtyCollector {
    public static List<Activity> activityList = new ArrayList<Activity>();

    public static void addAty(Activity activity) {
        activityList.add(activity);
    }

    public static void removeAty(Activity activity) {
        activityList.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
