package com.jpuyo.android.recyclerviewplayground.ui.videolist.groupie;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.data.videolist.dto.VideoDto;
import com.jpuyo.android.recyclerviewplayground.ui.common.activity.VideoListActivity;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.groupie.mapper.VideoModelDataMapper;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.groupie.view.VideoAdapter;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.groupie.view.main.MainVideoModel;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.groupie.view.secondary.SecondaryVideoModel;

import java.util.List;

import butterknife.BindView;

public class GroupieActivity extends VideoListActivity {

    private VideoAdapter videoAdapter;

    @BindView(R.id.mainRecyclerView)
    RecyclerView mainRecyclerView;

    @Override
    protected String getToolbarTitle() {
        return getResources().getString(R.string.groupie);
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
        VideoModelDataMapper videoModelDataMapper = new VideoModelDataMapper();
        MainVideoModel mainVideoModel = videoModelDataMapper.transformToMainVideoModel(videos);
        List<SecondaryVideoModel> secondaryVideoModelList = videoModelDataMapper.transformToSecondaryVideoModelList(videos);

        videoAdapter.renderVideoList(mainVideoModel, secondaryVideoModelList);
    }
}
