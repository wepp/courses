package com.isaiev.entities;

/**
 * Created by Isaiev on 01.05.2017.
 */
public class SearchQuery {

    private String query;

    public SearchQuery() {
    }

    public SearchQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
