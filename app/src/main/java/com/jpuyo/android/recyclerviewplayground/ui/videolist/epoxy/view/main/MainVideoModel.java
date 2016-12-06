package com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.main;

import android.util.Log;

import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.VideoModel;

public class MainVideoModel extends EpoxyModelWithHolder<MainVideoViewHolder> implements VideoModel {

    private static final String TAG = "Epoxy";

    private String title;
    private String thumbnail;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getThumbnail() {
        return thumbnail;
    }

    @Override
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    protected MainVideoViewHolder createNewHolder() {
        return new MainVideoViewHolder();
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.main_video_item;
    }

    @Override
    public void bind(MainVideoViewHolder mainVideoViewHolder) {
        Log.d(TAG, "Element set on unknown position");
        mainVideoViewHolder.bind(this);
    }
}