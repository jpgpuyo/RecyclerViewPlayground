package com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.data.videolist.dto.VideoDto;
import com.jpuyo.android.recyclerviewplayground.ui.common.activity.RecyclerViewActivity;
import com.jpuyo.android.recyclerviewplayground.data.videolist.VideoRepository;
import com.jpuyo.android.recyclerviewplayground.data.common.JsonReader;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.VideoAdapter;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.mapper.VideoModelDataMapper;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.VideoModel;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.main.MainVideoModel;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.secondary.SecondaryVideoModel;

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

        List<VideoDto> videoDtoList = retrieveVideoList();
        VideoModelDataMapper videoModelDataMapper = new VideoModelDataMapper();
        MainVideoModel mainVideoModel = videoModelDataMapper.transformToMainVideoModel(videoDtoList);
        List<SecondaryVideoModel> secondaryVideoModelList = videoModelDataMapper.transformToSecondaryVideoModelList(videoDtoList);
        videoAdapter.renderVideoList(mainVideoModel, secondaryVideoModelList);
    }

    private void initAdapter() {
        videoAdapter = new VideoAdapter();
    }

    private void initRecyclerView() {
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainRecyclerView.setAdapter(videoAdapter);
    }

    private List<VideoDto> retrieveVideoList() {
        VideoRepository videoRepository = new VideoRepository(new JsonReader(this));
        return videoRepository.getVideos();
    }
}
