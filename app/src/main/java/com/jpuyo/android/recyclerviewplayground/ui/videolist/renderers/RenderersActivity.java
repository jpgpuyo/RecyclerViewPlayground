package com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.data.videolist.dto.VideoDto;
import com.jpuyo.android.recyclerviewplayground.ui.common.activity.VideoListActivity;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.mapper.VideoModelDataMapper;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.view.VideoAdapter;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.view.VideoModel;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.view.VideoModelRendererBuilder;

import java.util.List;

import butterknife.BindView;

public class RenderersActivity extends VideoListActivity {

    @BindView(R.id.mainRecyclerView)
    RecyclerView mainRecyclerView;
    private VideoAdapter videoAdapter;

    @Override
    protected String getToolbarTitle() {
        return getResources().getString(R.string.renderers);
    }

    @Override
    protected void initAdapter() {
        videoAdapter = new VideoAdapter(new VideoModelRendererBuilder());

    }

    @Override
    protected void initRecyclerView() {
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainRecyclerView.setAdapter(videoAdapter);
    }

    @Override
    protected void onVideosLoaded(List<VideoDto> videos) {
        List<VideoModel> videoModelList = new VideoModelDataMapper().transform(videos);
        videoAdapter.renderVideoList(videoModelList);
    }
}
