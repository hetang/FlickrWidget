package com.hetangshah.flickrwidget.manager;

import com.hetangshah.flickrwidget.model.FlickrImageList;

import java.util.Map;

/**
 * Created by hetashah on 2/16/16.
 */
public class FlickrGetImageDataManager extends BaseDataManager<FlickrImageList> {

    private Observer instance;
    private Map<String, Object> params;

    public FlickrGetImageDataManager(Map<String, Object> params, Observer instance) {
        super();
        this.instance = instance;
        this.params = params;
    }

    public interface Observer {
        void notifyDataChanged(Map<String, Object> params, FlickrImageList instagramImageModel);
    }

    @Override
    public void notifyDataChanged(FlickrImageList instagramImageModel) {
        instance.notifyDataChanged(params, instagramImageModel);
    }
}
