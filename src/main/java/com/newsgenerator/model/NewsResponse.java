package com.newsgenerator.model;

import java.util.List;

/**
 * Class for Mapping New Response with totalArticles & the list of Articles
 */
public class NewsResponse {

    private int totalArticles;
    private List<Article> articles;


    public int getTotalArticles() {
        return totalArticles;
    }


    public void setTotalArticles(int totalArticles) {
        this.totalArticles = totalArticles;
    }


    public List<Article> getArticles() {
        return articles;
    }


    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
