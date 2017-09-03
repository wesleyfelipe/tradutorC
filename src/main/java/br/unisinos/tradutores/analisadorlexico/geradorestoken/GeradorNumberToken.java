package br.unisinos.tradutores.analisadorlexico.geradorestoken;

import org.apache.commons.lang3.math.NumberUtils;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.pojo.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;

public class GeradorNumberToken {

	public static GeracaoTokenTo verify(String lexema) {

		String lex = lexema.trim();

		if (NumberUtils.isCreatable(lex))
			
			return new GeracaoTokenTo(new Token(TipoToken.NUMBER, lex));

		return null;

	}
	
}
