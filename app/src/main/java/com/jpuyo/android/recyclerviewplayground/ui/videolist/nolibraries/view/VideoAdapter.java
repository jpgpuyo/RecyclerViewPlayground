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

package com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.view.main.MainVideoViewHolder;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.view.secondary.SecondaryVideoViewHolder;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.view.main.MainVideoModel;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.view.secondary.SecondaryVideoModel;

import java.util.ArrayList;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "NoLibraries";

    private List<VideoModel> items;

    private static final int MAIN_VIDEO_TYPE = 10;
    private static final int SECONDARY_VIDEO_TYPE = 20;

    public VideoAdapter() {
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
    public int getItemViewType(int position) {
        Object item = items.get(position);
        int result = 0;

        if (item instanceof MainVideoModel) {
            result = MAIN_VIDEO_TYPE;
        } else if (item instanceof SecondaryVideoModel){
            result = SECONDARY_VIDEO_TYPE;
        }
        return result;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == MAIN_VIDEO_TYPE) {
            viewHolder = new MainVideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_video_item, parent, false));
        } else if (viewType == SECONDARY_VIDEO_TYPE) {
            viewHolder = new SecondaryVideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.secondary_video_item, parent, false));
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");
        int viewType = getItemViewType(position);
        if (viewType == MAIN_VIDEO_TYPE) {
            ((MainVideoViewHolder) viewHolder).render(items.get(position));
        } else if (viewType == SECONDARY_VIDEO_TYPE) {
            ((SecondaryVideoViewHolder) viewHolder).bind(items.get(position));
        }
    }

    public void renderVideoList(List<VideoModel> videoModelList) {
        this.items = videoModelList;
        notifyDataSetChanged();
    }
}
