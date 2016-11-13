package com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view;

import com.airbnb.epoxy.EpoxyAdapter;

import java.util.List;

public class VideoAdapter extends EpoxyAdapter {

    public void renderVideoList(List<VideoModel> videoModelList) {
        addModels(videoModelList);
    }
}
