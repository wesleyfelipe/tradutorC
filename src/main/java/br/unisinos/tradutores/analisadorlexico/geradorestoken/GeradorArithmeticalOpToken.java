package br.unisinos.tradutores.analisadorlexico.geradorestoken;

import java.util.Arrays;

import br.unisinos.tradutores.analisadorlexico.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class GeradorArithmeticalOpToken {

	private static String[] OPERADORES_ARITMETICOS = { "+", "-", "*", "/", "%" };

	public static GeracaoTokenTo verify(String lexema) {
		
		String lex = lexema.trim();

		if (Arrays.asList(OPERADORES_ARITMETICOS).contains(lex))
			return new GeracaoTokenTo(new Token(TipoToken.ARITHMETICAL_OP, lexema));

		return null;

	}

}
