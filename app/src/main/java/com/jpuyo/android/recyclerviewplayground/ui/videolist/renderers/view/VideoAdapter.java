package com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.view;

import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.List;

public class VideoAdapter extends RVRendererAdapter<VideoModel> {

    public VideoAdapter(RendererBuilder<VideoModel> rendererBuilder) {
        super(rendererBuilder);
    }

    public void renderVideoList(List<VideoModel> videoModelList) {
        setCollection(new ListAdapteeCollection<>(videoModelList));
        notifyDataSetChanged();
    }

}
