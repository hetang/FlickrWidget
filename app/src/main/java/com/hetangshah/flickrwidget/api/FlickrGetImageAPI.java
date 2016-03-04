package com.hetangshah.flickrwidget.api;

import android.util.Log;

import com.google.gson.Gson;
import com.hetangshah.flickrwidget.model.FlickrImageList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hetashah on 2/19/16.
 */
public class FlickrGetImageAPI extends APIDetails<FlickrImageList> {

    public FlickrGetImageAPI() {
    }

    private String getURL() {
        return ApiUrlEnum.INSTAGRAM.getURL();
    }

    @Override
    public FlickrImageList execute() {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        FlickrImageList instagramImageModel = null;
        try {

            request = new Request.Builder()
                    .headers(this.buildHeaderMap())
                    .url(this.buildURL(getURL(), null))
                    .build();

            Response response = client.newCall(request).execute();
            String responseStr = response.body().string();
            Log.d("FlickrGetImageAPI", "Response = " + responseStr);
            instagramImageModel = gson.fromJson(responseStr, FlickrImageList.class);

        } catch (Exception e) {
            Log.e("FlickrGetImageAPI", "execute method", e);
        }

        return instagramImageModel;
    }

    @Override
    public String getId() {
        return null;
    }
}
