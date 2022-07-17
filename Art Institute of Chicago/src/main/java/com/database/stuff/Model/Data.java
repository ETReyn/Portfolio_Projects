package com.database.stuff.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    private String id;
    private String title;
    @JsonProperty("image_id")
    private String imageId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imageId='" + imageId + '\'' +
                '}';
    }
}
