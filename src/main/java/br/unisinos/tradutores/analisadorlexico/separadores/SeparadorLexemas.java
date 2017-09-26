package br.unisinos.tradutores.analisadorlexico.separadores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeparadorLexemas {

	private static String[] SEPARADORES = { "#", ",", ";", "(", ")", "{", "}", "\n", "\r", "\t", " ", "\"", "\'", ":",
			"=", "+", "-", "%", "!", "&", "|", ">", "<" };

	public static List<String> separarLexemas(String code) {
		List<String> lexemas = new ArrayList<String>();

		Boolean entreAspas = Boolean.FALSE;
		String pilha = new String();

		for (Character ch : code.toCharArray()) {

			if (isCharacterAspas(ch)) {
				entreAspas = !entreAspas;
				pilha += ch;

			} else if (entreAspas) {
				pilha += ch;

			} else if (isSeparador(ch.toString())) {

				if (!pilha.isEmpty())
					lexemas.add(pilha);
				if (!isCharacterIgnorado(ch))
					lexemas.add(ch.toString());
				pilha = new String();

			} else {
				pilha += isCharacterEspaco(ch) ? "" : ch;
			}
		}

		if (!pilha.isEmpty())
			lexemas.add(pilha);

		return lexemas;
	}

	protected static Boolean isCharacterAspas(Character ch) {
		return ch == '"' || ch == '\'';
	}

	protected static Boolean isCharacterEspaco(Character ch) {
		return ch == ' ';
	}

	protected static Boolean isCharacterIgnorado(Character ch) {
		return ch == ' ' || ch == '\n' || ch == '\t' || ch == '\r';
	}

	protected static Boolean isSeparador(String lex) {
		return Arrays.asList(SEPARADORES).contains(lex);
	}

}
