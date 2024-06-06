package com.newsgenerator.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import com.newsgenerator.model.Article;
import com.newsgenerator.model.NewsResponse;

@Component
public class NewsClient {

    private static final Logger logger = LogManager.getLogger(NewsClient.class);

    @Value("${gnews.api.url}")
    private String apiUrl;

    @Value("${gnews.api.key}")
    private String apiKey;

    @Value("${user.agent}")
    private String userAgent;

    private final RestTemplate restTemplate;

    public NewsClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NewsResponse getArticles(String q, String lang, String country, int max, String in, String nullable, String from, String to, String sortby) {
        try {

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl + "/search")
                    .queryParam("q",q)
                    .queryParam("lang", lang)
                    .queryParam("country", country)
                    .queryParam("max", max)
                    .queryParam("apikey", apiKey);

            if (in != null) {
                builder.queryParam("in", in);
            }
            if (nullable != null) {
                builder.queryParam("nullable", nullable);
            }
            if (from != null) {
                builder.queryParam("from", from);
            }
            if (to != null) {
                builder.queryParam("to", to);
            }
            if (sortby != null) {
                builder.queryParam("sortby", sortby);
            }

            URI url = builder.build().encode().toUri();

            // Logging the full URL for debugging
            logger.info("Request URL: " + url);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json");
            headers.set("User-Agent", userAgent);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<NewsResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, NewsResponse.class);

            return responseEntity.getBody();
        } catch (Exception e) {
            logger.error("Error during API call", e);
            return null;
        }
    }
    
    
    public List<Article> getAllArticles() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl + "/search")
                .queryParam("q", "example")  // Set the query to "example"
                .queryParam("lang", "en")    // Set the language to "en"
                .queryParam("max", 100)      // Set the maximum number of articles to 100
                .queryParam("apikey", apiKey);

        String url = builder.toUriString();
        NewsResponse response = restTemplate.getForObject(url, NewsResponse.class);

        if (response != null && response.getArticles() != null) {
            return response.getArticles();
        } else {
            return Arrays.asList(); // Return an empty list if no articles are found
        }
    }

    public NewsResponse getArticlesByTitle(String title) {
        return getArticles(title, null, null, 10, null, null, null, null, "publishedAt");
    }

    public NewsResponse getArticlesByAuthor(String author) {
        return getArticles(author, null, null, 10, null, null, null, null, "publishedAt");
    }
}
