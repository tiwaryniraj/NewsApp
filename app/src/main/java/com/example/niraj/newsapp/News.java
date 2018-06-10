package com.example.niraj.newsapp;

public class News {
    private String mTitle ;
    private String mSection;
    private String mDateTime;
    private String mUrl;
    private String mAuthor;


    public News(String mTitle, String mSection,String mAuthor, String mDateTime, String mUrl) {
        this.mTitle = mTitle;
        this.mSection = mSection;
        this.mAuthor = mAuthor;
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

    public String getmAuthor() { return mAuthor; }
}
