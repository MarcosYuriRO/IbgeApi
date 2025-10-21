package com.marcos.IbgeApi.main;

import java.util.Scanner;

public class NamesMenu {
    public void displayNamesMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Esta área contém o histórico de registros de nome no Brasil.
                Exibe de antes de 1930 e também as décadas, indo da década
                de 1930-1940 até 2010-2020.
                
                Escolha qual opcão voce busca:
                
                1 - Procurar pelos registros de um nome;
                2 - Procurar pelo registro histórico de um nome em um estado;
                3 - Procurar o histórico por uma década em específico.
                
                """);
    }

}
