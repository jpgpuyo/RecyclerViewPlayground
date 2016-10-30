package com.jpuyo.android.recyclerviewplayground.recyclerview.ui.epoxy.viewholders;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyHolder;
import com.bumptech.glide.Glide;
import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.recyclerview.ui.epoxy.EpoxyVideoModel;

public class EpoxyVideoViewHolder extends EpoxyHolder {

    private static final String TAG = "Epoxy";

    private TextView tvTitle;
    private ImageView ivThumbnail;

    @Override
    protected void bindView(View itemView) {
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        ivThumbnail = (ImageView) itemView.findViewById(R.id.ivThumbnail);
    }

    public void bind(final EpoxyVideoModel videoModel) {
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
