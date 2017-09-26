package br.unisinos.tradutores.app;

import br.unisinos.tradutores.declaracaovariavel.AnalisadorEscopoVariavel;

public class App {

    public static void main(String[] args) {
        AnalisadorEscopoVariavel a= new AnalisadorEscopoVariavel("./src/main/resources/Teste.c");
    }
}
