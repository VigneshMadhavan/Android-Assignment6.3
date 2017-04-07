package com.vigneshtraining.assignment63.model;

import android.graphics.Bitmap;

/**
 * Created by vimadhavan on 4/6/2017.
 */

public class ItemObject {
    private Integer thumb;
    private String title,description;

    public Integer getThumb() {
        return thumb;
    }

    public void setThumb(Integer thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
