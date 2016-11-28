package com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view;

import com.airbnb.epoxy.EpoxyAdapter;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.main.MainVideoModel;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.secondary.SecondaryVideoModel;

import java.util.List;

public class VideoAdapter extends EpoxyAdapter {

    public void renderVideoList(MainVideoModel mainVideoModel, List<SecondaryVideoModel> secondaryVideoModels) {
        addModel(mainVideoModel);
        addModels(secondaryVideoModels);
    }
}
