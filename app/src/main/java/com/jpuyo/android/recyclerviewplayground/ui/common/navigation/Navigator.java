package com.jpuyo.android.recyclerviewplayground.ui.common.navigation;

import android.content.Context;
import android.content.Intent;

import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.EpoxyActivity;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.groupie.GroupieActivity;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.NoLibrariesActivity;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.RenderersActivity;

public class Navigator {

    private final Context context;

    public Navigator(Context context) {
        this.context = context;
    }

    public void loadNoLibrariesSample() {
        launchActivity(NoLibrariesActivity.class);
    }

    public void loadEpoxySample() {
        launchActivity(EpoxyActivity.class);
    }

    public void loadRenderersSample() {
        launchActivity(RenderersActivity.class);
    }

    public void loadGroupieSample() {
        launchActivity(GroupieActivity.class);
    }

    private void launchActivity(Class activity){
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }
}
