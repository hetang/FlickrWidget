package com.hetangshah.flickrwidget.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Random;

/**
 * Implementation of App Widget functionality.
 */
public class FlickrAppWidgetProvider extends AppWidgetProvider {
    public static final String ACTION_UPDATE = "com.ebay.napp.widget.UPDATE";
    private static Random random = new Random();


    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        WidgetUtil.scheduleUpdate(context);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        context.startService(new Intent(context,FlickrWidgetIntentService.class));
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Toast.makeText(context, "TimeWidgetRemoved id(s):"+appWidgetIds, Toast.LENGTH_SHORT).show();
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        WidgetUtil.clearUpdate(context);
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context,
                                          AppWidgetManager appWidgetManager, int appWidgetId,
                                          Bundle newOptions) {
        int minWidth = newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH);
        int maxWidth = newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH);
        int minHeight = newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT);
        int maxHeight = newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT);
        //Do some operation here, once you see that the widget has change its size or position.
        //Toast.makeText(context, "onAppWidgetOptionsChanged() called: minWidth = " + minWidth + " maxWidth = " + maxWidth + " minHeight = " + minHeight + " maxHeight = " + maxHeight, Toast.LENGTH_SHORT).show();
    }
}

