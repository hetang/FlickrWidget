package com.hetangshah.flickrwidget.api;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;

/**
 * Created by hetang on 1/17/16.
 */
public abstract class APIDetails<T> {
    public Request request = null;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public APIDetails() {
    }

    protected String buildURL(String apiURL, Map<String, String> queryParam) {
        String url = null;
        if(!StringUtils.isEmpty(apiURL)) {
            url = apiURL;

            if (queryParam != null) {
                HttpUrl.Builder urlBuilder = HttpUrl.parse(apiURL).newBuilder();
                Iterator mapIterator = queryParam.entrySet().iterator();
                while (mapIterator.hasNext()) {
                    Map.Entry<String, String> pair = (Map.Entry) mapIterator.next();
                    urlBuilder.addQueryParameter(pair.getKey(), pair.getValue());
                }
                url = urlBuilder.build().toString();
            }
        }

        return url;
    }

    protected Headers buildHeaderMap() {
        Map<String, String> headers = new HashMap<String, String>();
        // Needs to add Request Header here
        return Headers.of(headers);
    }

    public abstract T execute();

    public abstract String getId();
}
