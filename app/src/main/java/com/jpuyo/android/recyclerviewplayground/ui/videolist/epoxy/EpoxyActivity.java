package com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.ui.common.activity.RecyclerViewActivity;
import com.jpuyo.android.recyclerviewplayground.data.videolist.VideoRepository;
import com.jpuyo.android.recyclerviewplayground.data.common.JsonReader;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.VideoAdapter;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.mapper.VideoModelDataMapper;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.VideoModel;

import java.util.List;

import butterknife.BindView;

public class EpoxyActivity extends RecyclerViewActivity {

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
