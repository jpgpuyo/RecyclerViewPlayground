package com.jpuyo.android.recyclerviewplayground.common.navigation;

import android.content.Context;
import android.content.Intent;

import com.jpuyo.android.recyclerviewplayground.recyclerview.ui.epoxy.EpoxyActivity;
import com.jpuyo.android.recyclerviewplayground.recyclerview.ui.groupie.GroupieActivity;
import com.jpuyo.android.recyclerviewplayground.recyclerview.ui.nolibraries.NoLibrariesActivity;
import com.jpuyo.android.recyclerviewplayground.recyclerview.ui.renderers.RenderersActivity;

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
