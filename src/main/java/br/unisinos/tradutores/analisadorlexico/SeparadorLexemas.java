package br.unisinos.tradutores.analisadorlexico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeparadorLexemas {

	// private static char[] separadores = {',', ';', '(',')', '{', '}', '\n',
	// '\r', ' ','\"', '\'', ':'};
	// TODO Completar esta lista
	private static String[] SEPARADORES = { "#", ",", ";", "(", ")", "{", "}", "\n", "\r", " ", "\"", "\'", ":", "=",
			"+", "-" };

	// TODO incompleto
	protected static List<String> separarLexemas(String code) {
		List<String> lexemas = new ArrayList<String>();

		Boolean entreAspas = Boolean.FALSE;
		String pilha = new String();

		for (Character ch : code.toCharArray()) {

			if (ch == '"') {
				entreAspas = !entreAspas;
				pilha += ch;
			} else if (entreAspas) {
				pilha += ch;
			} else if (isSeparador(ch.toString())) {
				if (!pilha.isEmpty())
					lexemas.add(pilha);

				if (!(ch == ' ' || ch == '\n'))
					lexemas.add(ch.toString());

				pilha = new String();
			} else {
				pilha += (ch == ' ') ? "" : ch;
			}
		}

		return lexemas;
	}

	protected static Boolean isSeparador(String lex) {
		return Arrays.asList(SEPARADORES).contains(lex);
	}

}
