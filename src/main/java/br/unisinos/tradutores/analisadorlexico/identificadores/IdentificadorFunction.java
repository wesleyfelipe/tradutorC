package br.unisinos.tradutores.analisadorlexico.identificadores;

import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class IdentificadorFunction {

	public static Token verify(String lexema, String proximoLexema) {

		if(IdentificadorId.isIdentificadorVariavel(lexema) && IdentificadorOtherCharacter.isLParen(proximoLexema))
			return new Token(TipoToken.FUNCTION, lexema);

		return null;

	}
	
}
