package com.newsgenerator.model;

/**
 * Class to depict Source - Author Name and URL
 */
public class Source {

    private String name;
    private String url;

    /**
     * Get the name of the source.
     *
     * @return The name of the source.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the source.
     *
     * @param name The name of the source.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the URL of the source.
     *
     * @return The URL of the source.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the URL of the source.
     *
     * @param url The URL of the source.
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
