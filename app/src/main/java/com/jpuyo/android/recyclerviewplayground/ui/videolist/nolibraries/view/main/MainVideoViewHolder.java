package com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.view.main;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.view.VideoModel;

public class MainVideoViewHolder extends RecyclerView.ViewHolder{

    private static final String TAG = "NoLibraries";

    private TextView tvTitle;
    private ImageView ivThumbnail;

    public MainVideoViewHolder(View itemView) {
        super(itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        ivThumbnail = (ImageView) itemView.findViewById(R.id.ivThumbnail);
    }

    public void render(final VideoModel videoModel) {
        tvTitle.setText(videoModel.getTitle());
        Glide.with(ivThumbnail.getContext())
                .load(videoModel.getThumbnail())
                .placeholder(R.drawable.placeholder)
                .into(ivThumbnail);
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked title: " + videoModel.getTitle());
            }
        });
        ivThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked thumbnail: " + videoModel.getThumbnail());
            }
        });
    }
}
