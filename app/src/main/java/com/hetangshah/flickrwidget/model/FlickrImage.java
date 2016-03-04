package com.hetangshah.flickrwidget.model;

/**
 * Created by hetashah on 2/20/16.
 */
public class FlickrImage {
    String id;
    Caption caption;
    Images images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Caption getCaption() {
        return caption;
    }

    public void setCaption(Caption caption) {
        this.caption = caption;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public class Images {
        Image low_resolution;
        Image thumbnail;
        Image standard_resolution;

        public Image getLow_resolution() {
            return low_resolution;
        }

        public void setLow_resolution(Image low_resolution) {
            this.low_resolution = low_resolution;
        }

        public Image getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Image thumbnail) {
            this.thumbnail = thumbnail;
        }

        public Image getStandard_resolution() {
            return standard_resolution;
        }

        public void setStandard_resolution(Image standard_resolution) {
            this.standard_resolution = standard_resolution;
        }
    }

    public class Image{
        String url;
        int width;
        int height;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    public class Caption {
        String text;
        String created_time;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCreated_time() {
            return created_time;
        }

        public void setCreated_time(String created_time) {
            this.created_time = created_time;
        }
    }
}
