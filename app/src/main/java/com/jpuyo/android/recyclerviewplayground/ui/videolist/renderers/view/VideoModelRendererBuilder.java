package com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.view;

import com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.view.main.MainVideoRenderer;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.view.secondary.SecondaryVideoRenderer;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.LinkedList;
import java.util.List;

public class VideoModelRendererBuilder extends RendererBuilder<VideoModel> {

    public VideoModelRendererBuilder() {
        List<Renderer<VideoModel>> prototypes = getVideoRendererPrototypes();
        setPrototypes(prototypes);
    }

    /**
     * Method to declare VideoModel-VideoModelRenderer mapping.
     *
     * @param videoModel used to map object-renderers.
     * @return VideoModelRenderer subtype class.
     */
    @Override
    protected Class getPrototypeClass(VideoModel videoModel) {
        Class prototypeClass;
        if (videoModel.isMainVideo()) {
            prototypeClass = MainVideoRenderer.class;
        } else if (videoModel.isSecondaryVideo()) {
            prototypeClass = SecondaryVideoRenderer.class;
        } else {
            prototypeClass = SecondaryVideoRenderer.class;
        }
        return prototypeClass;
    }

    /**
     * Create a list of prototypes to configure RendererBuilder.
     * The list of Renderer<VideoModel> that contains all the possible renderers that our RendererBuilder
     * is going to use.
     *
     * @return Renderer<VideoModel> prototypes for RendererBuilder.
     */
    private List<Renderer<VideoModel>> getVideoRendererPrototypes() {
        List<Renderer<VideoModel>> prototypes = new LinkedList<>();
        prototypes.add(new MainVideoRenderer());
        prototypes.add(new SecondaryVideoRenderer());
        return prototypes;
    }
}