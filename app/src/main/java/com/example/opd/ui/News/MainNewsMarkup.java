package com.example.opd.ui.News;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainNewsMarkup {
    int id;
    @JsonProperty("mainText")
    String textMarkup;
    public MainNewsMarkup(){}

    public MainNewsMarkup(int id, String textMarkup) {
        this.id = id;
        this.textMarkup = textMarkup;
    }

    public int getId() {
        return id;
    }

    public String getTextMarkup() {
        return textMarkup;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTextMarkup(String textMarkup) {
        this.textMarkup = textMarkup;
    }
}
