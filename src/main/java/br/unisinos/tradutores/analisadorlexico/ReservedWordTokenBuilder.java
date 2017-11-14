package br.unisinos.tradutores.analisadorlexico;
import java.util.Arrays;

import br.unisinos.tradutores.domain.TipoToken;
import br.unisinos.tradutores.domain.Token;

public class ReservedWordTokenBuilder {

	private static final String[] PALAVRAS_RESERVADAS = { "ENTAO","APOS", "FRENTE", "ESQUERDA", "DIREITA", "TRAS"};

	public static GeracaoTokenTo verify(String lexema) {

		String lex = lexema.trim();

		if (Arrays.asList(PALAVRAS_RESERVADAS).contains(lex))
			return new GeracaoTokenTo(new Token(TipoToken.RESERVED_WORD, lex));

		return null;

	}
}
