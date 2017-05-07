package com.jpuyo.android.recyclerviewplayground.data.videolist.dto;

import com.google.gson.annotations.SerializedName;

public class VideoDto {

    @SerializedName("title")
    private String title;

    @SerializedName("thumbnail")
    private String thumbnail;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
