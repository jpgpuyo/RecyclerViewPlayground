package com.jpuyo.android.recyclerviewplayground.data;

import com.jpuyo.android.recyclerviewplayground.data.dto.VideoDto;
import com.jpuyo.android.recyclerviewplayground.data.json.JsonReader;

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
