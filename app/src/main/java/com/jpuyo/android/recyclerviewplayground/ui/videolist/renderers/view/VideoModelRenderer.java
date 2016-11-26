/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.view;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jpuyo.android.recyclerviewplayground.R;
import com.pedrogomez.renderers.Renderer;

import butterknife.BindView;
import butterknife.OnClick;

public abstract class VideoModelRenderer extends Renderer<VideoModel> {

    private static final String TAG = "Renderers";

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.ivThumbnail)
    ImageView ivThumbnail;

    //If you don't use ButterKnife you have to implement setUpView and hookListeners.

    /**
     * Maps all the view elements from the xml declaration to members of this renderer.
     */
    @Override
    protected void setUpView(View rootView) {
        /*
         * Empty implementation substituted with the usage of ButterKnife library by Jake Wharton.
         */
    }

    /**
     * Insert external listeners in some widgets.
     */
    @Override
    protected void hookListeners(View rootView) {
        /*
         * Empty implementation substituted with the usage of ButterKnife library by Jake Wharton.
         */
    }

    @Override
    public void render() {
        VideoModel videoModel = getContent();
        Log.d(TAG, "Element set on unknown position");

        tvTitle.setText(videoModel.getTitle());
        Glide.with(ivThumbnail.getContext())
                .load(videoModel.getThumbnail())
                .placeholder(R.drawable.placeholder)
                .into(ivThumbnail);
    }

    @OnClick(R.id.tvTitle)
    void onVideoModelTitleClicked() {
        VideoModel videoModel = getContent();
        Log.d(TAG, "Clicked title: " + videoModel.getTitle());
    }

    @OnClick(R.id.ivThumbnail)
    void onVideoModelThumbnailClicked() {
        VideoModel videoModel = getContent();
        Log.d(TAG, "Clicked thumbnail: " + videoModel.getThumbnail());
    }
}
