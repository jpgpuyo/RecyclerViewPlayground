package com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.view;

public class VideoModel {
    private String title;
    private String thumbnail;
    private boolean isMainVideo;
    private boolean isSecondaryVideo;

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

    public boolean isMainVideo() {
        return isMainVideo;
    }

    public void setMainVideo(boolean mainVideo) {
        isMainVideo = mainVideo;
    }

    public boolean isSecondaryVideo() {
        return isSecondaryVideo;
    }

    public void setSecondaryVideo(boolean secondaryVideo) {
        isSecondaryVideo = secondaryVideo;
    }
}
