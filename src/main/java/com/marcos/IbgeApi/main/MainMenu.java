package com.marcos.IbgeApi.main;

import java.util.Scanner;

public class MainMenu {
    public void displayHomeMenu() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("""
    \nBem-vindo(a) ao IBGE Noticer, uma plataforma que mostra
    algumas curiosidades e notícias coletadas a partir do
    Instituto Brasileiro de Geografia e Estatística.
    
    """);

        int option;

        do {
            System.out.println("""
        Escolha uma das opcões para continuar
        
        Voce quer saber mais sobre:
            1 - Notícias IBGE;
            2 - Países;
            3 - Historiograma: Nomes no Brasil;
            4 - Sair.
        """);
            option = scanner.nextInt();
            scanner.nextLine();

        } while(option != 4);

        switch (option){
            case 1 -> {


            }
            case 2 -> {

            }
            case 3 -> {


            }
            case 4 -> {
                System.out.println("Adeus!!");
            }
            default -> System.out.println("Opcao Inválida!");

        }
    }
}
