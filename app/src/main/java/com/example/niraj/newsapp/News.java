package com.example.niraj.newsapp;

public class News {
    private String mTitle ;
    private String mSection;
    private String mDateTime;
    private String mUrl;


    public News(String mTitle, String mSection, String mDateTime, String mUrl) {
        this.mTitle = mTitle;
        this.mSection = mSection;
        this.mDateTime = mDateTime;
        this.mUrl = mUrl;

    }

    public String getUrl() {
        return mUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSection() {
        return mSection;
    }

    public String getDateTime() {
        return mDateTime;
    }
}
