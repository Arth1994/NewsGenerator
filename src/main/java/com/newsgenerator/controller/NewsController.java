package com.newsgenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newsgenerator.model.Article;
import com.newsgenerator.model.NewsResponse;
import com.newsgenerator.service.NewsService;

/**
 * 
 * Rest Controller to fetch news articles based on the query parameters
 * specified in the request.
 * 
 */
@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    /**
     * Endpoint to fetch news articles based on query parameters.
     * @param q        Mandatory search keywords.
     * @param lang     Optional language filter.
     * @param country  Optional country filter.
     * @param max      Optional maximum number of results, default is 10.
     * @param in       Optional attributes to search in (title, description, content).
     * @param nullable Optional attributes that can return null values.
     * @param from     Optional filter for articles published after a date.
     * @param to       Optional filter for articles published before a date.
     * @param sortby   Optional sorting parameter, default is "publishedAt".
     * @return NewsResponse containing the fetched articles.
     * 
     * Example : http://localhost:8080/api/news/fetch?q=example&max=10&apikey=0f47ad38e622aba09ac576d2e4c3d34a
     * 
     */
    @GetMapping("/fetch")
    public NewsResponse fetchArticles(
            @RequestParam String q,
            @RequestParam(required = false) String lang,
            @RequestParam(required = false) String country,
            @RequestParam(defaultValue = "10") int max,
            @RequestParam(required = false) String in,
            @RequestParam(required = false) String nullable,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to,
            @RequestParam(defaultValue = "publishedAt") String sortby) {
        return newsService.getArticles(q, lang, country, max, in, nullable, from, to, sortby);
    }

    /**
     * Endpoint to find a news article by title.
     * @param title The title of the news article to find.
     * @return NewsResponse containing the matching article.
     */
    @GetMapping("/find-by-title")
    public NewsResponse findArticleByTitle(@RequestParam String title) {
        return newsService.getArticlesByTitle(title);
    }

    /**
     * Endpoint to find news articles by author.
     * @param author The author (also known as source name) of the news articles to find.
     * @return NewsResponse containing the matching articles.
     */
    @GetMapping("/by-source")
    public List<Article> getArticlesBySourceName(@RequestParam String sourceName) {
        return newsService.getArticlesBySourceName(sourceName);
    }

}
