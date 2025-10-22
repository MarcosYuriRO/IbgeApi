package com.marcos.IbgeApi.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcos.IbgeApi.services.ConsumptionUrlApi;

import java.util.Scanner;

import static java.lang.Thread.yield;

public class NamesMenu {
    Scanner scanner = new Scanner(System.in);
    ConsumptionUrlApi consumption = new ConsumptionUrlApi();
    ObjectMapper mapper = new ObjectMapper();


    int option;
    String chosenName;
    String chosenState;
    int stateCode;
    int chosenDecade;
    String formatter;


    public void displayNamesMenu() {

        System.out.println("""
                Esta área contém o histórico de registros de nome no Brasil.
                Exibe de antes de 1930 e também as décadas, indo da década
                de 1930-1940 até 2010-2020.
                
                Escolha qual opcão voce busca:
                
                1 - Procurar pelos registros de um nome;
                2 - Procurar os nomes mais registrados na história de um estado;
                3 - Procurar o histórico por uma década em específico.
                
                """);

        option = scanner.nextInt();
        scanner.nextLine();


        switch (option) {
            case 1 -> {
                System.out.println("Escreva um nome para ver a quantidade" +
                        "de seus registros por época");
                chosenName = scanner.nextLine();

                formatter = consumption.getDataApi("https://servicodados.ibge.gov.br/api/v2/censos/nomes/" + chosenName);

                try {
                    JsonNode jsonNode = mapper.readTree(formatter);

                    String jsonFormatted = jsonNode.toPrettyString();

                    System.out.println(jsonFormatted);
                } catch (JsonProcessingException e) {
                    System.err.println("Erro ao processar JSON: " + e.getMessage());
                }
            }
            case 2 -> {
                System.out.println("Digite a abreviação de um estado brasileiro " +
                        "para ver o top 20 de nomes mais registrados na história do estado.");
                chosenState = scanner.nextLine().toUpperCase();
                statesConverter(chosenState);
                formatter = consumption.getDataApi("https://servicodados.ibge.gov.br/api/v2/censos/nomes/ranking?localidade=" + stateCode);

                try {
                    JsonNode jsonNode = mapper.readTree(formatter);

                    String jsonFormatted = jsonNode.toPrettyString();

                    System.out.println(jsonFormatted);
                } catch (JsonProcessingException e) {
                    System.err.println("Erro ao processar JSON: " + e.getMessage());
                }
            }
            case 3 -> {
                System.out.println("Digite uma década, de 1930 a 2010 e veja o top 20 " +
                        "de nomes mais registrados durante esta época.");
                chosenDecade = scanner.nextInt();
                scanner.nextLine();

                formatter = consumption.getDataApi("https://servicodados.ibge.gov.br/api/v2/censos/nomes/ranking/?decada=" + chosenDecade);
                try {
                    JsonNode jsonNode = mapper.readTree(formatter);

                    String jsonFormatted = jsonNode.toPrettyString();

                    System.out.println(jsonFormatted);
                } catch (JsonProcessingException e) {
                    System.err.println("Erro ao processar JSON: " + e.getMessage());
                }
            }
            default -> System.out.println("Opção Inválida");
        }
        scanner.nextLine();
    }

    private int statesConverter(String stateAbreviation) {
        switch (stateAbreviation) {
            case ("RO") -> stateCode = 11;

            case ("AC") -> stateCode = 12;

            case ("AM") -> stateCode = 13;

            case ("RR") -> stateCode = 14;

            case ("PA") -> stateCode = 15;

            case ("AP") -> stateCode = 16;

            case ("TO") -> stateCode = 17;

            case ("MA") -> stateCode = 21;

            case ("PI") -> stateCode = 22;

            case ("CE") -> stateCode = 23;

            case ("RN") -> stateCode = 24;

            case ("PB")-> stateCode = 25;

            case ("PE") -> stateCode = 26;

            case ("AL") -> stateCode = 27;

            case ("SE") -> stateCode = 28;

            case ("BA") -> stateCode = 29;

            case ("MG") -> stateCode = 31;

            case ("ES") -> stateCode = 32;

            case ("RJ") -> stateCode = 33;

            case ("SP") -> stateCode = 35;

            case ("PR") -> stateCode = 41;

            case ("SC") -> stateCode = 42;

            case ("RS") -> stateCode = 43;

            case ("MS") -> stateCode = 50;

            case ("MT") -> stateCode = 51;

            case ("GO") -> stateCode = 52;

            case ("DF") -> stateCode = 53;
        }
        return stateCode;

    }
}
