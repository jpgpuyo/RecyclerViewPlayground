package com.jpuyo.android.recyclerviewplayground.recyclerview.ui.renderers;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.common.activities.RecyclerViewActivity;
import com.jpuyo.android.recyclerviewplayground.data.VideoRepository;
import com.jpuyo.android.recyclerviewplayground.data.json.JsonReader;
import com.jpuyo.android.recyclerviewplayground.recyclerview.mapper.VideoModelDataMapper;
import com.jpuyo.android.recyclerviewplayground.recyclerview.model.VideoModel;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.List;

import butterknife.BindView;

public class RenderersActivity extends RecyclerViewActivity {

    @BindView(R.id.mainRecyclerView)
    RecyclerView mainRecyclerView;
    private RenderersAdapter renderersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initAdapter();
        initRecyclerView();

        List<VideoModel> videoModelList = retrieveVideoList();
        renderersAdapter.renderVideoList(videoModelList);
    }

    private void initAdapter() {
        Renderer<VideoModel> renderer = new VideoModelRenderer();
        RendererBuilder<VideoModel> rendererBuilder = new RendererBuilder(renderer);
        renderersAdapter = new RenderersAdapter(rendererBuilder);

    }

    private void initRecyclerView() {
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainRecyclerView.setAdapter(renderersAdapter);
    }

    private List<VideoModel> retrieveVideoList() {
        VideoRepository videoRepository = new VideoRepository(new JsonReader(this));
        List<VideoModel> videoModelList = new VideoModelDataMapper().transform(videoRepository.getVideos());
        return videoModelList;
    }
}
