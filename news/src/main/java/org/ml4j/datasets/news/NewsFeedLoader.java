package org.ml4j.datasets.news;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class NewsFeedLoader {

    private ObjectMapper objectMapper;

    public NewsFeedLoader() {
        this.objectMapper = new ObjectMapper();
    }

    public List<NewsFeedArticle> getNewsFeedArticlesFromResource(String resourcePath) throws IOException {
        try (InputStream is = NewsFeedLoader.class.getResourceAsStream(resourcePath)) {
            return objectMapper.readValue(is, NewsFeedArticles.class);
        }
    }
}
