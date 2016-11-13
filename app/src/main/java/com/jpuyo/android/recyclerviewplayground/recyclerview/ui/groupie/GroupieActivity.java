package com.jpuyo.android.recyclerviewplayground.recyclerview.ui.groupie;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.common.activities.RecyclerViewActivity;
import com.jpuyo.android.recyclerviewplayground.data.VideoRepository;
import com.jpuyo.android.recyclerviewplayground.data.json.JsonReader;
import com.jpuyo.android.recyclerviewplayground.recyclerview.mapper.groupie.GroupieVideoModelDataMapper;

import java.util.List;

import butterknife.BindView;

public class GroupieActivity extends RecyclerViewActivity {

    private GroupieAdapter groupieAdapter;

    @BindView(R.id.mainRecyclerView)
    RecyclerView mainRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAdapter();
        initRecyclerView();

        List<GroupieVideoModel> videoModelList = retrieveVideoList();
        groupieAdapter.renderVideoList(videoModelList);
    }

    private void initAdapter() {
        groupieAdapter = new GroupieAdapter();
    }

    private void initRecyclerView() {
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainRecyclerView.setAdapter(groupieAdapter);
    }

    private List<GroupieVideoModel> retrieveVideoList() {
        VideoRepository videoRepository = new VideoRepository(new JsonReader(this));
        List<GroupieVideoModel> videoModelList = new GroupieVideoModelDataMapper().transform(videoRepository.getVideos());
        return videoModelList;
    }
}
