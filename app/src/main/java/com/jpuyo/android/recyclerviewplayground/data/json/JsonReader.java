package com.jpuyo.android.recyclerviewplayground.data.json;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jpuyo.android.recyclerviewplayground.data.dto.VideoDto;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class JsonReader {

    private final Context context;
    List<VideoDto> videos;

    public JsonReader(Context context){
        this.context = context;
    }

    public List<VideoDto> readVideoListFromAssets(){
        GsonBuilder gsonBuilder=new GsonBuilder();
        Gson gson=gsonBuilder.create();
        videos = Arrays.asList(gson.fromJson(loadJsonfromAssets(),VideoDto[].class));
        return videos;
    }

    private String loadJsonfromAssets(){
        String json=null;
        try {
            InputStream is = context.getAssets().open("videos.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}
