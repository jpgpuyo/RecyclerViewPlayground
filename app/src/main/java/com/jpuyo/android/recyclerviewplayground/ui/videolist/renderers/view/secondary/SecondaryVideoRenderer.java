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

package com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.view.secondary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.view.VideoModelRenderer;

import butterknife.ButterKnife;

public class SecondaryVideoRenderer extends VideoModelRenderer {

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        View inflatedView = inflater.inflate(R.layout.secondary_video_item, parent, false);
        ButterKnife.bind(this, inflatedView);
        return inflatedView;
    }
}
