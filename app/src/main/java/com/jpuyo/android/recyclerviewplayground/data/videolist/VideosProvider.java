package com.jpuyo.android.recyclerviewplayground.data.videolist;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jpuyo.android.recyclerviewplayground.data.videolist.dto.VideoDto;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class VideosProvider {

    public static List<VideoDto> getVideos(Context context) {
        GsonBuilder gsonBuilder=new GsonBuilder();
        Gson gson=gsonBuilder.create();
        String json = loadJsonfromAssets(context);
        List<VideoDto> videos = Arrays.asList(gson.fromJson(json,VideoDto[].class));
        return videos;
    }

    private static String loadJsonfromAssets(Context context){
        String json;
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
