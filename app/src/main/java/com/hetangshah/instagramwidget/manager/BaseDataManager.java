package com.hetangshah.instagramwidget.manager;

import android.os.AsyncTask;

import com.hetangshah.instagramwidget.api.APIDetails;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hetang on 1/17/16.
 */
public abstract class BaseDataManager<T> {
    private BaseAsyncTask task;
    private APIDetails<T> api;

    private Map<String, T> cacheData = new HashMap<String, T>();
    public BaseDataManager() {

    }

    public void fetchData(APIDetails<T> api) {
        T data = cacheData.get(api.getId());
        if(data != null) {
            notifyDataChanged(data);
            return;
        }
        this.api = api;
        task = new BaseAsyncTask();
        task.execute(api);
    }

    public void forceRefresh(APIDetails<T> api) {
        this.api = api;
        task = new BaseAsyncTask();
        task.execute(api);
    }

    public abstract void notifyDataChanged(T t);

    private class BaseAsyncTask extends AsyncTask<APIDetails<T>, Void, T> {

        @Override
        protected T doInBackground(APIDetails<T>... params) {
            T result = null;
            if(params != null && params.length > 0) {
                APIDetails<T> api = params[0];
                result = api.execute();
            }
            return result;
        }

        @Override
        protected void onPostExecute(T t) {
            super.onPostExecute(t);
            updateDataSet(this, t);
        }
    }

    private void updateDataSet(BaseAsyncTask baseAsyncTask, T t) {
        baseAsyncTask = null;
        cacheData.put(api.getId(), t);
        notifyDataChanged(t);
    }
}
