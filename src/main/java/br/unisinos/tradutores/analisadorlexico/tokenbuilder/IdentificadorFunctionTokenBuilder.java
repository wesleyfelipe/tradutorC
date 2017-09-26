package br.unisinos.tradutores.analisadorlexico.tokenbuilder;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.pojo.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;

public class IdentificadorFunctionTokenBuilder {

	public static GeracaoTokenTo verify(String lexema, String proximoLexema) {

		if(IdTokenBuilder.isIdentificadorVariavel(lexema) && OtherCharacterTokenBuilder.isLParen(proximoLexema))
			return new GeracaoTokenTo(new Token(TipoToken.FUNCTION, lexema));

		return null;

	}
	
}
