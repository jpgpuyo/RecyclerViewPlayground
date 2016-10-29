package com.jpuyo.android.recyclerviewplayground.recyclerview.ui.nolibraries.viewholders;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.recyclerview.model.VideoModel;

public class VideoViewHolder extends RecyclerView.ViewHolder{

    private TextView tvTitle;
    private ImageView ivThumbnail;

    public VideoViewHolder(View itemView) {
        super(itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        ivThumbnail = (ImageView) itemView.findViewById(R.id.ivThumbnail);
    }

    public void bind(VideoModel videoModel) {
        tvTitle.setText(videoModel.getTitle());
        Glide.with(ivThumbnail.getContext())
                .load(videoModel.getThumbnail())
                .placeholder(R.drawable.placeholder)
                .into(ivThumbnail);
    }
}
