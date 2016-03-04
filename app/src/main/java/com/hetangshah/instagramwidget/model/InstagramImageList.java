package com.hetangshah.instagramwidget.model;

import java.util.List;

/**
 * Created by hetashah on 2/23/16.
 */
public class InstagramImageList {
    Meta meta;
    List<InstagramImage> data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<InstagramImage> getData() {
        return data;
    }

    public void setData(List<InstagramImage> data) {
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
