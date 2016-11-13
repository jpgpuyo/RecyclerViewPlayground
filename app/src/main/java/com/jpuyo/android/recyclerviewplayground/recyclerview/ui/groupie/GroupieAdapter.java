package com.jpuyo.android.recyclerviewplayground.recyclerview.ui.groupie;

import com.genius.groupie.GroupAdapter;

import java.util.List;

public class GroupieAdapter extends GroupAdapter {

    public GroupieAdapter() {
    }


    public void renderVideoList(List<GroupieVideoModel> videoModelList) {
        for (GroupieVideoModel videoModel : videoModelList) {
            add(videoModel);
        }
    }
}
