package br.unisinos.tradutores.analisadorlexico.identificadores;

import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class IdentificadorString {

	public static Token verify(String lexema) {

		if(lexema.startsWith("\"") && lexema.endsWith("\""))
			return new Token(TipoToken.LITERAL_STRING, lexema);

		return null;

	}
	
}
