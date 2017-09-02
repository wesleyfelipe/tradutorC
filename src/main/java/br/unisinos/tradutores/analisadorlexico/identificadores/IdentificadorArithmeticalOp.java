package br.unisinos.tradutores.analisadorlexico.identificadores;

import java.util.Arrays;

import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class IdentificadorArithmeticalOp {

	private static String[] OPERADORES_ARITMETICOS = { "+", "-", "*", "/", "%" };

	public static Token verify(String lexema) {
		
		String lex = lexema.trim();

		if (Arrays.asList(OPERADORES_ARITMETICOS).contains(lex))
			return new Token(TipoToken.ARITHMETICAL_OP, lexema);

		return null;

	}

}
