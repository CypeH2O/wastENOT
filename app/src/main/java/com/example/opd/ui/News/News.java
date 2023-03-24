package com.example.opd.ui.News;

public class News {
    private String Title;
    private String MainText;
    public News(String Title,String MainText){
        this.Title = Title;
        this.MainText = MainText;
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
}
