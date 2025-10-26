package com.marcos.IbgeApi.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcos.IbgeApi.model.news.News;
import com.marcos.IbgeApi.model.news.TotalNews;
import com.marcos.IbgeApi.services.ConsumptionUrlApi;

import java.util.List;
import java.util.Scanner;

public class NewsMenu {
    Scanner scanner = new Scanner(System.in);
    ConsumptionUrlApi consumption = new ConsumptionUrlApi();
    ObjectMapper mapper = new ObjectMapper();

    String option;
    int counter;
    int page;

    public void displayNewsMenu(){
        System.out.println("""
    Bem-Vindo(a) ao Campo de Notícias. Aqui, você terá diversas páginas repletas
    de notícias documentadas pelo IBGE, com o link à página logo abaixo de uma breve
    descrição sobre cada Notícia.
    
    Qual página você deseja buscar? (pág. 1 até a pág. 226)
    """);

        page = scanner.nextInt();
        scanner.nextLine();

        String newsUrl = consumption.getDataApi("https://servicodados.ibge.gov.br/api/v3/noticias/?page=" + page);
        try {
            TotalNews totalNews = mapper.readValue(newsUrl, TotalNews.class);
            //cria um objeto com todas as notícias de determinada página
            List<News> newsList = totalNews.items();
            //Cria uma lista com todas as notícias para as exibir separadamente
            counter = 0;
            option = "";

            while (!option.equalsIgnoreCase("S")){
                System.out.println(newsList.get(counter));
                counter++;
                if (newsList.size() == counter) {
                    System.out.println("\nFim da página!");
                    option = "S";
                    scanner.nextLine();
                } else {
                System.out.println("\nCaso queira sair das notícias, clique 'S', " +
                        "se não, clique qualquer outra tecla!");
                    option = scanner.nextLine();
                }
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }



}
