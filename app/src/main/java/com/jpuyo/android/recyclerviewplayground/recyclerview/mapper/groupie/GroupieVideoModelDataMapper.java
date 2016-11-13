package com.jpuyo.android.recyclerviewplayground.recyclerview.mapper.groupie;

import com.jpuyo.android.recyclerviewplayground.data.dto.VideoDto;
import com.jpuyo.android.recyclerviewplayground.recyclerview.ui.groupie.GroupieVideoModel;

import java.util.ArrayList;
import java.util.List;

public class GroupieVideoModelDataMapper {

    public GroupieVideoModelDataMapper() {
    }

    public List<GroupieVideoModel> transform(List<VideoDto> videoDtoList) {
        List<GroupieVideoModel> videoModelList = new ArrayList<>();
        for (VideoDto videoDto : videoDtoList) {
            videoModelList.add(transform(videoDto));
        }
        return videoModelList;
    }

    public GroupieVideoModel transform(VideoDto videoDto) {
        GroupieVideoModel videoModel = null;
        if (videoDto != null) {
            videoModel = new GroupieVideoModel();
            videoModel.setTitle(videoDto.getTitle());
            videoModel.setThumbnail(videoDto.getThumbnail());
        }
        return videoModel;
    }
}
