package com.mt178.diyihangdaima.domain;

/**
 * Created by llh on 2015/3/17.
 */
public class News {
    //新闻标题
    private String title;
    //新闻内容
    private String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
