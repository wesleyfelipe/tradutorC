package br.unisinos.tradutores.analisadorlexico.identificadores;

import java.util.Arrays;

import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class IndetificadorReservedWord {

	private static final String[] PALAVRAS_RESERVADAS = { "do", "while", "if", "else", "switch", "for", "return",
			"null", "int", "float", "double", "string", "bool" };

	public static Token verify(String lexema) {

		String lex = lexema.trim();

		if (Arrays.asList(PALAVRAS_RESERVADAS).contains(lex))
			return new Token(TipoToken.RESERVED_WORD, lex);

		return null;

	}
}
