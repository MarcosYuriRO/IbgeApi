package com.marcos.IbgeApi.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcos.IbgeApi.services.ConsumptionUrlApi;

import java.util.Scanner;


public class NamesMenu {
    Scanner scanner = new Scanner(System.in);
    ConsumptionUrlApi consumption = new ConsumptionUrlApi();
    ObjectMapper mapper = new ObjectMapper();


    int option;
    String chosenName;
    int chosenDecade;
    String namesUrl;


    public void displayNamesMenu() {

        System.out.println("""
                Esta área contém o histórico de registros de nome no Brasil.
                Exibe de antes de 1930 e também as décadas, indo da década
                de 1930-1940 até 2010-2020.
                
                Escolha qual opcão voce busca:
                
                1 - Procurar pelos registros de um nome;
                2 - Procurar o histórico por uma década em específico.
                
                """);

        option = scanner.nextInt();
        scanner.nextLine();


        switch (option) {
            case 1 -> {
                System.out.println("Escreva um nome para ver a quantidade" +
                        " de seus registros por época");
                chosenName = scanner.nextLine();

                namesUrl = consumption.getDataApi("https://servicodados.ibge.gov.br/api/v2/censos/nomes/" + chosenName);

                try {
                    //Deixa o JSON main bonito/legível:

                    JsonNode jsonNode = mapper.readTree(namesUrl);
                    String jsonFormatted = jsonNode.toPrettyString();
                    System.out.println(jsonFormatted);

                } catch (JsonProcessingException e) {
                    System.out.println("Erro ao processar JSON: " + e.getMessage());
                }
            }

            case 2 -> {
                System.out.println("Digite uma década, de 1930 a 2010 e veja o top 20 " +
                        "de nomes mais registrados durante esta época.");
                chosenDecade = scanner.nextInt();
                scanner.nextLine();

                namesUrl = consumption.getDataApi("https://servicodados.ibge.gov.br/api/v2/censos/nomes/ranking/?decada=" + chosenDecade);
                try {
                    JsonNode jsonNode = mapper.readTree(namesUrl);
                    String jsonFormatted = jsonNode.toPrettyString();
                    System.out.println(jsonFormatted);

                } catch (JsonProcessingException e) {
                    System.out.println("Erro ao processar JSON: " + e.getMessage());
                }
            }
            default -> System.out.println("Opção Inválida");
        }
        scanner.nextLine();
    }

}
