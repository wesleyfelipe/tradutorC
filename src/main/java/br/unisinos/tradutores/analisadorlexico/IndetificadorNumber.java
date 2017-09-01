package br.unisinos.tradutores.analisadorlexico;

import org.apache.commons.lang3.math.NumberUtils;

public class IndetificadorNumber {

	public static Token verify(String lexema) {

		String lex = lexema.trim();

		if (NumberUtils.isCreatable(lex))
			
			return new Token(TipoToken.NUMBER, lex);

		return null;

	}
	
}
