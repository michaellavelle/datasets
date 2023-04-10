package org.ml4j.datasets.news;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewsFeedArticle {
    private NewsArticle newsArticle;
    private String feedName;

    private String newsFeedDate;

    public String getFeedName() {
        return feedName;
    }

    public void setNewsArticle(NewsArticle newsArticle) {
        this.newsArticle = newsArticle;
    }

    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }

    public void setNewsFeedDate(String newsFeedDate) {
        this.newsFeedDate = newsFeedDate;
    }

    public String getNewsFeedDate() {
        return newsFeedDate;
    }

    public NewsArticle getNewsArticle() {
        return newsArticle;
    }
}
