package br.unisinos.tradutores.app;

import java.util.List;

import br.unisinos.tradutores.analisadorlexico.AnalisadorLexico;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;
import br.unisinos.tradutores.arquivo.Arquivo;

public class App {

	public static void main(String[] args) {
		
		String sourceFile = "./src/main/resources/Teste.c";

		String code = Arquivo.lerArquivo(sourceFile);

		List<Token> tokens = new AnalisadorLexico().analisar(code);
		
		printTokenList(tokens);

	}
	
	public static void printTokenList(List<Token> tokens) {
		System.out.println("======= Lista de Tokens Identificados ========");
		for (int i = 0; i < tokens.size(); i++) {
			Token token = tokens.get(i);
			System.out.println("Token [" + i + "]: [" + token.getTipo() + "," + token.getValor() + "]");
		}

	}
}
