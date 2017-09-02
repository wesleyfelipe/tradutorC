package br.unisinos.tradutores.analisadorlexico.geradorestoken;

import br.unisinos.tradutores.analisadorlexico.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class GeradorIdentificadorFunctionToken {

	public static GeracaoTokenTo verify(String lexema, String proximoLexema) {

		if(GeradorIdToken.isIdentificadorVariavel(lexema) && GeradorOtherCharacterToken.isLParen(proximoLexema))
			return new GeracaoTokenTo(new Token(TipoToken.FUNCTION, lexema));

		return null;

	}
	
}
