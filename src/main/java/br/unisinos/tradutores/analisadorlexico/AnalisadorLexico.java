package br.unisinos.tradutores.analisadorlexico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnalisadorLexico {

	// private static Character[] separadores = { ',', ';', '(', ')', '{', '}',
	// '\n', '\r', ' ', '\"', '\'', ':' };
	private static String[] separadores = { ",", ";", "(", ")", "{", "}", "\n", "\r", " ", "\"", "\'", ":", "=", "+",
			"-" };

	public static List<Token> analisar(String code) {

		String codeClean = removerComentarios(code);

		List<String> lexemas = separarLexemas(codeClean);

		return analisarLexemas(lexemas);
	}

	protected static List<Token> analisarLexemas(List<String> lexemas) {
		List<Token> tokens = new ArrayList<Token>();
		// TODO
		return tokens;
	}

	protected static List<String> separarLexemas(String code) {
		List<String> lexemas = new ArrayList<String>();

		String pilha = "";
		for (Character ch : code.toCharArray()) {
			if (isSeparador(ch)) {
				if (!pilha.isEmpty()) {
					lexemas.add(pilha);
				}

				if (ch != ' ') {
					lexemas.add(ch.toString());
				}

				pilha = "";
			} else {
				pilha += (ch == ' ') ? "" : ch;
			}
		}

		return lexemas;
	}

	protected static Boolean isSeparador(Character character) {
		return Arrays.asList(separadores).contains(character.toString());
	}

	protected static String removerComentarios(String code) {
		return code.replaceAll("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/", "");
	}
}
