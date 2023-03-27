package com.example.opd.ui.News;

public class News {
    private String Title;
    private String MainText;
    private byte[] blobTitleimg;
    private byte[] blobMainimg;
    public News(String Title,String MainText,byte[] blobTitleimg,byte[] blobMainimg){
        this.Title = Title;
        this.MainText = MainText;
        this.blobTitleimg=blobTitleimg;
        this.blobMainimg=blobMainimg;
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
    public byte[] getblobTitleimg(){
        return this.blobTitleimg;
    }
    public void setblobTitleimg(byte[] blobTitleimg){
        this.blobTitleimg = blobTitleimg;
    }
    public byte[] getblobMainimg(){
        return this.blobMainimg;
    }
    public void setblobMainimg(byte[] blobMainimg){
        this.blobMainimg = blobMainimg;
    }
}
