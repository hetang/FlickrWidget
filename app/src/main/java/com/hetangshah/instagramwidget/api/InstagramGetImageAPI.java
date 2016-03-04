package com.hetangshah.instagramwidget.api;

import android.util.Log;

import com.google.gson.Gson;
import com.hetangshah.instagramwidget.model.InstagramImageList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hetashah on 2/19/16.
 */
public class InstagramGetImageAPI extends APIDetails<InstagramImageList> {

    public InstagramGetImageAPI() {
    }

    private String getURL() {
        return ApiUrlEnum.INSTAGRAM.getURL();
    }

    @Override
    public InstagramImageList execute() {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        InstagramImageList instagramImageModel = null;
        try {

            request = new Request.Builder()
                    .headers(this.buildHeaderMap())
                    .url(this.buildURL(getURL(), null))
                    .build();

            Response response = client.newCall(request).execute();
            String responseStr = response.body().string();
            Log.d("InstagramGetImageAPI", "Response = " + responseStr);
            instagramImageModel = gson.fromJson(responseStr, InstagramImageList.class);

        } catch (Exception e) {
            Log.e("InstagramGetImageAPI", "execute method", e);
        }

        return instagramImageModel;
    }

    @Override
    public String getId() {
        return null;
    }
}
