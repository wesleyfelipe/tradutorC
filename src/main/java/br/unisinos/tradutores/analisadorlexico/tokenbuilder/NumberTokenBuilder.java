package br.unisinos.tradutores.analisadorlexico.tokenbuilder;

import org.apache.commons.lang3.math.NumberUtils;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.pojo.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;

public class NumberTokenBuilder {

	public static GeracaoTokenTo verify(String lexema) {

		String lex = lexema.trim();

		if (NumberUtils.isCreatable(lex))
			
			return new GeracaoTokenTo(new Token(TipoToken.NUMBER, lex));

		return null;

	}
	
}
