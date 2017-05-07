package com.jpuyo.android.recyclerviewplayground.ui.common.navigation;

import android.content.Context;
import android.content.Intent;

import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.EpoxyActivity;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.groupie.GroupieActivity;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.NoLibrariesActivity;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.RenderersActivity;

public class ActivityNavigator {

    public static void loadNoLibrariesSample(Context context) {
        launchActivity(context, NoLibrariesActivity.class);
    }

    public static void loadEpoxySample(Context context) {
        launchActivity(context, EpoxyActivity.class);
    }

    public static void loadRenderersSample(Context context) {
        launchActivity(context, RenderersActivity.class);
    }

    public static void loadGroupieSample(Context context) {
        launchActivity(context, GroupieActivity.class);
    }

    private static void launchActivity(Context context, Class activity){
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }
}
