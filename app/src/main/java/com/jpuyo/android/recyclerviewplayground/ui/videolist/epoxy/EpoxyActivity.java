package com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.data.videolist.dto.VideoDto;
import com.jpuyo.android.recyclerviewplayground.ui.common.activity.VideoListActivity;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.mapper.VideoModelDataMapper;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.VideoAdapter;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.main.MainVideoModel;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.secondary.SecondaryVideoModel;

import java.util.List;

import butterknife.BindView;

public class EpoxyActivity extends VideoListActivity {

    private VideoAdapter videoAdapter;

    @BindView(R.id.mainRecyclerView)
    RecyclerView mainRecyclerView;

    @Override
    public String getToolbarTitle() {
        return getResources().getString(R.string.epoxy);
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
