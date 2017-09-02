package br.unisinos.tradutores.analisadorlexico;

import java.util.ArrayList;
import java.util.List;

public class AnalisadorLexico {

	public static List<Token> analisar(String code) {

		String codeClean = removerComentarios(code);

		List<String> lexemas = SeparadorLexemas.separarLexemas(codeClean);

		return analisarLexemas(lexemas);
	}

	protected static List<Token> analisarLexemas(List<String> lexemas) {
		List<Token> tokens = new ArrayList<Token>();
		// TODO implementar
		return tokens;
	}


	protected static String removerComentarios(String code) {
		return code.replaceAll("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/", "");
	}
}
