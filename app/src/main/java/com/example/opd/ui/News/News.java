package com.example.opd.ui.News;

import com.fasterxml.jackson.annotation.JsonProperty;

public class News {
    int id;
    @JsonProperty("title")
    private String Title;
    @JsonProperty("maintext")
    private String MainText;
    @JsonProperty("titleimg")
    private byte[] blobTitleImg;
    @JsonProperty("mainimg")
    private byte[] blobMainImg;
    public News(){

    }
    public News(int id, String title, String mainText, byte[] blobTitleImg, byte[] blobMainImg) {
        this.id = id;
        Title = title;
        MainText = mainText;
        this.blobTitleImg = blobTitleImg;
        this.blobMainImg = blobMainImg;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle(){
        return this.Title;
    }
    public void setTitle(String Title){
        this.Title = Title;
    }
    public String getMainText(){
        return this.MainText;
    }
    public void setMainText(String MainText){
        this.MainText = MainText;
    }
    public byte[] getBlobTitleImg(){
        return this.blobTitleImg;
    }
    public void setBlobTitleImg(byte[] blobTitleImg){
        this.blobTitleImg = blobTitleImg;
    }
    public byte[] getBlobMainImg(){
        return this.blobMainImg;
    }
    public void setBlobMainImg(byte[] blobMainImg){
        this.blobMainImg = blobMainImg;
    }
}
