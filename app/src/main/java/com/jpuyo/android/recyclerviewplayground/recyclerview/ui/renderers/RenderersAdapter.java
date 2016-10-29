package com.jpuyo.android.recyclerviewplayground.recyclerview.ui.renderers;

import com.jpuyo.android.recyclerviewplayground.recyclerview.model.VideoModel;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.List;

/**
 * Created by usuario on 29/10/2016.
 */
public class RenderersAdapter extends RVRendererAdapter<VideoModel> {

    public RenderersAdapter(RendererBuilder<VideoModel> rendererBuilder) {
        super(rendererBuilder);
    }

    public void renderVideoList(List<VideoModel> videoModelList) {
        setCollection(new ListAdapteeCollection<>(videoModelList));
        notifyDataSetChanged();
    }

}
