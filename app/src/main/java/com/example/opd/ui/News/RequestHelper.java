package com.example.opd.ui.News;

import static com.example.opd.ui.News.JSONHelper.getDataFromJSON;
import static com.example.opd.ui.News.JSONHelper.getMarkupFromJSON;
import static com.example.opd.ui.News.JSONHelper.getNewsFromJSON;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RequestHelper {
    static public List<News> getNewsFromUrl(int startid,int count){
        String url = "https://polyeco-backend.onrender.com/androidTest?startid=" + Integer.toString(startid) + "&count=" + Integer.toString(count);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60, TimeUnit.SECONDS);
        builder.readTimeout(60, TimeUnit.SECONDS);
        builder.writeTimeout(60, TimeUnit.SECONDS);
        OkHttpClient client = builder.build();
        Request request = new Request.Builder().url(url).build();
        List<News> newsList;
        try {
            Response response = client.newCall(request).execute();
            newsList = getNewsFromJSON(response.body().string());
            return newsList;
        }catch (IOException ex){
            ex.printStackTrace();
        }
       return null;
    }

    static public String getTextMarkup(int id){
        String url = "https://polyeco-backend.onrender.com/android/textmarkup?id=" + Integer.toString(id);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60, TimeUnit.SECONDS);
        builder.readTimeout(60, TimeUnit.SECONDS);
        builder.writeTimeout(60, TimeUnit.SECONDS);
        OkHttpClient client = builder.build();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            String mark = getMarkupFromJSON(response.body().string());
            return mark;
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }
    static public List<MainNewsData> getNewsData(int id){
        String url = "https://polyeco-backend.onrender.com/android/newsdata?id=" + Integer.toString(id);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60, TimeUnit.SECONDS);
        builder.readTimeout(60, TimeUnit.SECONDS);
        builder.writeTimeout(60, TimeUnit.SECONDS);
        OkHttpClient client = builder.build();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            List<MainNewsData> newsData = getDataFromJSON(response.body().string());
            return newsData;
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
