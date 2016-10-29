package com.jpuyo.android.recyclerviewplayground.recyclerview.ui.nolibraries;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.common.activities.RecyclerViewActivity;
import com.jpuyo.android.recyclerviewplayground.data.VideoRepository;
import com.jpuyo.android.recyclerviewplayground.data.json.JsonReader;
import com.jpuyo.android.recyclerviewplayground.recyclerview.mapper.VideoModelDataMapper;
import com.jpuyo.android.recyclerviewplayground.recyclerview.model.VideoModel;

import java.util.List;

import butterknife.BindView;

public class NoLibrariesActivity extends RecyclerViewActivity {

    private NoLibrariesAdapter noLibrariesAdapter;

    @BindView(R.id.mainRecyclerView)
    RecyclerView mainRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAdapter();
        initRecyclerView();

        List<VideoModel> videoModelList = retrieveVideoList();
        noLibrariesAdapter.renderVideoList(videoModelList);
    }

    private void initAdapter() {
        noLibrariesAdapter = new NoLibrariesAdapter();
    }

    private void initRecyclerView() {
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainRecyclerView.setAdapter(noLibrariesAdapter);
    }

    private List<VideoModel> retrieveVideoList() {
        VideoRepository videoRepository = new VideoRepository(new JsonReader(this));
        List<VideoModel> videoModelList = new VideoModelDataMapper().transform(videoRepository.getVideos());
        return videoModelList;
    }
}
