package com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.data.videolist.dto.VideoDto;
import com.jpuyo.android.recyclerviewplayground.ui.common.activity.VideoListActivity;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.mapper.VideoModelDataMapper;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.view.VideoAdapter;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.view.VideoModel;

import java.util.List;

import butterknife.BindView;

public class NoLibrariesActivity extends VideoListActivity {

    private VideoAdapter videoAdapter;

    @BindView(R.id.mainRecyclerView)
    RecyclerView mainRecyclerView;

    @Override
    protected String getToolbarTitle() {
        return getResources().getString(R.string.no_libraries);
    }

    @Override
    protected void initAdapter() {
        videoAdapter = new VideoAdapter();
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
