package com.jpuyo.android.recyclerviewplayground.recyclerview.ui.epoxy;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.common.activities.RecyclerViewActivity;
import com.jpuyo.android.recyclerviewplayground.data.VideoRepository;
import com.jpuyo.android.recyclerviewplayground.data.json.JsonReader;
import com.jpuyo.android.recyclerviewplayground.recyclerview.mapper.epoxy.EpoxyVideoModelDataMapper;

import java.util.List;

import butterknife.BindView;

public class EpoxyActivity extends RecyclerViewActivity {

    private EpoxyVideoAdapter epoxyVideoAdapter;

    @BindView(R.id.mainRecyclerView)
    RecyclerView mainRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAdapter();
        initRecyclerView();

        List<EpoxyVideoModel> videoModelList = retrieveVideoList();
        epoxyVideoAdapter.renderVideoList(videoModelList);
    }

    private void initAdapter() {
        epoxyVideoAdapter = new EpoxyVideoAdapter();
    }

    private void initRecyclerView() {
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainRecyclerView.setAdapter(epoxyVideoAdapter);
    }

    private List<EpoxyVideoModel> retrieveVideoList() {
        VideoRepository videoRepository = new VideoRepository(new JsonReader(this));
        List<EpoxyVideoModel> videoModelList = new EpoxyVideoModelDataMapper().transform(videoRepository.getVideos());
        return videoModelList;
    }
}
