package com.jpuyo.android.recyclerviewplayground.recyclerview.mapper;

import com.jpuyo.android.recyclerviewplayground.data.dto.VideoDto;
import com.jpuyo.android.recyclerviewplayground.recyclerview.model.VideoModel;

import java.util.ArrayList;
import java.util.List;

public class VideoModelDataMapper {

    public VideoModelDataMapper() {
    }

    public List<VideoModel> transform(List<VideoDto> videoDtoList) {
        List<VideoModel> videoModelList = new ArrayList<>();
        for (VideoDto videoDto : videoDtoList) {
            videoModelList.add(transform(videoDto));
        }
        return videoModelList;
    }

    public VideoModel transform(VideoDto videoDto) {
        VideoModel videoModel = null;
        if (videoDto != null) {
            videoModel = new VideoModel();
            videoModel.setTitle(videoDto.getTitle());
            videoModel.setThumbnail(videoDto.getThumbnail());
        }
        return videoModel;
    }
}
