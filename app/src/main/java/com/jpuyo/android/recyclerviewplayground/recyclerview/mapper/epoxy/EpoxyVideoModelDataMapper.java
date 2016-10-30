package com.jpuyo.android.recyclerviewplayground.recyclerview.mapper.epoxy;

import com.jpuyo.android.recyclerviewplayground.data.dto.VideoDto;
import com.jpuyo.android.recyclerviewplayground.recyclerview.ui.epoxy.EpoxyVideoModel;

import java.util.ArrayList;
import java.util.List;

public class EpoxyVideoModelDataMapper {

    public EpoxyVideoModelDataMapper() {
    }

    public List<EpoxyVideoModel> transform(List<VideoDto> videoDtoList) {
        List<EpoxyVideoModel> videoModelList = new ArrayList<>();
        for (VideoDto videoDto : videoDtoList) {
            videoModelList.add(transform(videoDto));
        }
        return videoModelList;
    }

    public EpoxyVideoModel transform(VideoDto videoDto) {
        EpoxyVideoModel videoModel = null;
        if (videoDto != null) {
            videoModel = new EpoxyVideoModel();
            videoModel.setTitle(videoDto.getTitle());
            videoModel.setThumbnail(videoDto.getThumbnail());
        }
        return videoModel;
    }
}
