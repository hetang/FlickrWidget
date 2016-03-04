package com.hetangshah.flickrwidget.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * Created by hetashah on 2/16/16.
 */
public class WidgetUtil {
    public static void scheduleUpdate(Context context) {
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
//        String interval = prefs.getString(SettingsActivity.INTERVAL_PREF, null);
        String interval = "1";
        long intervalMillis = Integer.parseInt(interval)*60*1000;

        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, FlickrWidgetIntentReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 100 * 3, intervalMillis, pi);
    }

    private static PendingIntent getAlarmIntent(Context context) {
        Intent intent = new Intent(context, FlickrAppWidgetProvider.class);
        intent.setAction(FlickrAppWidgetProvider.ACTION_UPDATE);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        return pi;
    }

    public static void clearUpdate(Context context) {
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.cancel(getAlarmIntent(context));
    }
}
