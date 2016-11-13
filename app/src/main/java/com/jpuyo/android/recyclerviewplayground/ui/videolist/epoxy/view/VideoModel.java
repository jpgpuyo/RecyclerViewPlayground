package com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view;

import android.util.Log;

import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.jpuyo.android.recyclerviewplayground.R;

public class VideoModel extends EpoxyModelWithHolder<VideoViewHolder> {

    private static final String TAG = "Epoxy";

    private String title;
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

    @Override
    protected VideoViewHolder createNewHolder() {
        return new VideoViewHolder();
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.video_item;
    }

    @Override
    public void bind(VideoViewHolder videoViewHolder) {
        Log.d(TAG, "Element set on unknown position");
        videoViewHolder.bind(this);
    }
}