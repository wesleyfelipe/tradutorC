package br.unisinos.tradutores.analisadorlexico.identificadores;

import org.apache.commons.lang3.math.NumberUtils;

import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class IdentificadorNumber {

	public static Token verify(String lexema) {

		String lex = lexema.trim();

		if (NumberUtils.isCreatable(lex))
			
			return new Token(TipoToken.NUMBER, lex);

		return null;

	}
	
}
