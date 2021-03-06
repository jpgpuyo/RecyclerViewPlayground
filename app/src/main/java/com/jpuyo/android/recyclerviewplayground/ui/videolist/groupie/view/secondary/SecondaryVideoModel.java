package com.jpuyo.android.recyclerviewplayground.ui.videolist.groupie.view.secondary;

import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.genius.groupie.Item;
import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.databinding.GroupieSecondaryVideoItemBinding;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.groupie.view.VideoModel;

public class SecondaryVideoModel extends Item<GroupieSecondaryVideoItemBinding> implements VideoModel {

    private static final String TAG = "Groupie";

    private String title;
    private String thumbnail;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getThumbnail() {
        return thumbnail;
    }

    @Override
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public int getLayout() {
        return R.layout.groupie_secondary_video_item;
    }

    @Override
    public void bind(final GroupieSecondaryVideoItemBinding viewBinding, int position) {
        Log.d(TAG, "Element " + position + " set.");

        viewBinding.tvTitle.setText(title);
        Glide.with(viewBinding.ivThumbnail.getContext())
                .load(thumbnail)
                .placeholder(R.drawable.placeholder)
                .into(viewBinding.ivThumbnail);
        viewBinding.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked title: " + title);
            }
        });
        viewBinding.ivThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked thumbnail: " + thumbnail);
            }
        });
    }
}