package br.unisinos.tradutores.analisadorlexico.identificadores;

import java.util.Arrays;

import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class IdentificadorId {

	private static final String[] PREFIXOS = { "a", "b", "c", "d", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
			"n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "y", "z" };

	public static Token verify(String lexema) {

		if (isIdentificadorVariavel(lexema))
			return new Token(TipoToken.ID, lexema);

		return null;

	}

	protected static Boolean isIdentificadorVariavel(String lexema) {
		String firstChar = Character.toString(lexema.charAt(0)).toLowerCase();
		return !lexema.contains("(") && Arrays.asList(PREFIXOS).contains(firstChar);
	}

}
