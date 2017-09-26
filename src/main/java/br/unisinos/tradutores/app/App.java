package br.unisinos.tradutores.app;

import br.unisinos.tradutores.arquivo.Arquivo;
import br.unisinos.tradutores.declaracaovariavel.AnalisadorEscopoVariavel;

public class App {

	public static void main(String[] args) {
		String sourceFile = "./src/main/resources/Teste.c";

		String code = Arquivo.lerArquivo(sourceFile);

		AnalisadorEscopoVariavel a = new AnalisadorEscopoVariavel(code);
	}
}
