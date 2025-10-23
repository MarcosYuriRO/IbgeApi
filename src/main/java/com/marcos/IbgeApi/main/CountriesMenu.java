package com.marcos.IbgeApi.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcos.IbgeApi.model.countries.AllNameCountries;
import com.marcos.IbgeApi.model.countries.Capital;
import com.marcos.IbgeApi.model.countries.CapitalName;
import com.marcos.IbgeApi.model.countries.Countries;
import com.marcos.IbgeApi.model.news.News;
import com.marcos.IbgeApi.model.news.TotalNews;
import com.marcos.IbgeApi.services.ConsumptionUrlApi;

import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class CountriesMenu {
    Scanner scanner = new Scanner(System.in);
    ConsumptionUrlApi consumption = new ConsumptionUrlApi();
    ObjectMapper mapper = new ObjectMapper();
    Random random = new Random();

    int choice;
    String chosenCountry;
    String guess;
    String exit;


    public void displayCountriesMenu(){

        System.out.println("""
                Este local armazena algumas informações básicas sobre
                os 193 países membros da ONU (Organização das Nações Unidas).
                Escolha o que gostaria de explorar aqui:
                
                1 - Exibir Informações Gerais sobre um país;
                2 - Quiz (Adivinhe o país por sua Capital!).
                
                """);
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice){
            case 1 -> {
                System.out.println("Digite a abreviação de duas letras de um país:");
                chosenCountry = scanner.nextLine();

                String countriesUrl = consumption.getDataApi("https://servicodados.ibge.gov.br/api/v1/paises/" + chosenCountry);
                try {
                    Countries[] countriesList = mapper.readValue(countriesUrl, Countries[].class);
                    for (Countries nation : countriesList){
                        System.out.println(nation);
                    }
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }

            }
            case 2 -> {

                String countriesUrl = consumption.getDataApi("https://servicodados.ibge.gov.br/api/v1/paises");
                try {
                    List<Countries> countriesList = mapper.readValue(
                            countriesUrl,
                            new TypeReference<List<Countries>>() {}
                    );

                    guess = "";
                    exit = "";
                    while(!exit.equalsIgnoreCase("S")){
                        System.out.println("Tente adivinhar qual país tem esta capital:");
                        Countries countryModel = countriesList.get(generateMathRandom());
                        String guessCapital = countryModel.capitalCountry().capital().getCapitalName();
                        System.out.println(guessCapital);
                        String guessCountry = countryModel.name().nameCountrie();
                        System.out.println(guessCountry.substring(0, 3));

                        guess = scanner.nextLine();

                        if (guess.equalsIgnoreCase(guessCountry)){
                            System.out.println("Você Acertou!!");
                        } else {
                            System.out.println("Você Errou!");

                            System.out.println("O nome do país era " + countryModel.name());
                        }


                        System.out.println("Caso queira sair do Quiz," +
                                    " clique 'S', se não, clique qualquer outra tecla.");
                        exit = scanner.nextLine();

                    }


                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }

            }
            default -> System.out.println("Opção Inválida!");
        }

        scanner.nextLine();
    }

    private int generateMathRandom() {
        int randomNumber = random.nextInt(193);

        return randomNumber;
    }

}
