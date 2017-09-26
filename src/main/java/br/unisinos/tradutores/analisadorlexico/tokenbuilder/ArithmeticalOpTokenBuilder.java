package br.unisinos.tradutores.analisadorlexico.tokenbuilder;

import java.util.Arrays;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;
import br.unisinos.tradutores.analisadorlexico.pojo.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.pojo.Token;

public class ArithmeticalOpTokenBuilder {

	private static String[] OPERADORES_ARITMETICOS = { "+", "-", "*", "/", "%" };

	public static GeracaoTokenTo verify(String lexema) {
		
		String lex = lexema.trim();

		if (Arrays.asList(OPERADORES_ARITMETICOS).contains(lex))
			return new GeracaoTokenTo(new Token(TipoToken.ARITHMETICAL_OP, lexema));

		return null;

	}

}
