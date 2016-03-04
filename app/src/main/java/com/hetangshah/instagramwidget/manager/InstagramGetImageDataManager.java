package com.hetangshah.instagramwidget.manager;

import com.hetangshah.instagramwidget.model.InstagramImageList;

import java.util.Map;

/**
 * Created by hetashah on 2/16/16.
 */
public class InstagramGetImageDataManager extends BaseDataManager<InstagramImageList> {

    private Observer instance;
    private Map<String, Object> params;

    public InstagramGetImageDataManager(Map<String, Object> params, Observer instance) {
        super();
        this.instance = instance;
        this.params = params;
    }

    public interface Observer {
        void notifyDataChanged(Map<String, Object> params, InstagramImageList instagramImageModel);
    }

    @Override
    public void notifyDataChanged(InstagramImageList instagramImageModel) {
        instance.notifyDataChanged(params, instagramImageModel);
    }
}
