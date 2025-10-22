package com.marcos.IbgeApi.main;

import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);
    NamesMenu namesMenu = new NamesMenu();

    int option;

    public void displayHomeMenu() {
        System.out.println("""
    \nBem-vindo(a) ao IBGE Noticer, uma plataforma que mostra
    algumas curiosidades e notícias coletadas a partir do
    Instituto Brasileiro de Geografia e Estatística.
    
    """);

        do {
            System.out.println("""
        \nEscolha uma das opcões para continuar.
        
        Voce quer saber mais sobre:
            1 - Notícias IBGE;
            2 - Países;
            3 - Historiograma: Nomes no Brasil;
            4 - Sair.
        """);
            option = scanner.nextInt();
            scanner.nextLine();



            switch (option){
                case 1 -> {


                }
                case 2 -> {

                }
                case 3 -> namesMenu.displayNamesMenu();
                case 4 -> System.out.println("Adeus!!");
                default -> System.out.println("Opcao Inválida!");

            }
        } while(option != 4);

    }
}
