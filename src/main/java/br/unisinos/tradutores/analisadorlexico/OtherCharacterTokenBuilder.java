package br.unisinos.tradutores.analisadorlexico;

import br.unisinos.tradutores.domain.TipoToken;
import br.unisinos.tradutores.domain.Token;

public class OtherCharacterTokenBuilder {

	private static final String L_PAREN = "(";
	private static final String R_PAREN = ")";

	public static GeracaoTokenTo verify(String lexema) {

		Token token = null;

		if (isLParen(lexema))
			token = new Token(TipoToken.L_PAREN, lexema);

		if (isRParen(lexema))
			token = new Token(TipoToken.R_PAREN, lexema);

		return token == null ? null : new GeracaoTokenTo(token);
	}

	protected static Boolean isLParen(String lexema) {
		return L_PAREN.equals(lexema);
	}

	protected static Boolean isRParen(String lexema) {
		return R_PAREN.equals(lexema);
	}

}
