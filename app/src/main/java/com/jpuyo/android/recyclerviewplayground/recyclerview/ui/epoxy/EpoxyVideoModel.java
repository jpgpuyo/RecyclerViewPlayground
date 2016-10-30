package com.jpuyo.android.recyclerviewplayground.recyclerview.ui.epoxy;

import android.util.Log;

import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.recyclerview.ui.epoxy.viewholders.EpoxyVideoViewHolder;

public class EpoxyVideoModel extends EpoxyModelWithHolder<EpoxyVideoViewHolder> {

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
    protected EpoxyVideoViewHolder createNewHolder() {
        return new EpoxyVideoViewHolder();
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.video_item;
    }

    @Override
    public void bind(EpoxyVideoViewHolder videoViewHolder) {
        Log.d(TAG, "Element set on unknown position");
        videoViewHolder.bind(this);
    }
}