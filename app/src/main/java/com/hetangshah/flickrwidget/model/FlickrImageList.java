package com.hetangshah.flickrwidget.model;

import java.util.List;

/**
 * Created by hetashah on 2/23/16.
 */
public class FlickrImageList {
    Meta meta;
    List<FlickrImage> data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<FlickrImage> getData() {
        return data;
    }

    public void setData(List<FlickrImage> data) {
        this.data = data;
    }

    private class Meta {
        int code;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}
