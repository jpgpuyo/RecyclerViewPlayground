package com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.mapper;

import com.jpuyo.android.recyclerviewplayground.data.videolist.dto.VideoDto;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.view.VideoModel;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.view.main.MainVideoModel;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.nolibraries.view.secondary.SecondaryVideoModel;

import java.util.ArrayList;
import java.util.List;

public class VideoModelDataMapper {

    public VideoModelDataMapper() {
    }

    public List<VideoModel> transform(List<VideoDto> videoDtoList) {
        List<VideoModel> videoModelList = new ArrayList<>();

        for (int i = 0; i < videoDtoList.size(); i++) {
            VideoDto videoDto = videoDtoList.get(i);
            if (i == 0) {
                videoModelList.add(transformToMainVideo(videoDto));
            } else {
                videoModelList.add(transformToSecondaryVideo(videoDto));
            }
        }
        return videoModelList;
    }

    private VideoModel transformToMainVideo(VideoDto videoDto) {
        VideoModel videoModel = null;
        if (videoDto != null) {
            videoModel = new MainVideoModel();
            videoModel.setTitle(videoDto.getTitle());
            videoModel.setThumbnail(videoDto.getThumbnail());
        }
        return videoModel;
    }

    private VideoModel transformToSecondaryVideo(VideoDto videoDto) {
        VideoModel videoModel = null;
        if (videoDto != null) {
            videoModel = new SecondaryVideoModel();
            videoModel.setTitle(videoDto.getTitle());
            videoModel.setThumbnail(videoDto.getThumbnail());
        }
        return videoModel;
    }
}
