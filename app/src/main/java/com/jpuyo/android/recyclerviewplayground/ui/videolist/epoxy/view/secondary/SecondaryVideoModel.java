package com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.secondary;

import android.util.Log;

import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.VideoModel;

public class SecondaryVideoModel extends EpoxyModelWithHolder<SecondaryVideoViewHolder> implements VideoModel {

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
    protected SecondaryVideoViewHolder createNewHolder() {
        return new SecondaryVideoViewHolder();
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.secondary_video_item;
    }

    @Override
    public void bind(SecondaryVideoViewHolder secondaryVideoViewHolder) {
        Log.d(TAG, "Element set on unknown position");
        secondaryVideoViewHolder.bind(this);
    }
}