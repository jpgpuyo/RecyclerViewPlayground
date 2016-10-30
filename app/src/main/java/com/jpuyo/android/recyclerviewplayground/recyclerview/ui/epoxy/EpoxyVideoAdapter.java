package com.jpuyo.android.recyclerviewplayground.recyclerview.ui.epoxy;

import com.airbnb.epoxy.EpoxyAdapter;

import java.util.List;

public class EpoxyVideoAdapter extends EpoxyAdapter {

    public void renderVideoList(List<EpoxyVideoModel> videoModelList) {
        addModels(videoModelList);
    }
}
