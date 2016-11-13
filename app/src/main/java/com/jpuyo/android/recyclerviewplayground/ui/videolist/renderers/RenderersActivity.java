package com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.ui.common.activity.RecyclerViewActivity;
import com.jpuyo.android.recyclerviewplayground.data.videolist.VideoRepository;
import com.jpuyo.android.recyclerviewplayground.data.common.JsonReader;

import com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.view.VideoAdapter;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.mapper.VideoModelDataMapper;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.view.VideoModel;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.view.VideoModelRenderer;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.List;

import butterknife.BindView;

public class RenderersActivity extends RecyclerViewActivity {

    @BindView(R.id.mainRecyclerView)
    RecyclerView mainRecyclerView;
    private VideoAdapter videoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initAdapter();
        initRecyclerView();

        List<VideoModel> videoModelList = retrieveVideoList();
        videoAdapter.renderVideoList(videoModelList);
    }

    private void initAdapter() {
        Renderer<VideoModel> renderer = new VideoModelRenderer();
        RendererBuilder<VideoModel> rendererBuilder = new RendererBuilder(renderer);
        videoAdapter = new VideoAdapter(rendererBuilder);

    }

    private void initRecyclerView() {
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainRecyclerView.setAdapter(videoAdapter);
    }

    private List<VideoModel> retrieveVideoList() {
        VideoRepository videoRepository = new VideoRepository(new JsonReader(this));
        List<VideoModel> videoModelList = new VideoModelDataMapper().transform(videoRepository.getVideos());
        return videoModelList;
    }
}