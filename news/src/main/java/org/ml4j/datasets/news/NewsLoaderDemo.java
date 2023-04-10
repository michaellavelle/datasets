package org.ml4j.datasets.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NewsLoaderDemo {

    public static void main(String[] args) throws IOException {

        NewsFeedLoader newsFeedLoader = new NewsFeedLoader();

        // Load all news feed articles from our news feed sources.
        List<NewsFeedArticle> bbcArticles = newsFeedLoader.getNewsFeedArticlesFromResource("/bbc_news_feed_articles.json");
        List<NewsFeedArticle> guardianArticles = newsFeedLoader.getNewsFeedArticlesFromResource("/guardian_news_feed_articles.json");
        List<NewsFeedArticle> telegraphArticles = newsFeedLoader.getNewsFeedArticlesFromResource("/telegraph_news_feed_articles.json");

        // Collect the news feed articles together - these objects include the feed name and date
        List<NewsFeedArticle> newsFeedArticles = new ArrayList<>();
        newsFeedArticles.addAll(bbcArticles);
        newsFeedArticles.addAll(guardianArticles);
        newsFeedArticles.addAll(telegraphArticles);

        System.out.println("News feed articles size:" + newsFeedArticles.size());

        List<String> distinctFeedNames = newsFeedArticles.stream().map(a -> a.getFeedName()).distinct().collect(Collectors.toList());

        System.out.println("Feed names:" + distinctFeedNames);

        // Extract the news articles from the news feed articles - these are feed and date agnostic
        List<NewsArticle> newsArticles = newsFeedArticles.stream().map(a -> a.getNewsArticle()).collect(Collectors.toList());

        System.out.println("News articles size:" + newsFeedArticles.size());

        // Articles are repeated over a span of dates - we can reduce to the set of distinct (identical) articles
        List<NewsArticle> distinctArticles = newsArticles.stream().distinct().collect(Collectors.toList());

        System.out.println("Distinct news articles size:" + distinctArticles.size());

    }

}