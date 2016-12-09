package com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.ui.common.activity.RecyclerViewActivity;
import com.jpuyo.android.recyclerviewplayground.data.videolist.VideoRepository;
import com.jpuyo.android.recyclerviewplayground.data.common.JsonReader;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.mapper.VideoModelDataMapper;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.view.VideoModel;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.view.VideoAdapter;

import java.util.List;

import butterknife.BindView;

public class NoLibrariesActivity extends RecyclerViewActivity {

    private VideoAdapter videoAdapter;

    @BindView(R.id.mainRecyclerView)
    RecyclerView mainRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAdapter();
        initRecyclerView();

        List<VideoModel> videoModelList = retrieveVideoList();
        videoAdapter.renderVideoList(videoModelList);
    }

    @Override
    public String getToolbarTitle() {
        return getResources().getString(R.string.no_libraries);
    }

    private void initAdapter() {
        videoAdapter = new VideoAdapter();
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
