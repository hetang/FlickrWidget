package com.hetangshah.flickrwidget.api;

import com.hetangshah.flickrwidget.BuildConfig;

/**
 * Created by hetang on 1/31/16.
 */
public enum ApiUrlEnum {

    INSTAGRAM("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=c110ace9d671efab3e24e041e3de7796&format=json&nojsoncallback=1&text=cats&extras=url_o","https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=c110ace9d671efab3e24e041e3de7796&format=json&nojsoncallback=1&text=cats&extras=url_o");

    String stagingURL;
    String productionURL;

    ApiUrlEnum(String stagingURL, String productionURL) {
        this.stagingURL = stagingURL;
        this.productionURL = productionURL;
    }

    public String getStagingURL() {
        return stagingURL;
    }

    public String getProductionURL() {
        return productionURL;
    }

    public String getURL() {
        if(BuildConfig.DEBUG) {
            return getStagingURL();
        } else {
            return getProductionURL();
        }
    }
}
