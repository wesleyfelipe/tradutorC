package br.unisinos.tradutores.analisadorlexico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnalisadorLexico {

	// private static char[] separadores = {',', ';', '(',')', '{', '}', '\n',
	// '\r', ' ','\"', '\'', ':'};
	// TODO Completar esta lista
	private static String[] separadores = { "#", ",", ";", "(", ")", "{", "}", "\n", "\r", " ", "\"", "\'", ":", "=",
			"+", "-" };

	public static List<Token> analisar(String code) {

		String codeClean = removerComentarios(code);

		List<String> lexemas = separarLexemas(codeClean);

		return analisarLexemas(lexemas);
	}

	protected static List<Token> analisarLexemas(List<String> lexemas) {
		List<Token> tokens = new ArrayList<Token>();
		// TODO implementar
		return tokens;
	}

	// TODO incompleto
	protected static List<String> separarLexemas(String code) {
		List<String> lexemas = new ArrayList<String>();

		Boolean insideString = Boolean.FALSE;

		String pilha = "";
		for (Character ch : code.toCharArray()) {
						
			if (ch == '"') {
				if (!insideString) {
					insideString = Boolean.TRUE;
				} else {
					insideString = Boolean.FALSE;
				}
				pilha += ch;
				continue;
			}
			
			if(insideString){
				pilha += ch;
				continue;
			}

			if (isSeparador(ch.toString())) {
				if (!pilha.isEmpty())
					lexemas.add(pilha);

				if (!(ch == ' ' || ch == '\n'))
					lexemas.add(ch.toString());

				pilha = "";
			} else {
				pilha += (ch == ' ') ? "" : ch;
			}
		}

		return lexemas;
	}

	protected static Boolean isSeparador(String lex) {
		return Arrays.asList(separadores).contains(lex);
	}

	protected static String removerComentarios(String code) {
		return code.replaceAll("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/", "");
	}
}
