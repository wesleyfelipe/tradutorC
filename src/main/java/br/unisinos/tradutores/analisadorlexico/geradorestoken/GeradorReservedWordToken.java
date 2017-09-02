package br.unisinos.tradutores.analisadorlexico.geradorestoken;

import java.util.Arrays;

import br.unisinos.tradutores.analisadorlexico.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class GeradorReservedWordToken {

	private static final String[] PALAVRAS_RESERVADAS = { "do", "while", "if", "else", "switch", "for", "return",
			"null", "int", "float", "double", "string", "bool", "true", "false" };

	public static GeracaoTokenTo verify(String lexema) {

		String lex = lexema.trim();

		if (Arrays.asList(PALAVRAS_RESERVADAS).contains(lex))
			return new GeracaoTokenTo(new Token(TipoToken.RESERVED_WORD, lex));

		return null;

	}
}
