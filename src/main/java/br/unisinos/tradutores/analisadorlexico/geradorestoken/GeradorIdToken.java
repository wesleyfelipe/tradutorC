package br.unisinos.tradutores.analisadorlexico.geradorestoken;

import java.util.Arrays;

import br.unisinos.tradutores.analisadorlexico.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class GeradorIdToken {

	private static final String[] PREFIXOS = { "a", "b", "c", "d", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
			"n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "y", "z" };

	public static GeracaoTokenTo verify(String lexema) {

		if (isIdentificadorVariavel(lexema))
			return new GeracaoTokenTo(new Token(TipoToken.ID, lexema));

		return null;

	}

	protected static Boolean isIdentificadorVariavel(String lexema) {
		String firstChar = Character.toString(lexema.charAt(0)).toLowerCase();
		return !lexema.contains("(") && Arrays.asList(PREFIXOS).contains(firstChar);
	}

}
