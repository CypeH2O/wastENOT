package com.example.opd.ui.News;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class JSONHelper {
    static public List<News> getNewsFromJSON(String JSONString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<News> newsList = Arrays.asList(objectMapper.readValue(JSONString,News[].class));
        return newsList;
    }
    static public String getMarkupFromJSON(String JSONString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        MainNewsMarkup mark = objectMapper.readValue(JSONString,MainNewsMarkup.class);
        return mark.getTextMarkup();
    }
    static public List<MainNewsData> getDataFromJSON(String JSONString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<MainNewsData> newsData = Arrays.asList(objectMapper.readValue(JSONString,MainNewsData[].class));
        return newsData;
    }
}
