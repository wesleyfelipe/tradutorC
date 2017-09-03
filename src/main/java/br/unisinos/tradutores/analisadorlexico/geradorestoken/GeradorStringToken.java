package br.unisinos.tradutores.analisadorlexico.geradorestoken;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.pojo.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;

public class GeradorStringToken {

	public static GeracaoTokenTo verify(String lexema) {

		if(lexema.startsWith("\"") && lexema.endsWith("\""))
			return new GeracaoTokenTo(new Token(TipoToken.LITERAL_STRING, lexema));

		return null;

	}
	
}
