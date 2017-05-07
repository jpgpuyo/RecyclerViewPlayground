package com.jpuyo.android.recyclerviewplayground.ui.common.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.data.videolist.VideosProvider;
import com.jpuyo.android.recyclerviewplayground.data.videolist.dto.VideoDto;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class VideoListActivity extends AppCompatActivity {

    @BindView(R.id.mainRecyclerView)
    RecyclerView mainRecyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        setupToolbar();
        initAdapter();
        initRecyclerView();
        loadVideos();
    }

    private void loadVideos() {
        List<VideoDto> videos = VideosProvider.getVideos(this);
        onVideosLoaded(videos);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        setTitle(getToolbarTitle());
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected abstract String getToolbarTitle();
    protected abstract void initAdapter();
    protected abstract void initRecyclerView();
    protected abstract void onVideosLoaded(List<VideoDto> videos);


}
