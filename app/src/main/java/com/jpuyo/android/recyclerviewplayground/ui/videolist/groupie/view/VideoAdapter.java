package com.jpuyo.android.recyclerviewplayground.ui.videolist.groupie.view;

import com.genius.groupie.GroupAdapter;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.groupie.view.main.MainVideoModel;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.groupie.view.secondary.SecondaryVideoModel;

import java.util.List;

public class VideoAdapter extends GroupAdapter {

    public VideoAdapter() {
    }

    public void renderVideoList(MainVideoModel mainVideoModel, List<SecondaryVideoModel> secondaryVideoModelList) {
        add(mainVideoModel);
        for (SecondaryVideoModel secondaryVideoModel : secondaryVideoModelList) {
            add(secondaryVideoModel);
        }
    }
}
