package br.unisinos.tradutores.analisadorlexico.geradorestoken;

import java.util.Arrays;

import br.unisinos.tradutores.analisadorlexico.GeracaoTokenTo;
import br.unisinos.tradutores.analisadorlexico.Token;
import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class GeradorRelationalOpToken {
	
	private static final String[] OPERADORES = {"==", "<", "<=", "!=", ">=", ">"};

	public static GeracaoTokenTo verify(String lexema, String proximoLexema) {

		String temp = lexema + proximoLexema;
				
		if(Arrays.asList(OPERADORES).contains(temp))
			return new GeracaoTokenTo(new Token(TipoToken.RELATIONAL_OP, temp), Boolean.TRUE);
		
		if(Arrays.asList(OPERADORES).contains(lexema))
			return new GeracaoTokenTo(new Token(TipoToken.RELATIONAL_OP, lexema));

		return null;

	}
	
}
