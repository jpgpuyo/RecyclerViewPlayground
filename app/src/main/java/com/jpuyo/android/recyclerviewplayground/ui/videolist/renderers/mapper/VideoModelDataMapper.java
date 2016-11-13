package com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.mapper;

import com.jpuyo.android.recyclerviewplayground.data.videolist.dto.VideoDto;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.renderers.view.VideoModel;

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
