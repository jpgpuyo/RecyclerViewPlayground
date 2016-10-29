/*
* Copyright (C) 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.jpuyo.android.recyclerviewplayground.recyclerview.ui.nolibraries;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.recyclerview.model.VideoModel;
import com.jpuyo.android.recyclerviewplayground.recyclerview.ui.nolibraries.viewholders.VideoViewHolder;

import java.util.ArrayList;
import java.util.List;

public class NoLibrariesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "NoLibrariesAdapter";

    private List<VideoModel> items;

    public NoLibrariesAdapter() {
        this.items = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        } else {
            return items.size();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);
        viewHolder = new VideoViewHolder(layout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");
        ((VideoViewHolder) viewHolder).bind(items.get(position));
    }

    public void renderVideoList(List<VideoModel> videoModelList) {
        this.items = videoModelList;
        notifyDataSetChanged();
    }
}
