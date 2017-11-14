package br.unisinos.tradutores.app;

import java.util.List;

import br.unisinos.tradutores.analisadorlexico.AnalisadorLexico;
import br.unisinos.tradutores.analisadorsemantico.AnalisadorSemantico;
import br.unisinos.tradutores.arquivo.Arquivo;
import br.unisinos.tradutores.domain.Movimento;
import br.unisinos.tradutores.domain.Token;

public class App {

	public static void main(String[] args) throws Exception {
		
		//Leitura do arquivo
		String sourceFile = "./src/main/resources/Teste.c";
		String code = Arquivo.lerArquivo(sourceFile);

		//Análise sintática
		List<Token> tokens = new AnalisadorLexico().analisar(code);
		printTokenList(tokens);
		
		//Análise semantica e extração dos movimentos em ordem de execução
		List<Movimento> movimentos = new AnalisadorSemantico().analisar(tokens);
		
		//Cálculo da distância percorrida
		Double distancia = CalculadorDistancia.calcularDistanciaPercorrida(movimentos);
		
		System.out.println("===============================================");
		System.out.println("Distância percorrida: " + distancia);
		

	}
	
	public static void printTokenList(List<Token> tokens) {
		System.out.println("======= Lista de Tokens Identificados ========");
		for (int i = 0; i < tokens.size(); i++) {
			Token token = tokens.get(i);
			System.out.println("Token [" + i + "]: [" + token.getTipo() + "," + token.getValor() + "]");
		}

	}
}
