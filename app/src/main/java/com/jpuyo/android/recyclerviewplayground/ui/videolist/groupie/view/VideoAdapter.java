package com.jpuyo.android.recyclerviewplayground.ui.videolist.groupie.view;

import com.genius.groupie.GroupAdapter;

import java.util.List;

public class VideoAdapter extends GroupAdapter {

    public VideoAdapter() {
    }

    public void renderVideoList(List<VideoModel> videoModelList) {
        for (VideoModel videoModel : videoModelList) {
            add(videoModel);
        }
    }
}
