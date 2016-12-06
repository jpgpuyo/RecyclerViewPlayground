package com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.mapper;

import com.jpuyo.android.recyclerviewplayground.data.videolist.dto.VideoDto;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.main.MainVideoModel;
import com.jpuyo.android.recyclerviewplayground.ui.videolist.epoxy.view.secondary.SecondaryVideoModel;

import java.util.ArrayList;
import java.util.List;

public class VideoModelDataMapper {

    public VideoModelDataMapper() {
    }

    public MainVideoModel transformToMainVideoModel(List<VideoDto> videoDtoList) {
        MainVideoModel mainVideoModel = null;
        if (!videoDtoList.isEmpty()) {
            mainVideoModel = transformToMainVideoModel(videoDtoList.get(0));
        }
        return mainVideoModel;
    }

    public List<SecondaryVideoModel> transformToSecondaryVideoModelList(List<VideoDto> videoDtoList) {
        List<SecondaryVideoModel> secondaryVideoModels = new ArrayList<>();
        for (int i = 0; i < videoDtoList.size(); i++) {
            if (i != 0) {
                secondaryVideoModels.add(transformToSecondaryVideoModel(videoDtoList.get(i)));
            }
        }
        return secondaryVideoModels;
    }

    private MainVideoModel transformToMainVideoModel(VideoDto videoDto) {
        MainVideoModel mainVideoModel = null;
        if (videoDto != null) {
            mainVideoModel = new MainVideoModel();
            mainVideoModel.setTitle(videoDto.getTitle());
            mainVideoModel.setThumbnail(videoDto.getThumbnail());
        }
        return mainVideoModel;
    }

    private SecondaryVideoModel transformToSecondaryVideoModel(VideoDto videoDto) {
        SecondaryVideoModel secondaryVideoModel = null;
        if (videoDto != null) {
            secondaryVideoModel = new SecondaryVideoModel();
            secondaryVideoModel.setTitle(videoDto.getTitle());
            secondaryVideoModel.setThumbnail(videoDto.getThumbnail());
        }
        return secondaryVideoModel;
    }
}
