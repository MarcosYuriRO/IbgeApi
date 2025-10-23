package com.marcos.IbgeApi.model.news;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TotalNews(List<News> items) {
}

//Cria uma lista de da classe News, onde ela exibe as características de cada notícia, uma por vez.