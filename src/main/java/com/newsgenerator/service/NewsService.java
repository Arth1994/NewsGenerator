package com.newsgenerator.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.newsgenerator.client.NewsClient;
import com.newsgenerator.model.Article;
import com.newsgenerator.model.NewsResponse;

@Service
public class NewsService {

	@Autowired
	NewsClient newsClient;

    @Cacheable("articles")
    public NewsResponse getArticles(String q, String lang, String country, int max, String in, String nullable, String from, String to, String sortby) {
        return newsClient.getArticles(q, lang, country, max, in, nullable, from, to, sortby);
    }

    @Cacheable("articles")
    public NewsResponse getArticlesByTitle(String title) {
        return newsClient.getArticlesByTitle(title);
    }

    @Cacheable("articles")
    public NewsResponse getArticlesByAuthor(String author) {
        return newsClient.getArticlesByAuthor(author);
    }
    
    
    @Cacheable("articlesBySource")
    public List<Article> getArticlesBySourceName(String sourceName) {
        List<Article> allArticles = newsClient.getAllArticles(); 

        // Filter articles by source name
        List<Article> filteredArticles = allArticles.stream()
                .filter(article -> article.getSource().getName().equalsIgnoreCase(sourceName))
                .collect(Collectors.toList());

        return filteredArticles;
    }
}