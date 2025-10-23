package com.marcos.IbgeApi.model.news;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TotalNews(@JsonAlias("items") TotalNews listNews,
                        List<News> items) {
    @Override
    public String toString() {
        return "\n" + listNews;
    }
}
