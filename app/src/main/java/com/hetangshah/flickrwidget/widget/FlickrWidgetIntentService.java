package com.hetangshah.flickrwidget.widget;

import android.app.IntentService;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.RemoteViews;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.AppWidgetTarget;
import com.hetangshah.flickrwidget.FlickrActivity;
import com.hetangshah.flickrwidget.R;
import com.hetangshah.flickrwidget.api.FlickrGetImageAPI;
import com.hetangshah.flickrwidget.model.FlickrImage;
import com.hetangshah.flickrwidget.model.FlickrImageList;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by hetashah on 2/24/16.
 */
public class FlickrWidgetIntentService extends IntentService {

    public FlickrWidgetIntentService() {
        super("FlickrWidgetIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        FlickrGetImageAPI apiCall = new FlickrGetImageAPI();
        FlickrImageList flickrImageList = apiCall.execute();
        updateWidget(this, flickrImageList);
    }

    private static void updateWidget(Context context, FlickrImageList data) {

        ComponentName widget = new ComponentName(context, FlickrAppWidgetProvider.class);
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.instagram_widget);
        if (data != null && data.getData() != null && !data.getData().isEmpty()) {
            FlickrImage flickrImageModel = data.getData().get(0);
            hideEmptyView(views);
            views.setTextViewText(R.id.tvItemTitle, flickrImageModel.getCaption().getText());
            String imageUrl = flickrImageModel.getImages().getStandard_resolution() != null ?
                    flickrImageModel.getImages().getStandard_resolution().getUrl() :
                    flickrImageModel.getImages().getLow_resolution() != null ?
                            flickrImageModel.getImages().getLow_resolution().getUrl() : null;

            if(!StringUtils.isEmpty(imageUrl)) {
                AppWidgetTarget mAppWidgetTarget = new AppWidgetTarget(context, views, R.id.itemImage,
                        400, 400, widget) {
                };

                Glide.with(context)
                        .load(imageUrl)
                        .asBitmap()
                        .centerCrop()
                        .fitCenter()
                        .into(mAppWidgetTarget);
            }
            Intent intent = new Intent(context, FlickrActivity.class);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widget);  // Identifies the particular widget...
            //intent.putExtra(FlickrActivity.EXTRA_ITEM_INFO_KEY, data);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // Make the pending intent unique...
            intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
            PendingIntent pendIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            views.setOnClickPendingIntent(R.id.rlContentView, pendIntent);
        } else {
            showEmptyView(views);
        }
        manager.updateAppWidget(widget, views);
    }

    private static void showEmptyView(RemoteViews views) {
        views.setViewVisibility(R.id.rlContentView, View.GONE);
        views.setViewVisibility(R.id.rlEmptyView, View.VISIBLE);
    }

    private static void hideEmptyView(RemoteViews views) {
        views.setViewVisibility(R.id.rlEmptyView, View.GONE);
        views.setViewVisibility(R.id.rlContentView, View.VISIBLE);
    }
}
