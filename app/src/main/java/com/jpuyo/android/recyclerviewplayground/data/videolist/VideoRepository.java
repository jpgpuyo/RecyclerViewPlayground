package com.jpuyo.android.recyclerviewplayground.data.videolist;


import com.jpuyo.android.recyclerviewplayground.data.common.JsonReader;
import com.jpuyo.android.recyclerviewplayground.data.videolist.dto.VideoDto;

import java.util.List;

public class VideoRepository {

    private final JsonReader jsonReader;

    public VideoRepository(JsonReader jsonReader){
        this.jsonReader = jsonReader;
    }

    public List<VideoDto> getVideos() {
        return jsonReader.readVideoListFromAssets();
    }
}
